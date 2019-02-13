package com.magic.platform.support.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2018-10-20 09:09
 * @Modified By:
 */
@Data
@Configuration
@PropertySource(value = "classpath:env/http.properties", ignoreResourceNotFound = true, encoding = "UTF-8")
@ConfigurationProperties(prefix = "http")
public class HttpPoolProperties {

  /**
   * 设置最大连接数
   */
  private int maxTotal;

  /**
   * 设置每个主机地址的并发数
   */
  private int defaultMaxPerRoute;

  /**
   * //连接上服务器(握手成功)的时间，超出抛出connect timeout
   */
  private int connectTimeout;

  /**
   * 从连接池中获取连接的超时时间，超时间未拿到可用连接，会抛出org.apache.http.conn.ConnectionPoolTimeoutException: Timeout waiting for connection from pool
   */
  private int connectionRequestTimeout;

  /**
   * 服务器返回数据(response)的时间，超过抛出read timeout
   */
  private int socketTimeout;

  /**
   * 提交请求前测试连接是否可用
   */
  private boolean staleConnectionCheckEnabled;

  /**
   * 定义不活动的时间段（以毫秒为单位），之后必须在租用给使用者之前重新验证持久连接
   */
  private int validateAfterInactivity;
}
