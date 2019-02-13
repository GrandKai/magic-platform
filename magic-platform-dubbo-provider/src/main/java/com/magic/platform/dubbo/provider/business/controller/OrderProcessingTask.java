package com.magic.platform.dubbo.provider.business.controller;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2019-01-21 09:09
 * @Modified By:
 */
public class OrderProcessingTask implements JavaDelegate {

  @Override
  public void execute(DelegateExecution execution) {
    System.out.println("订单正在处理中...");
  }
}
