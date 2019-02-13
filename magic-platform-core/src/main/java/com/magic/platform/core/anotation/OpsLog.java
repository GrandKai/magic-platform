package com.magic.platform.core.anotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2018-09-20 13:13
 * @Modified By:
 */
@Documented // 定义注解的保留策略
@Inherited //说明子类可以继承父类中的该注解
@Retention(value = RetentionPolicy.RUNTIME) // 定义注解的保留策略
@Target(value = {ElementType.METHOD}) // 定义注解的作用目标
public @interface OpsLog {

  String value() default "";
  OpsLogType[] type() default {};
}
