package com.magic.platform.security.hanlder;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2018-10-17 09:09
 * @Modified By:
 */
@Component
@Slf4j
public class MyLogoutSuccessHandler implements LogoutSuccessHandler {

  @Override
  public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

    // 参照： SecurityContextLogoutHandler
    SecurityContextHolder.getContext().setAuthentication(null);
    SecurityContextHolder.clearContext();

    log.error("执行登出方法");
  }
}
