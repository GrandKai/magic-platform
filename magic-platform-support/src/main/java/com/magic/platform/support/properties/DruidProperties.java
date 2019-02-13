package com.magic.platform.support.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Properties;

/**
 * @author: GrandKai
 * @create: 2018-05-05 6:54 PM
 */
@Getter
@Setter
@Configuration
@PropertySource(value = "classpath:env/druid.properties", ignoreResourceNotFound = true, encoding = "UTF-8")
@ConfigurationProperties(prefix = "druid")
public class DruidProperties {

    private int maxActive = 200;
    private int initialSize = 8;
    private Long maxWait = 60000L;
    private int minIdle = 5;

    // 检测需要关闭空闲连接的间隔时间（毫秒）
    private Long timeBetweenEvictionRunsMillis = 60000L;
    // # 连接在池中最小生存时间（毫秒）
    private Long minEvictableIdleTimeMillis = 30000L;

    private int queryTimeout;
    // 事务查询超时时间
    private int transactionQueryTimeout;
    // 关闭空闲连接超时时间
    private int removeAbandonedTimeout;

    private Boolean testWhileIdle = true;
    private Boolean testOnBorrow = false;
    private Boolean testOnReturn = false;

    private Boolean poolPreparedStatements = true;
    private int maxOpenPreparedStatements = 20;
    private int maxPoolPreparedStatementPerConnectionSize = 20;

    // asyncInit 是 1.1.4 中新增加的配置，如果有 initialSize 数量较多时，打开会加快应用启动时间
    private Boolean asyncInit = true;

    private String validationQuery = "select 1";

    private String filters;
    private Properties connectionProperties;
    private Boolean useGlobalDataSourceStat;
}
