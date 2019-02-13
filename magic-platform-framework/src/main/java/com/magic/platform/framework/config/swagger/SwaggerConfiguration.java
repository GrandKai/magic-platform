package com.magic.platform.framework.config.swagger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: zyn
 * @Description: 生产环境禁用，设置为false即可
 * @Date: Created in 2018-09-28 14:14
 * @Modified By:
 */
@Configuration
@EnableSwagger2
@ConditionalOnExpression("${framework.config.swagger.enable: false}")
public class SwaggerConfiguration implements WebMvcConfigurer {

  @Value("${framework.config.swagger.scan-package}")
  private String basePackage;

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/webjars/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/");

    registry.addResourceHandler("swagger-ui.html")
        .addResourceLocations("classpath:/META-INF/resources/");
  }

  /**
   * buildDocket() 用于创建 Docket 的 Bean，
   * buildApiInfo() 创建 Api 的基本信息，用于显示在文档页面上。
   * select() 函数返回一个 `ApiSelectorBuilder` 实例，用来控制哪些接口暴露给 Swagger2 来展现。
   * 一般采用指定扫描的包路径来定义，本例中 Swagger 会扫描 controller 包下所有定义的API，
   * 并产生文档内容（除了被 @ApiIgnore 指定的请求）。
   * @return
   */
  @Bean
  public Docket buildDocket() {

    Docket docket = new Docket(DocumentationType.SWAGGER_2).apiInfo(buildApiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage(basePackage))
        .paths(PathSelectors.any())
        .build();

    return docket;
  }

  private Contact contact() {
    return new Contact("GrandKai","https://www.jianshu.com/u/9de0ad0f99bc", "GrandKai@aliyun.com");
  }

  private ApiInfo buildApiInfo() {
    return new ApiInfoBuilder()
        .title("Magic Platform APIS")
        .description("框架接口信息")
        .version("1.0.0")
        .contact(contact())
        .build();
  }
}
