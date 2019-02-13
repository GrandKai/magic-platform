package com.magic.platform.security.servlet;

import com.magic.platform.util.HttpUtil;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * @Author: zyn
 * @Description: 将 request 中的流信息读取出来供外部使用，将流缓存起来，传到下一个 filter 中
 * @Date: Created in 2018-09-06 13:13
 * @Modified By:
 */
public class ServletRequestWrapper extends HttpServletRequestWrapper {

  private byte[] body;
  private String requestParam;
  /**
   * Constructs a request object wrapping the given request.
   * @Description: 将 request 中的流信息读取出来供外部使用，将流缓存起来，传到下一个 filter 中
   * @param request The request to wrap
   * @throws IllegalArgumentException if the request is null
   */
  public ServletRequestWrapper(HttpServletRequest request) {
    super(request);
    requestParam = HttpUtil.getBodyString(request);
    body = requestParam.getBytes(Charset.forName("utf-8"));
  }

  @Override
  public BufferedReader getReader() throws IOException {
    return new BufferedReader(new InputStreamReader(getRequest().getInputStream(), Charset.forName("UTF-8")));
  }

  @Override
  public ServletInputStream getInputStream() throws IOException {
    return new CustomServletInputStream();
  }

  private class CustomServletInputStream extends ServletInputStream {

    private final ByteArrayInputStream inputStream = new ByteArrayInputStream(body);

    @Override
    public boolean isFinished() {
      return false;
    }

    @Override
    public boolean isReady() {
      return false;
    }

    @Override
    public void setReadListener(ReadListener listener) {

    }

    @Override
    public int read() throws IOException {
      return inputStream.read();
    }
  }

  public String getRequestParam() {
    return requestParam;
  }
}
