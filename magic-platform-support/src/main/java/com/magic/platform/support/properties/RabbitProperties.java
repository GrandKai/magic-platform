package com.magic.platform.support.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2018-10-17 15:15
 * @Modified By:
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "rabbit")
@PropertySource(value = "classpath:env/rabbit.properties", ignoreResourceNotFound = true, encoding = "UTF-8")
public class RabbitProperties {

  private String exchangeName;
  private String queueName;
  private String routingKey;

  private String addresses;
  private String password;
  private String username;
  private String virtualHost;

  private boolean exposeListenerChannel;
  private int maxConcurrentConsumers;
  private int concurrentConsumers;
  private int prefetchCount;
}
