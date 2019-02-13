package com.magic.platform.framework.config.httppool;

import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

/**
 * @Author: zyn
 * @Description: interceptor to log incoming requests
 * @Date: Created in 2018-10-27 09:09
 * @Modified By:
 */
@Slf4j
public class CustomClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

      logRequestDetails(request);

      return execution.execute(request, body);
    }

    private void logRequestDetails(HttpRequest request) {
      log.error("==============================: http client Request Headers: {}", request.getHeaders());
      log.error("==============================: http client Request Method: {}", request.getMethod());
      log.error("==============================: http client Request URI: {}", request.getURI());
    }
}