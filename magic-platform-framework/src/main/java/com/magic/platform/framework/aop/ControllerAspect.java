package com.magic.platform.framework.aop;

import com.magic.platform.core.model.ResponseModel;
import java.util.Arrays;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @Author: zhangyn
 * @Description:
 * @Date: Created in 2018-05-21 10:10
 * @Modified By:
 */
@Slf4j
@Aspect
@Configuration
public class ControllerAspect {


  /**
   * 两个点 .. 表示该包及其子包下
   */
  @Pointcut(value = "execution(* com.magic.platform..controller..*.*(..))")
  public void controllerMethod() {}

  /**
   * 方法执行前
   * @param jp
   */
  @Before("controllerMethod()")
  public void doBefore(JoinPoint jp) {
    try {
      String targetClassName = jp.getTarget().getClass().getName();
      String methodName = jp.getSignature().getName();
      String args = Arrays.toString(jp.getArgs());
      // 获取代理目标类自己的 logger
      Logger logger = LoggerFactory.getLogger(targetClassName);

      logger.info(">>>：{}.{}({}) begin", targetClassName, methodName, args.substring(1, args.length() - 1));
    } catch (Exception e) {
      log.error("ControllerAspect.controllerMethodBefore exception:", e);
    }

  }


  /**
   * 方法执行后
   * @param jp
   */
  @After("controllerMethod()")
  public void doAfter(JoinPoint jp) {
    try {
      String targetClassName = jp.getTarget().getClass().getName();
      String methodName = jp.getSignature().getName();
      String args = Arrays.toString(jp.getArgs());
      // 获取代理目标类自己的 logger
      Logger logger = LoggerFactory.getLogger(targetClassName);

      logger.info(">>>：{}.{}({}) end", targetClassName, methodName, args.substring(1, args.length() - 1));
    } catch (Exception e) {
      log.error("ControllerAspect.controllerMethodAfter exception:", e);
    }

  }

  /**
   * 方法异常处理 FIXME: 注意避免与 ExceptionHandler 重复处理异常
   * @param jp
   * @param exception
   */
  @AfterThrowing(value = "controllerMethod()", throwing = "exception")
  public void doAfterThrowing(JoinPoint jp, Throwable exception) {

    try {
      String targetClassName = jp.getTarget().getClass().getName();
      String methodName = jp.getSignature().getName();
      String args = Arrays.toString(jp.getArgs());
      // 获取代理目标类自己的 logger
      Logger logger = LoggerFactory.getLogger(targetClassName);

      logger.info(">>>：{}.{}({}) exception: {}", targetClassName, methodName, args.substring(1, args.length() - 1), exception.getMessage());
    } catch (Exception e) {
      log.error("ControllerAspect.controllerMethodAfter exception:", e);
    }
  }

  /**
   * 方法返回
   * @param joinPoint
   * @param object
   */
  @AfterReturning(value = "controllerMethod()", returning = "object")
  public void doAfterReturning(JoinPoint joinPoint, Object object) {

    // 使用 RequestContextHolder 获取 request
    ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    HttpServletRequest request = requestAttributes.getRequest();

    if (object instanceof ResponseModel) {
      ((ResponseModel) object).setTimestamp(new Date());
      ((ResponseModel) object).setPath(request.getRequestURI());
    }
  }

//  @Around("controllerMethod()")
//  public void doAround(ProceedingJoinPoint jp) {
//
//  }
}
