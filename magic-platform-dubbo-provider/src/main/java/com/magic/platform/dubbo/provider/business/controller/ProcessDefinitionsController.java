package com.magic.platform.dubbo.provider.business.controller;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2019-01-15 13:13
 * @Modified By:
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.activiti.api.process.model.ProcessDefinition;
import org.activiti.engine.DynamicBpmnService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ReST controller to interact with deployed process definitions
 *
 */
@Slf4j
@RestController
public class ProcessDefinitionsController {

  @Autowired
  RepositoryService repositoryService;
  @Autowired
  RuntimeService runtimeService;

  @Autowired
  ManagementService managementService;

  @Autowired
  DynamicBpmnService dynamicBpmnService;

  @Autowired
  TaskService taskService;


  @GetMapping("/process-definitions")
  public List<ProcessDefinition> getProcessDefinitions() {

    long count = repositoryService.createDeploymentQuery().count();
    log.error("调用流程存储服务，查询部署数量：{}", count);
//    deploymentBuilder.addClasspathR
//
//    DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
//    // 手动部署流程图（系统启动时自动部署了 resources/processes 下所有流程图）esource("processes/firstBPM.bpmn20.xml").deploy();
    //发起流程
//    runtimeService.startProcessInstanceByKey("firstBPM");

    String assignee = "kermit";//当前任务办理人

    Map<String, Object> variables = new HashMap<>();
    variables.put("laptopName", "戴尔");
    variables.put("laptopQuality", 1);
    variables.put("laptopNo", "No.123456");
    variables.put("customerName", "zyn");

    runtimeService.startProcessInstanceByKey("laptopHumanProcess", variables);

    List<Task> list = taskService.createTaskQuery().taskAssignee(assignee).list();
    for (Task task : list) {
      log.error("任务id: {}", task.getId());
      log.error("任务名称: {}", task.getName());
      log.error("任务创建时间: {}", task.getCreateTime());
      log.error("任务办理人: {}", task.getAssignee());
      log.error("任务流程实例id: {}", task.getProcessInstanceId());
    }

    return null;
  }
}
