package com.magic.platform.framework.config.mybatis;

import com.magic.platform.framework.config.druid.DruidConfiguration;
import javax.annotation.Resource;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * mybatis 配置
 * @author: GrandKai
 * @create: 2018-05-06 3:47 PM
 */
@Slf4j
@Configuration
//@EnableTransactionManagement
//public class MybatisConfiguration implements TransactionManagementConfigurer {
public class MybatisConfiguration {

  /**
   * dao 类所在目录
   */
  public static final String BASE_PACKAGE = "com.magic.platform.**.mapper.**.dao";

  /**
   * 实体所在目录
   */
  public static final String TYPE_ALIASES_PACKAGE = "com.magic.platform.**.mapper.**.entity";

  /**
   * mapper.xml 所在目录（多个文件需要使用* TODO: 待验证）
   * 自动生成 build 目录, 自定义 custom 目录
   */
  public static final String MAPPER_LOCATION = "classpath*:mybatis/mapper/**/*Mapper.xml";


  public static final String CONFIG_LOCATION = "classpath:mybatis/mybatis-config.xml";


  /**
   * bean的名称
   */
  public static final String SQL_SESSION_FACTORY = "mysqlSqlSessionFactory";
  public static final String SQL_SESSION_TEMPLATE = "mysqlSqlSessionTemplate";


  @Resource(name = DruidConfiguration.DATASOURCE_NAME)
  private DataSource dataSource;

  /**
   * Mybatis sql会话工厂
   *
   * @param dataSource 数据源
   * @return SqlSessionFactory
   * @throws Exception 创建SqlSessionFactory发生异常
   */
  @Bean(name = SQL_SESSION_FACTORY)
  public SqlSessionFactory sqlSessionFactory(@Qualifier(DruidConfiguration.DATASOURCE_NAME) DataSource dataSource) throws Exception {
    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(dataSource);

    ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    // 需要加载的 mybatis 配置文件
    sqlSessionFactoryBean.setConfigLocation(resolver.getResource(CONFIG_LOCATION));

    // package to scan for domain objects(TODO: 别名设置？待验证)
    sqlSessionFactoryBean.setTypeAliasesPackage(TYPE_ALIASES_PACKAGE);

    SqlSessionFactory sqlSessionFactory = null;
    try {
      sqlSessionFactoryBean.setMapperLocations(resolver.getResources(MAPPER_LOCATION));
      sqlSessionFactory = sqlSessionFactoryBean.getObject();
    } catch (Exception e) {
      log.error("初始化 sqlSessionFactory 异常：{}", e);
    }
    return sqlSessionFactory;
  }

  @Bean(name = SQL_SESSION_TEMPLATE)
  public SqlSessionTemplate sqlSessionTemplate(@Qualifier(value = SQL_SESSION_FACTORY) SqlSessionFactory sqlSessionFactory) {
    return new SqlSessionTemplate(sqlSessionFactory);
  }


//  @Bean
//  public PlatformTransactionManager txManager() {
//    return new DataSourceTransactionManager(dataSource);
//  }
//
//  @Override
//  public PlatformTransactionManager annotationDrivenTransactionManager() {
//    return txManager();
//  }
}
