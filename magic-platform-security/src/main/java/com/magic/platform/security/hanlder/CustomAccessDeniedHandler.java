package com.magic.platform.security.hanlder;

import com.magic.platform.core.exception.CustomException;
import com.magic.platform.core.exception.ExceptionEnum;
import com.magic.platform.core.model.ResponseModel;
import com.magic.platform.util.ResponseUtil;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

/**
 * @Author: zhangyn
 * @Description: 拒绝访问处理
 * @Date: Created in 2018-05-22 14:14
 * @Modified By:
 */
@Slf4j
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {


  @Override
  public void handle(HttpServletRequest request, HttpServletResponse response,
      AccessDeniedException accessDeniedException) throws IOException, ServletException {

    // TODO: 也可以直接通过 response 直接打印异常，避免继续往下走，
    // TODO: 如果不需要记录无权限的访问可以直接打印异常

    CustomException exception = ExceptionEnum.ACCESS_DENIED.getException();

    ResponseModel model = ResponseModel.builder()
        .path(request.getRequestURI())
        .timestamp(new Date())
        .code(exception.getCode())
        .message(exception.getMessage()).build();

    log.error("访问拒绝：{}", model, accessDeniedException);
    ResponseUtil.write(response, model);
  }
}
