package com.magic.platform.framework.config.mongo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2018-10-15 16:16
 * @Modified By:
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "mongo")
@PropertySource(value = "classpath:env/mongo.properties", ignoreResourceNotFound = true, encoding = "UTF-8")
public class MongoDbProperties {

  private String uri = "mongodb://localhost/test";

}
