package com.magic.platform.framework.config.dubbo;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.magic.platform.support.properties.DubboProperties;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: zyn
 * @Description: http://dubbo.apache.org/zh-cn/docs/user/configuration/annotation.html
 * @Date: Created in 2018-10-10 14:14
 * @Modified By:
 */
@Configuration
@DubboComponentScan(basePackages = "${dubbo.scan-package}")
@EnableConfigurationProperties(DubboProperties.class)
@ConditionalOnExpression("${framework.config.dubbo.enable: false}")
public class DubboConsumerConfiguration implements DisposableBean {

  @Autowired
  private DubboProperties dubboProperties;

  /**
   * 当前应用配置
   * @return ApplicationConfig
   */
  @Bean
  public ApplicationConfig applicationConfig() {
    ApplicationConfig config = new ApplicationConfig();
    config.setName(dubboProperties.getApplicationName());
    return config;
  }

  /**
   * 连接注册中心配置
   * @return RegistryConfig
   */
  @Bean
  public RegistryConfig registryConfig() {
    RegistryConfig registryConfig = new RegistryConfig();
    registryConfig.setAddress(dubboProperties.getRegistryAddress());
    registryConfig.setGroup(dubboProperties.getRegistryGroup());
    registryConfig.setClient("curator");
    return registryConfig;
  }

  /**
   * 消费者配置
   * @return ConsumerConfig
   */
  @Bean
  public ConsumerConfig consumerConfig() {
    ConsumerConfig consumerConfig = new ConsumerConfig();
    consumerConfig.setGroup(dubboProperties.getProviderGroup());
    consumerConfig.setTimeout(dubboProperties.getTimeout());
    consumerConfig.setVersion(dubboProperties.getProviderVersion());
    return consumerConfig;
  }

  @Override
  public void destroy() throws Exception {
    RegistryConfig.destroyAll();
  }
}
