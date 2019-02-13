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
@ConfigurationProperties(prefix = "mysql-slave")
@PropertySource(value = "classpath:env/mysql-slave.properties", ignoreResourceNotFound = true, encoding = "UTF-8")
@Configuration
public class MySQLSlaveProperties {

    private String url = "jdbc:mysql://localhost:3306/auth?useUnicode=true&characterEncoding=utf8";
    private String username = "root";
    private String password = "mysql";
    private String driverClassName = "com.mysql.jdbc.Driver";
}
