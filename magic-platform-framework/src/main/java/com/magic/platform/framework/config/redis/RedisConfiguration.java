package com.magic.platform.framework.config.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.charset.Charset;
import java.time.Duration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @Author: Administrator
 * @Description:
 * @Date: Created in 2019-08-12 08:08
 * @Modified By:
 */
@Slf4j
@Configuration
@ConditionalOnExpression("${framework.config.redis.enable: false}")
public class RedisConfiguration {

  @Autowired
  private Environment environment;

  @Bean
  public RedisConnectionFactory redisConnectionFactory() {
    String host = environment.getProperty("spring.redis.host", "localhost");
    String port = environment.getProperty("spring.redis.port", "6379");
    LettuceConnectionFactory connectionFactory = new LettuceConnectionFactory(host, Integer.valueOf(port));

    connectionFactory.setDatabase(3);
    return connectionFactory;
  }

  /**
   * // 在没有指定缓存Key的情况下，key生成策略
   * @return
   */
  @Bean
  public KeyGenerator keyGenerator() {
    return (target, method, params) -> {
      StringBuilder sb = new StringBuilder();
      sb.append(target.getClass().getName());
      sb.append(method.getName());
      for (Object obj : params) {
        sb.append(obj.toString());
      }
      return sb.toString();
    };
  }

  // 缓存管理器 使用Lettuce，和 jedis 有很大不同
  @Bean
  public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
    //关键点，spring cache 的注解使用的序列化都从这来，没有这个配置的话使用的 jdk 自己的序列化，实际上不影响使用，只是打印出来不适合人眼识别
    RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
        .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(keySerializer()))// key序列化方式
        .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(valueSerializer()))// value序列化方式
        .disableCachingNullValues()
        .entryTtl(Duration.ofSeconds(60));//缓存过期时间

    RedisCacheManager.RedisCacheManagerBuilder builder = RedisCacheManager.RedisCacheManagerBuilder
        .fromConnectionFactory(redisConnectionFactory)
        .cacheDefaults(config)
        .transactionAware();

    return builder.build();
  }

  @Bean
  public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
    RedisTemplate<String, Object> template = new RedisTemplate<>();
    template.setConnectionFactory(redisConnectionFactory);

    template.setKeySerializer(keySerializer());
    template.setValueSerializer(valueSerializer());

    template.setHashKeySerializer(keySerializer());
    template.setHashValueSerializer(valueSerializer());

    return template;
  }

  /**
   *
   // 使用StringRedisSerializer来序列化和反序列化redis的key值
   * @return
   */
  private RedisSerializer<String> keySerializer() {
    return new StringRedisSerializer(Charset.forName("UTF-8"));
  }

  /**
   *
   // 使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值（默认使用JDK的序列化方式）
   TODO: 需要测试如果对象中有 LinkedHashMap，会不会出错
   // GenericJackson2JsonRedisSerializer
   * @return
   */
  private RedisSerializer<Object> valueSerializer() {
    // 设置序列化
    Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
    ObjectMapper om = new ObjectMapper();
    om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
    om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
    jackson2JsonRedisSerializer.setObjectMapper(om);
    return jackson2JsonRedisSerializer;

    //或者使用GenericJackson2JsonRedisSerializer
    //return new GenericJackson2JsonRedisSerializer();
  }
}
