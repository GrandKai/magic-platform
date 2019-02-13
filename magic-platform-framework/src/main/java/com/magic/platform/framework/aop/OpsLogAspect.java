package com.magic.platform.framework.aop;

import com.magic.platform.core.anotation.OpsLog;
import com.magic.platform.core.anotation.OpsLogType;
import com.magic.platform.util.IpUtil;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
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


  @AfterReturning(pointcut = "opsLogAnnotation()", returning = "object")
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

    log.info("操作日志信息实体：", opsLogEntity.toString());

  }
}
