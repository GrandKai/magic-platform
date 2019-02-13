package com.magic.platform.support.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author: GrandKai
 * @create: 2018-05-05 6:15 PM
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "framework")
@PropertySource(value = "classpath:env/framework.properties", ignoreResourceNotFound = true, encoding = "UTF-8")
public class FrameworkProperties {

    private String version;
}
