package com.magic.platform.dubbo.provider.framework.config;

import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.magic.platform.framework.config.dubbo.DubboProperties;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: zyn
 * @Description: 必须配置扫描路径 - 否则无法加载 dubbo
 * @Date: Created in 2018-10-10 14:14
 * @Modified By:
 */
@Configuration
@DubboComponentScan(basePackages = "${dubbo.scan-package}")
@EnableConfigurationProperties(DubboProperties.class)
public class DubboProviderConfiguration implements DisposableBean {

  @Autowired
  private DubboProperties dubboProperties;

//  /**
//   * 当前应用配置
//   * @return ApplicationConfig
//   */
//  @Bean(name = "DubboProviderApplicationConfig")
//  public ApplicationConfig applicationConfig() {
//    ApplicationConfig config = new ApplicationConfig();
//    config.setName(dubboProperties.getApplicationName());
//    return config;
//  }
//
//  /**
//   * 连接注册中心配置
//   * @return RegistryConfig
//   */
//  @Bean(name = "DubboProviderRegistryConfig")
//  public RegistryConfig registryConfig() {
//    RegistryConfig registryConfig = new RegistryConfig();
//    registryConfig.setAddress(dubboProperties.getRegistryAddress());
//    registryConfig.setGroup(dubboProperties.getRegistryGroup());
//    registryConfig.setClient("curator");
//    return registryConfig;
//  }

  /**
   * 服务提供者【协议】配置
   * @return ProtocolConfig
   */
  @Bean
  public ProtocolConfig protocolConfig() {
    ProtocolConfig protocolConfig = new ProtocolConfig();
    protocolConfig.setName(dubboProperties.getProtocolName());
    protocolConfig.setPort(dubboProperties.getProtocolPort());
    protocolConfig.setThreads(dubboProperties.getProtocolThreads());

    return protocolConfig;
  }

  /**
   * 服务提供者配置
   * @return ProviderConfig
   */
  @Bean
  public ProviderConfig providerConfig() {
    ProviderConfig providerConfig = new ProviderConfig();
    providerConfig.setGroup(dubboProperties.getProviderGroup());
    providerConfig.setVersion(dubboProperties.getProviderVersion());
    providerConfig.setTimeout(dubboProperties.getTimeout());

    return providerConfig;
  }

  @Override
  public void destroy() throws Exception {
    ProtocolConfig.destroyAll();
    RegistryConfig.destroyAll();
  }
}
