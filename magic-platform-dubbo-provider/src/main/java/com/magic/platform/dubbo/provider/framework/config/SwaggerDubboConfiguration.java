package com.magic.platform.dubbo.provider.framework.config;

import com.deepoove.swagger.dubbo.annotations.EnableDubboSwagger;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: zyn
 * @Description: PropertySource 配合 Configuration一起使用将属性注入到 Spring's Environment
 *                这里不重写 addResourceHandler 方法的原因是，在 SwaggerConfiguration 中已经
 *                将 classpath:/META-INF/resources/ 添加到了静态资源目录，当访问 swagger-dubbo-ui.html 时
 *                默认去 classpath:/META-INF/resources/ 目录下查找对应的 html
 * @Date: Created in 2018-10-31 11:11
 * @Modified By:
 */
@Configuration
@EnableDubboSwagger
@PropertySource(value = "classpath:env/swagger-dubbo.properties", ignoreResourceNotFound = true, encoding = "UTF-8")
public class SwaggerDubboConfiguration implements WebMvcConfigurer {

//  @Override
//  public void addResourceHandlers(ResourceHandlerRegistry registry) {
//    registry.addResourceHandler("swagger-dubbo-ui.html")
//        .addResourceLocations("classpath:/META-INF/resources/");
//  }
  
}
