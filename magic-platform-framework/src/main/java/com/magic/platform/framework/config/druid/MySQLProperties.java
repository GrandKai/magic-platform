package com.magic.platform.framework.config.druid;

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
@ConfigurationProperties(prefix = "mysql")
@PropertySource(value = "classpath:env/mysql.properties", ignoreResourceNotFound = true, encoding = "UTF-8")
public class MySQLProperties {

    private String url = "jdbc:mysql://localhost:3306/auth?useUnicode=true&characterEncoding=utf8";
    private String username = "root";
    private String password = "mysql";
    private String driverClassName = "com.mysql.jdbc.Driver";
}
