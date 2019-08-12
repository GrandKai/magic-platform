package com.magic.platform.framework.config.httppool;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.StandardHttpRequestRetryHandler;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2018-10-20 09:09
 * @Modified By:
 */
@Configuration
@EnableConfigurationProperties(HttpPoolProperties.class)
@ConditionalOnExpression("${framework.config.httpPool.enable: false}")
public class HttpPoolConfiguration {

  public static final String POOL_MANAGER_NAME = "httpClientConnectionManager";
  public static final String HTTP_CLIENT_BUILDER_NAME = "httpClientBuilder";
  public static final String HTTP_CLIENT_NAME = "httpClient";
  public static final String HTTP_REQUEST_CONFIG_NAME = "requestConfig";

  @Autowired
  private HttpPoolProperties httpPoolProperties;

  @Autowired
  private CustomRestTemplateCustomizer customRestTemplateCustomizer;

  @Bean(name = POOL_MANAGER_NAME)
  public HttpClientConnectionManager httpClientConnectionManager() {

    Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
        .register("http", PlainConnectionSocketFactory.getSocketFactory())
        .register("https", SSLConnectionSocketFactory.getSocketFactory())
        .build();

    PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
    // 设置最大连接数
    connectionManager.setMaxTotal(httpPoolProperties.getMaxTotal());
    connectionManager.setValidateAfterInactivity(httpPoolProperties.getValidateAfterInactivity());
    // 设置每个主机地址的并发数
    connectionManager.setDefaultMaxPerRoute(httpPoolProperties.getDefaultMaxPerRoute());

    return connectionManager;
  }


  @Bean(name = HTTP_REQUEST_CONFIG_NAME)
  public RequestConfig requestConfig() {
    RequestConfig requestConfig = RequestConfig.custom()
        // 创建连接的最长时间
        .setConnectTimeout(httpPoolProperties.getConnectTimeout())
        // 从连接池中获取到连接的最长时间
        .setConnectionRequestTimeout(httpPoolProperties.getConnectionRequestTimeout())
        // 数据输出的最长时间
        .setSocketTimeout(httpPoolProperties.getSocketTimeout())
        // 提交请求前测试连接是否可用
        .setStaleConnectionCheckEnabled(httpPoolProperties.isStaleConnectionCheckEnabled()).build();

    return requestConfig;
  }

  @Bean(name = HTTP_CLIENT_BUILDER_NAME)
  public HttpClientBuilder httpClientBuilder() {
    HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
    httpClientBuilder.setConnectionManager(httpClientConnectionManager());
    httpClientBuilder.setDefaultRequestConfig(requestConfig());
    // 设置 retry
    httpClientBuilder.setRetryHandler(new StandardHttpRequestRetryHandler());

    return httpClientBuilder;
  }

  @Bean(name = HTTP_CLIENT_NAME)
  public HttpClient httpClient() {
    return httpClientBuilder().build();
  }

  @Bean
  public ClientHttpRequestFactory httpRequestFactory() {
    return new HttpComponentsClientHttpRequestFactory(httpClient());
  }

  @Bean
  public RestTemplate restTemplate() {
    RestTemplate restTemplate = restTemplateBuilder().errorHandler(new RestTemplateResponseErrorHandler()).build();

    return restTemplate;
//    return new RestTemplate(httpRequestFactory());
  }

  @Bean
  public RestTemplateBuilder restTemplateBuilder() {
    return new RestTemplateBuilder(this.customRestTemplateCustomizer).requestFactory(this::httpRequestFactory);
  }
}
