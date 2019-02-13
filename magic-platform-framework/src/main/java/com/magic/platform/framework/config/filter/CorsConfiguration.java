package com.magic.platform.framework.config.filter;

import java.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @Author: zyn
 * @Description: 跨越设置
 * @Date: Created in 2018-11-16 11:11
 * @Modified By:
 */
@Configuration
public class CorsConfiguration {

  private org.springframework.web.cors.CorsConfiguration buildCorsConfiguration() {
    org.springframework.web.cors.CorsConfiguration corsConfiguration = new org.springframework.web.cors.CorsConfiguration();
    corsConfiguration.addAllowedHeader("*");
    corsConfiguration.addAllowedMethod("*");
    corsConfiguration.addAllowedOrigin("*");
//    corsConfiguration.addExposedHeader("*");
    corsConfiguration.setAllowCredentials(true);

    // This allow us to expose the headers
    corsConfiguration.setExposedHeaders(
        Arrays.asList(
            "Access-Control-Allow-Headers",
            "Authorization, x-xsrf-token, Access-Control-Allow-Headers, Origin, Accept, X-Requested-With",
        "Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers"));


    return corsConfiguration;
  }


  @Bean(name = "customCorsFilter")
  public CorsFilter crosFilter() {

    UrlBasedCorsConfigurationSource configurationSource = new UrlBasedCorsConfigurationSource();
    configurationSource.registerCorsConfiguration("/**", buildCorsConfiguration());

    return new CorsFilter(configurationSource);
  }

/*  @Bean(name="customCorsFilter")
  public FilterRegistrationBean customCorsFilter() {
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    org.springframework.web.cors.CorsConfiguration config = new org.springframework.web.cors.CorsConfiguration();
    config.setAllowCredentials(true);
    config.addAllowedOrigin("*");
    config.addAllowedHeader("*");
    config.addAllowedMethod("*");
    source.registerCorsConfiguration("/**", config);
    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new CorsFilter(source));
    filterRegistrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
    return filterRegistrationBean;
  }*/

}
