package com.magic.platform.framework.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.magic.platform.core.anotation.OpsLog;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2018-09-20 13:13
 * @Modified By:
 */
@Slf4j
@Configuration
@Aspect
public class OpsLogAspect {

  @Pointcut(value = "@annotation(com.magic.platform.core.anotation.OpsLog)")
  public void opsLogAnnotation() {
  }


  /**
   * 在切点之前织入
   */
  @Before(value = "opsLogAnnotation()")
  public void doBefore(JoinPoint joinPoint) throws Throwable {

    ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    HttpServletRequest request = attributes.getRequest();

    // 获取方法的签名
    MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
    OpsLog opsLog = methodSignature.getMethod().getAnnotation(OpsLog.class);
    String opsTypes = Arrays.toString(opsLog.type());

    String description = opsLog.type().length > 0 ? opsLog.value() + ", " + opsTypes : opsLog.value();

    // 打印请求相关参数
    log.info(
        "========================================== Start ==========================================");
    // 打印请求 url
    log.info("URL            : {}", request.getRequestURL().toString());
    // 打印描述信息
    log.info("Description    : {}", description);
    // 打印 Http method
    log.info("HTTP Method    : {}", request.getMethod());

    String args = Arrays.toString(joinPoint.getArgs());
    // 打印调用 controller 的全路径以及执行方法
    log.info("Class Method   : {}.{}({})", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), args.substring(1, args.length() - 1));
    // 打印请求的 IP
    log.info("IP             : {}", request.getRemoteAddr());
    // 打印请求入参
    log.info("Request Args   : {}", JSONArray.toJSONString(joinPoint.getArgs()));

  }

  @After("opsLogAnnotation()")
  public void doAfter() throws Throwable {
    // 接口结束后换行，方便分割查看
    log.info(
        "=========================================== End ==========================================="
            + System.lineSeparator());
  }

  @Around("opsLogAnnotation()")
  public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    long startTime = System.currentTimeMillis();
    Object result = proceedingJoinPoint.proceed();

    // 打印出参
    log.info("Response Args  : {}", JSON.toJSONString(result));
    // 执行耗时
    log.info("Time-Consuming : {} ms", System.currentTimeMillis() - startTime);
    return result;
  }




  /*@AfterReturning(pointcut = "opsLogAnnotation()", returning = "object")
  public void doAfterReturning(JoinPoint joinPoint, Object object) {

    // 获取方法的签名
    MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

    Method method = methodSignature.getMethod();
    OpsLog opsLog = method.getAnnotation(OpsLog.class);

    String value = opsLog.value();

    OpsLogType[] opsLogTypes = opsLog.type();

    String opsLogTypeNames = Arrays.toString(opsLogTypes);

    ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    HttpServletRequest request = servletRequestAttributes.getRequest();

    Object userName = RequestContextHolder.getRequestAttributes().getAttribute("username", RequestAttributes.SCOPE_REQUEST);

    log.error("记录下发日志，执行的操作：{}, 类型：{}", value, opsLogTypeNames);

    com.magic.platform.core.mongo.entity.OpsLog opsLogEntity = new com.magic.platform.core.mongo.entity.OpsLog();

    opsLogEntity.setOpsType(value);
    opsLogEntity.setOpsName(opsLogTypeNames);
    opsLogEntity.setUserName((String) userName);
    opsLogEntity.setRealName("");

    opsLogEntity.setPlatId("");
    opsLogEntity.setPlatName("");
    opsLogEntity.setPlatVersion("");

    opsLogEntity.setPath(request.getRequestURI());
    opsLogEntity.setIp(IpUtil.getRemoteAddr(request));
    opsLogEntity.setCreateTime(new Date());
    opsLogEntity.setEnvironment("");

    log.info("操作日志信息实体：{}", opsLogEntity.toString());

  }*/
}
