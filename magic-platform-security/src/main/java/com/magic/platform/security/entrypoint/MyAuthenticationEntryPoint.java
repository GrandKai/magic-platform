package com.magic.platform.security.entrypoint;

import com.magic.platform.core.exception.CustomException;
import com.magic.platform.core.exception.ExceptionEnum;
import com.magic.platform.core.model.ResponseModel;
import com.magic.platform.util.ResponseUtil;
import java.io.IOException;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * @Author: zhangyn
 * @Description: 这个类的作用：
 * <p>As you’re not presently authenticated,
 * the server sends back a response indicating that you must authenticate.
 * The response will either be an HTTP response code,
 * or a redirect to a particular web page.
 * <p>
 * @Date: Created in 2018-07-03 16:16
 * @Modified By:
 */
@Component
@Slf4j
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {

  @Override
  public void commence(HttpServletRequest request, HttpServletResponse response,
      AuthenticationException authException) throws IOException {

      // FIXME 判断是那种异常－抛出
//    if (authException instanceof InsufficientAuthenticationException) {
//
//    } else if (authException instanceof UsernameNotFoundException) {
//
//    } else if (authException instanceof BadCredentialsException) {
//
//    } else {
//
//    }

    CustomException exception = ExceptionEnum.AUTHENTICATION_FAILED.getException();

    ResponseModel model = new ResponseModel();
    model.setPath(request.getRequestURI());
    model.setTimestamp(new Date());

    model.setCode(exception.getCode());
    model.setMessage(exception.getMessage());

    log.error("AuthenticationEntryPoint commence AuthenticationException: ", authException);

    ResponseUtil.write(response, model);

  }
}
