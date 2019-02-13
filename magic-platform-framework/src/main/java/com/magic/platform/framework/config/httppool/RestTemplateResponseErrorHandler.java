package com.magic.platform.framework.config.httppool;

import static org.springframework.http.HttpStatus.Series.CLIENT_ERROR;
import static org.springframework.http.HttpStatus.Series.SERVER_ERROR;

import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

/**
 * @Author: zyn
 * @Description: 统一异常处理
 * @Date: Created in 2018-10-27 08:08
 * @Modified By:
 */
@Slf4j
@Component
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {

  @Override
  public boolean hasError(ClientHttpResponse response) throws IOException {

    return response.getStatusCode().series() == CLIENT_ERROR || response.getStatusCode().series() == SERVER_ERROR;
  }

  @Override
  public void handleError(ClientHttpResponse response) throws IOException {
    if (response.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR) {
      // handle SERVER_ERROR
      log.error("=====================: 服务端错误处理");

    } else if (response.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR) {
      // handle CLIENT_ERROR
      log.error("=====================: 客户端错误处理");

      if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
//        throw new NotFoundException();
      }
    }
  }
}
