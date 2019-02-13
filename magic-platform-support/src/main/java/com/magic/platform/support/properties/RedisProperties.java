package com.magic.platform.support.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2018-10-16 14:14
 * @Modified By:
 */
@Getter
@Setter
@Configuration
@PropertySource(value = "classpath:env/redis.properties", ignoreResourceNotFound = true, encoding = "UTF-8")
@ConfigurationProperties(prefix = "redis")
public class RedisProperties {

  private Integer validTimeSecondAccessToken;
  private Integer validTimeSecondRefreshToken;
}
