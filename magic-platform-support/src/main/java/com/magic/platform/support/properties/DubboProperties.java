package com.magic.platform.support.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author: zhangyn
 * @Description:
 * @Date: Created in 2018-07-11 09:09
 * @Modified By:
 */
@Getter
@Setter
@Configuration
@PropertySource(value = "classpath:env/dubbo.properties", ignoreResourceNotFound = true, encoding = "UTF-8")
@ConfigurationProperties(prefix = "dubbo")
public class DubboProperties {


  /**
   * 应用程序名称
   */
  private String applicationName = "测试应用程序名称";

  /**
   * 注册中心地址
   */
  private String registryAddress = "zookeeper://127.0.0.1:2181";

  /**
   * 注册中心组
   */
  private String registryGroup;

  /**
   * 服务提供者组
   */
  private String providerGroup;

  /**
   * 提供者版本
   */
  private String providerVersion = "v1.0.0";


  /**
   * 协议名称
   */
  private String protocolName = "dubbo";

  /**
   * 协议端口
   */
  private Integer protocolPort = 20882;

  /**
   * 协议线程数量
   */
  private Integer protocolThreads = 200;

  /**
   * 超时时间
   */
  private Integer timeout = 3000;

  /**
   * hessian 超时时间
   */
  private Integer hessianTimeout = 10000;

}
