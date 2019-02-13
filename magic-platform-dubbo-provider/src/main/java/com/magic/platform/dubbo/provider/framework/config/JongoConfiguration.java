package com.magic.platform.dubbo.provider.framework.config;

import com.mongodb.DB;
import org.jongo.Jongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2018-11-01 16:16
 * @Modified By:
 */
@Configuration
@ConditionalOnExpression("${framework.config.mongo.enable: false}")
public class JongoConfiguration {


  @Autowired
  private MongoDbFactory mongoDbFactory;

  @Bean
  public Jongo jongo() {

    DB database = mongoDbFactory.getLegacyDb();
    return new Jongo(database);
  }
}
