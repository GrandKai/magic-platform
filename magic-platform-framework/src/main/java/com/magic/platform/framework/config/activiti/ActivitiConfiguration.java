package com.magic.platform.framework.config.activiti;

import com.magic.platform.framework.config.druid.DruidSlaveConfiguration;
import com.magic.platform.framework.config.transaction.TransactionConfiguration;
import java.io.IOException;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.DynamicBpmnService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2019-01-11 10:10
 * @Modified By:
 */
@Slf4j
@Configuration
@ConditionalOnExpression("${framework.config.activiti.enable: false}")
public class ActivitiConfiguration {

  @Bean
  public ProcessEngineConfiguration processEngineConfiguration(
      @Qualifier(TransactionConfiguration.CUSTOM_PLATFORM_TRANSACTION_MANAGER_NAME) PlatformTransactionManager platformTransactionManager,
      @Qualifier(DruidSlaveConfiguration.DATASOURCE_NAME) DataSource dataSource) {

    SpringProcessEngineConfiguration configuration = new SpringProcessEngineConfiguration();
    configuration.setTransactionManager(platformTransactionManager);
    configuration.setDataSource(dataSource);
    configuration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
    configuration.setProcessEngineName("default");


    //自动部署已有的流程文件
    String resourcesLocation = ResourceLoader.CLASSPATH_URL_PREFIX + "processes/*.bpmn*.xml";

    Resource[] resources = null;
    try {
      ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
      resources = resolver.getResources(resourcesLocation);
    } catch (IOException e) {
      log.error("未获取到流程文件，文件位置：{}，异常信息：{}", resourcesLocation, e);
    }
    if (resources != null) {
      configuration.setDeploymentResources(resources);
    }

    return configuration;
  }

  @Bean
  public ProcessEngine processEngine(ProcessEngineConfiguration processEngineConfiguration) {

    ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();

    String pName = processEngine.getName();
    String ver = ProcessEngine.VERSION;
    log.warn("流程引擎名称-ProcessEngine [" + pName + "] 流程引擎版本-Version: [" + ver + "]");

    return processEngine;
  }

  @Bean
  public RepositoryService repositoryService(ProcessEngine processEngine) {
    return processEngine.getRepositoryService();
  }


  @Bean
  public RuntimeService runtimeService(ProcessEngine processEngine) {
    return processEngine.getRuntimeService();
  }

  @Bean
  public TaskService taskService(ProcessEngine processEngine) {
    return processEngine.getTaskService();
  }

  @Bean
  public HistoryService historyService(ProcessEngine processEngine) {
    return processEngine.getHistoryService();
  }

  @Bean
  public ManagementService managementService(ProcessEngine processEngine) {
    return processEngine.getManagementService();
  }

  @Bean
  public DynamicBpmnService dynamicBpmnService(ProcessEngine processEngine) {
    return processEngine.getDynamicBpmnService();
  }
}
