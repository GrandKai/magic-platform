package com.magic.platform.security.access;

import java.util.Collection;
import java.util.HashSet;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @Author: zhangyn
 * @Description: 判断用户是否含有请求对象相关的权限 【用户登录后所具有权限集合已经确定，这里只需判断集合中是否有该权限即可】
 * @Date: Created in 2018-06-11 13:13
 * @Modified By:
 */
@Component
public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

  /**
   * 获取请求对象相关的 ConfigAttribute 集合信息
   * @param object
   * @return
   * @throws IllegalArgumentException
   */
  @Override
  public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {

    FilterInvocation filterInvocation = (FilterInvocation) object;

    String requestUrl = filterInvocation.getRequestUrl();

    // 去除 get 请求后面的参数
    if (!StringUtils.isEmpty(requestUrl)) {
      int index = requestUrl.indexOf("?");
      if (-1 != index) {
        requestUrl = requestUrl.substring(0, index);
      }
    }

    Collection<ConfigAttribute> attributes = new HashSet<>();

    ConfigAttribute attribute = new SecurityConfig(requestUrl);

    attributes.add(attribute);

    return attributes;
  }

  @Override
  public Collection<ConfigAttribute> getAllConfigAttributes() {

    return null;
  }

  @Override
  public boolean supports(Class<?> clazz) {
    return clazz.isAssignableFrom(FilterInvocation.class);
  }
}
