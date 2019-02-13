package com.magic.platform.framework.config.jackson;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.magic.platform.util.DateUtil;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2018-09-17 22:22
 * @Modified By:
 */
@Configuration
public class JacksonConfiguration {

  @Bean
  public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
    MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
    ObjectMapper objectMapper = new ObjectMapper();

    // 忽略json字符串中不识别的属性
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    // 忽略无法转换的对象 “No serializer found for class com.xxx.xxx”
    objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

    // NULL不参与序列化
//    objectMapper.setSerializationInclusion(Include.NON_NULL);
    // PrettyPrinter 格式化输出
    objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

    // 指定时区，默认 UTC，而不是 jvm 默认时区
    TimeZone localTimeZone = TimeZone.getTimeZone("GMT+8:00");
    objectMapper.setTimeZone(localTimeZone);
    // 日期类型处理
    objectMapper.setDateFormat(new SimpleDateFormat(DateUtil.DEFAULT_FORMAT_DATETIME));

    converter.setObjectMapper(objectMapper);
    return converter;
  }

  /**
   * BeanPostProcessor 的便捷实现，以便对带注解的方法上执行方法级别的校验
   * 注意：需要在目标类上室友 @Validated 注解进行注释，以便搜索其内联约束注释的方法
   * A convenient BeanPostProcessor implementation
   * that delegates to a JSR-303 provider for performing method-level validation on annotated methods
   * @return
   */
  @Bean
  public MethodValidationPostProcessor methodValidationPostProcessor() {
    return new MethodValidationPostProcessor();
  }

}
