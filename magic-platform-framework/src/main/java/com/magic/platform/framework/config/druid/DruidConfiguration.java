package com.magic.platform.framework.config.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.magic.platform.support.properties.DruidProperties;
import com.magic.platform.support.properties.MySQLProperties;
import java.sql.SQLException;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.util.StringUtils;

/**
 * @author: GrandKai
 * @create: 2018-05-05 5:07 PM
 */
@Slf4j
@Configuration
@EnableConfigurationProperties({MySQLProperties.class, DruidProperties.class})
public class DruidConfiguration {

    public static final String DATASOURCE_NAME = "druidDataSource";

    private static final String INIT_METHOD = "init";
    private static final String DESTROY_METHOD = "close";

    @Autowired
    private MySQLProperties mySQLProperties;

    @Autowired
    private DruidProperties druidProperties;


    /**
     * 注册一个 StatViewServlet
     * @return
     */
    @Bean(name = "druidMasterStateViewServlet")
    public ServletRegistrationBean druidStateViewServlet() {
        // org.springframework.boot.context.embedded.ServletRegistrationBean 提供类的进行注册.
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();

        servletRegistrationBean.setServlet(new StatViewServlet());
        servletRegistrationBean.addUrlMappings("/druid/*");
        //添加初始化参数：initParams

        //登录查看信息的账号密码.
        servletRegistrationBean.addInitParameter("loginUsername", "admin");
        servletRegistrationBean.addInitParameter("loginPassword", "admin");
        // 白名单：
        servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
        // IP黑名单 (共存时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not permitted to view this page.
        servletRegistrationBean.addInitParameter("deny", "192.168.4.110");
        // 是否能够重置数据，禁用HTML页面上的“Reset All”功能
        servletRegistrationBean.addInitParameter("resetEnable", "false");

        return servletRegistrationBean;
    }

    @Bean(name = "druidMasterWebStateFilter")
    public FilterRegistrationBean druidWebStateFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();

        filterRegistrationBean.setFilter(new WebStatFilter());
        // 添加过滤规则
        filterRegistrationBean.addUrlPatterns("/*");
        //添加不需要忽略的格式信息
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");

        // druid 0.2.7版本开始支持profile，配置profileEnable能够监控单个url调用的sql列表。
        filterRegistrationBean.addInitParameter("profileEnable", "true");
        return filterRegistrationBean;
    }


    @Primary
    @Bean(name = DruidConfiguration.DATASOURCE_NAME)
    public DataSource druidDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(mySQLProperties.getUrl());
        dataSource.setDriverClassName(mySQLProperties.getDriverClassName());
        dataSource.setUsername(mySQLProperties.getUsername());
        dataSource.setPassword(mySQLProperties.getPassword());

        // 初始化连接大小
        dataSource.setInitialSize(druidProperties.getInitialSize());
        // 最小空闲连接数
        dataSource.setMinIdle(druidProperties.getMinIdle());
        // 最大连接数
        dataSource.setMaxActive(druidProperties.getMaxActive());
        dataSource.setMaxWait(druidProperties.getMaxWait());
        dataSource.setTimeBetweenEvictionRunsMillis(druidProperties.getTimeBetweenEvictionRunsMillis());
        dataSource.setMinEvictableIdleTimeMillis(druidProperties.getMinEvictableIdleTimeMillis());

        // 查询超时时间
//        dataSource.setQueryTimeout(druidProperties.getQueryTimeout());
        // 事务查询超时时间
//        dataSource.setTransactionQueryTimeout(druidProperties.getTransactionQueryTimeout());

        // 关闭空闲连接超时时间
//        dataSource.setRemoveAbandonedTimeout(druidProperties.getRemoveAbandonedTimeout());

        dataSource.setValidationQuery(druidProperties.getValidationQuery());

        dataSource.setTestOnBorrow(druidProperties.getTestOnBorrow());
        dataSource.setTestOnReturn(druidProperties.getTestOnReturn());
        dataSource.setTestWhileIdle(druidProperties.getTestWhileIdle());

        dataSource.setPoolPreparedStatements(druidProperties.getPoolPreparedStatements());
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(druidProperties.getMaxPoolPreparedStatementPerConnectionSize());
        if (!StringUtils.isEmpty(druidProperties.getFilters())) {
            try {
                dataSource.setFilters(druidProperties.getFilters());
            } catch (SQLException e) {
                log.error("数据源设置过滤器异常: {}", e);
            }
        }

        if (!StringUtils.isEmpty(druidProperties.getConnectionProperties())) {
            dataSource.setConnectProperties(druidProperties.getConnectionProperties());
        }

        if (!StringUtils.isEmpty(druidProperties.getUseGlobalDataSourceStat())) {
            dataSource.setUseGlobalDataSourceStat(druidProperties.getUseGlobalDataSourceStat());
        }
        return dataSource;
    }


}
