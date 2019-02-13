package com.magic.platform.framework.config.httppool;

import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: zyn
 * @Description: customize rest template with an interceptor
 * @Date: Created in 2018-10-27 09:09
 * @Modified By:
 */
@Component
public class CustomRestTemplateCustomizer implements RestTemplateCustomizer {

  @Override
  public void customize(RestTemplate restTemplate) {
    restTemplate.getInterceptors().add(new CustomClientHttpRequestInterceptor());
  }
}
