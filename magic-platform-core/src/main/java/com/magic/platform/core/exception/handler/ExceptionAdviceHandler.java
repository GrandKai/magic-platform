package com.magic.platform.core.exception.handler;

import com.magic.platform.core.exception.CustomException;
import com.magic.platform.core.model.ResponseModel;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhangyn
 * @Description:
 * @Date: Created in 2018-05-17 14:14
 * @Modified By:
 */
@ControllerAdvice
@RestController
@Slf4j
public class ExceptionAdviceHandler {

  /**
   * 自定义异常处理 - 业务异常
   * @param request
   * @param response
   * @param exception
   * @return
   */
  @ExceptionHandler(CustomException.class)
  public ResponseModel customExceptionHandler(HttpServletRequest request, HttpServletResponse response, CustomException exception) {

    ResponseModel model = ResponseModel.builder()
        .code(exception.getCode())
        .message(exception.getMessage())
        .timestamp(new Date())
        .path(request.getRequestURI())
        .build();

    // 业务异常处理，直接给前面提示自定义信息，不记录到业务系统
    log.error("自定义异常处理：{}", model, exception);
    return model;
  }

  /**
   * FIXME: 系统异常处理-需要记录到日志系统
   * @param request
   * @param response
   * @param exception
   * @return
   */
  @ExceptionHandler(Exception.class)
  public ResponseModel exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception exception) {
    HttpStatus httpStatus = getHttpStatus(request);
    ResponseModel model = ResponseModel.builder()
        .code(httpStatus.value())
        .message(exception.getMessage())
        .timestamp(new Date())
        .path(request.getRequestURI())
        .build();

    log.error("统一异常处理：{}", model, exception);
    return model;
  }

  /**
   * 获取 servlet status 状态码
   * @param request
   * @return
   */
  private HttpStatus getHttpStatus(HttpServletRequest request){
    Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
    if(statusCode != null){
      return HttpStatus.valueOf(statusCode);
    }
    return HttpStatus.INTERNAL_SERVER_ERROR;
  }
}
