package com.magic.platform.framework.config.transaction;

import com.magic.platform.framework.config.druid.DruidConfiguration;
import java.util.Collections;
import javax.annotation.Resource;
import javax.sql.DataSource;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2018-10-24 09:09
 * @Modified By:
 */
@Getter
@Setter
@Configuration
public class TransactionConfiguration {


  private static final String CUSTOM_TRANSACTION_INTERCEPTOR_NAME = "customTransactionInterceptor";
  public static final String CUSTOM_PLATFORM_TRANSACTION_MANAGER_NAME = "platformTransactionManager";
  private static final String CUSTOM_BEAN_NAME_AUTO_PROXY_CREATOR_NAME = "beanNameAutoProxyCreator";




  /**
   * 默认只对 "*Service" , "*ServiceImpl" Bean 进行事务处理,"*"表示模糊匹配, 比如 : userService,orderServiceImpl
   */
  private static final String[] DEFAULT_TRANSACTION_BEAN_NAMES = {"*Service", "*ServiceImpl"};
  /**
   * 可传播事务配置
   */
  private static final String[] DEFAULT_REQUIRED_METHOD_RULE_TRANSACTION_ATTRIBUTES = {
      "add*",
      "save*",
      "insert*",
      "delete*",
      "update*",
      "stop*",
      "modiify*",
      "edit*",
      "batch*",
      "create*",
      "remove*",
  };

  /**
   * 默认的只读事务
   */
  private static final String[] DEFAULT_READ_ONLY_METHOD_RULE_TRANSACTION_ATTRIBUTES = {
      "get*",
      "count*",
      "find*",
      "query*",
      "select*",
      "list*",
      "*",
  };

  /**
   * 自定义事务 BeanName 拦截
   */
  private String[] customTransactionBeanNames = {};
  /**
   * 自定义方法名的事务属性相关联,可以使用通配符(*)字符关联相同的事务属性的设置方法; 只读事务
   */
  private String[] customReadOnlyMethodRuleTransactionAttributes = {};
  /**
   * 自定义方法名的事务属性相关联,可以使用通配符(*)字符关联相同的事务属性的设置方法; 传播事务(默认的)
   * {@link org.springframework.transaction.annotation.Propagation#REQUIRED}
   */
  private String[] customRequiredMethodRuleTransactionAttributes = {};

  @Resource(name = DruidConfiguration.DATASOURCE_NAME)
  private DataSource dataSource;

  /**
   * 事务管理器
   * @return
   */
  @Bean(name = CUSTOM_PLATFORM_TRANSACTION_MANAGER_NAME)
  public PlatformTransactionManager platformTransactionManager() {
    return new DataSourceTransactionManager(this.dataSource);
  }


  /**
   * 配置事务拦截器，注意：transactionInterceptor 名称的 bean 可能已经存在，导致该生成 bean 的方法不能执行，所以定义成另外一个名字
   * @param platformTransactionManager 事务管理器
   * @return
   */
  @Bean(name = CUSTOM_TRANSACTION_INTERCEPTOR_NAME)
  public TransactionInterceptor customTransactionInterceptor(@Qualifier(CUSTOM_PLATFORM_TRANSACTION_MANAGER_NAME) PlatformTransactionManager platformTransactionManager) {

    NameMatchTransactionAttributeSource transactionAttributeSource = new NameMatchTransactionAttributeSource();
    RuleBasedTransactionAttribute readOnly                   = this.readOnlyTransactionRule();
    RuleBasedTransactionAttribute required                   = this.requiredTransactionRule();
    // 默认的只读事务配置

    for (String methodName : DEFAULT_READ_ONLY_METHOD_RULE_TRANSACTION_ATTRIBUTES) {
      transactionAttributeSource.addTransactionalMethod(methodName, readOnly);
    }

    // 默认的传播事务配置
    for (String methodName : DEFAULT_REQUIRED_METHOD_RULE_TRANSACTION_ATTRIBUTES) {
      transactionAttributeSource.addTransactionalMethod(methodName, required);
    }

    // 定制的只读事务配置
    for (String methodName : customReadOnlyMethodRuleTransactionAttributes) {
      transactionAttributeSource.addTransactionalMethod(methodName, readOnly);
    }

    // 定制的传播事务配置
    for (String methodName : customRequiredMethodRuleTransactionAttributes) {
      transactionAttributeSource.addTransactionalMethod(methodName, required);
    }

    return new TransactionInterceptor(platformTransactionManager, transactionAttributeSource);
  }

  /**
   * 当前存在事务就使用当前事务，当前不存在事务就创建一个新的事务 {@link org.springframework.transaction.annotation.Propagation#REQUIRED}
   */
  private RuleBasedTransactionAttribute requiredTransactionRule() {
    RuleBasedTransactionAttribute required = new RuleBasedTransactionAttribute();
    required.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
    required.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
    required.setTimeout(TransactionDefinition.TIMEOUT_DEFAULT);

    return required;
  }

  /**
   * 只读事务 {@link org.springframework.transaction.annotation.Propagation#NOT_SUPPORTED}
   */
  private RuleBasedTransactionAttribute readOnlyTransactionRule() {
    RuleBasedTransactionAttribute readOnly = new RuleBasedTransactionAttribute();
    readOnly.setReadOnly(true);
    readOnly.setPropagationBehavior(TransactionDefinition.PROPAGATION_NOT_SUPPORTED);

    return readOnly;
  }

  /**
   * 配置事务拦截
   * <p>
   * {@link #customTransactionInterceptor(PlatformTransactionManager)}
   */
  @Bean(name = CUSTOM_BEAN_NAME_AUTO_PROXY_CREATOR_NAME)
  public BeanNameAutoProxyCreator customTransactionBeanNameAutoProxyCreator() {
    BeanNameAutoProxyCreator beanNameAutoProxyCreator = new BeanNameAutoProxyCreator();
    // 设置定制的事务拦截器
    beanNameAutoProxyCreator.setInterceptorNames(CUSTOM_TRANSACTION_INTERCEPTOR_NAME);

    // 默认 + 定制
    String[] unions = ArrayUtils.addAll(DEFAULT_TRANSACTION_BEAN_NAMES, customTransactionBeanNames);
    beanNameAutoProxyCreator.setBeanNames(unions);
    beanNameAutoProxyCreator.setProxyTargetClass(true);

    return beanNameAutoProxyCreator;
  }
}
