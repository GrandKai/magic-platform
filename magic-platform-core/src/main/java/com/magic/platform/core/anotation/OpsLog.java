package com.magic.platform.core.anotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2018-09-20 13:13
 * @Modified By:
 */
@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD})
public @interface OpsLog {

  String value() default "";
  OpsLogType[] type() default {};
}
