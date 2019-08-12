package com.magic.platform.framework.config.mongo;

import com.magic.platform.framework.util.MongoPageHelper;
import com.mongodb.MongoClientURI;
import java.net.UnknownHostException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2018-10-15 16:16
 * @Modified By:
 */
@Configuration
@EnableConfigurationProperties(MongoDbProperties.class)
@ConditionalOnExpression("${framework.config.mongo.enable: false}")
public class MongoConfiguration {

  public static final String BASE_PACKAGES = "com.magic.platform.**.mongo.dao";


  @EnableMongoRepositories(basePackages = {MongoConfiguration.BASE_PACKAGES})
  public static class MongoAutoConfig {

  };


  @Autowired
  private MongoDbProperties mongoDbProperties;

  @Autowired
  private ApplicationContext applicationContext;


  @Bean
  public MongoDbFactory mongoDbFactory() throws UnknownHostException {

    MongoClientURI mongoClientURI = new MongoClientURI(mongoDbProperties.getUri());
    MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(mongoClientURI);

    return mongoDbFactory;
  }

  /**
   * 调用 mongoTemplate 的save方法时
   * spring-data-mongodb 的 TypeConverter 会自动给 Document 添加一个 _class
   * spring-data-mongodb 是为了在把 Document 转换成 Java 对象时能够转换到具体的子类
   * @return
   * @throws UnknownHostException
   */
  @Bean
  public MappingMongoConverter mappingMongoConverter() throws UnknownHostException {
    DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDbFactory());
    MongoMappingContext mappingContext = new MongoMappingContext();
    mappingContext.setApplicationContext(applicationContext);

    MappingMongoConverter mappingMongoConverter = new MappingMongoConverter(dbRefResolver, mappingContext);
//    CustomConversions conversions = new CustomConversions(null);
//    mappingMongoConverter.setCustomConversions(conversions);

    mappingMongoConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
    return mappingMongoConverter;
  }

  @Bean
  public MongoTemplate mongoTemplate() throws UnknownHostException {
//    MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
    MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory(), mappingMongoConverter());

    return mongoTemplate;
  }

  /**
   * 设置 mongodb page helper 工具类
   * @return
   * @throws UnknownHostException
   */
  @Bean
  public MongoPageHelper mongoPageHelper() throws UnknownHostException {
    return new MongoPageHelper(mongoTemplate());
  }


}
