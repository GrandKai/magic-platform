package com.magic.platform.dubbo.provider.business.controller;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2019-01-15 16:16
 * @Modified By:
 */
public class TestServiceTask implements JavaDelegate {

  @Override
  public void execute(DelegateExecution execution) {
    System.out.println("hello activiti");
  }
}
