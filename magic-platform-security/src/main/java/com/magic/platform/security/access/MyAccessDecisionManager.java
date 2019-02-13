package com.magic.platform.security.access;

import com.magic.platform.core.exception.ExceptionEnum;
import java.util.Collection;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;

/**
 * @Author: zhangyn
 * @Description:
 * @Date: Created in 2018-06-11 13:13
 * @Modified By:
 */
@Component
@Slf4j
public class MyAccessDecisionManager implements AccessDecisionManager {

  @Override
  public void decide(Authentication authentication, Object object,
      Collection<ConfigAttribute> configAttributes)
      throws AccessDeniedException, InsufficientAuthenticationException {
    log.info("----------------AccessDecisionManager.decide start-----------------");

    FilterInvocation filterInvocation = (FilterInvocation) object;

    if (authentication == null) {
      throw ExceptionEnum.AUTHENTICATION_IS_NULL.getException();
    }

    boolean success = false;
    try {
      Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

      for (GrantedAuthority authority : authorities) {

        String authorityUrl = authority.getAuthority();

        for (ConfigAttribute configAttribute : configAttributes) {

          if (authorityUrl.equals(configAttribute.getAttribute())) {
            success = true;
            return;
          }
        }
      }

    } finally {

      log.info("----------------AccessDecisionManager.decide [{}]: {}", filterInvocation.getRequestUrl(), success ? "granted" : "denied" ,"-----------------");
      log.info("----------------AccessDecisionManager.decide end-----------------");
    }

    throw new AccessDeniedException("拒绝访问");
  }

  @Override
  public boolean supports(ConfigAttribute attribute) {
    return false;
  }

  @Override
  public boolean supports(Class<?> clazz) {
    return clazz.isAssignableFrom(FilterInvocation.class);
  }
}
