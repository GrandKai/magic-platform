package com.magic.platform.util;

import com.alibaba.fastjson.JSON;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2018-08-30 17:17
 * @Modified By:
 */
public class ResponseUtil {

  private final static String CONTENT_TYPE = "application/json";
  private final static String DEFAULT_CHARACTER_SET = "UTF-8";
  private final static String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";


  public static void write(HttpServletResponse response, Object result) throws IOException {

    response.setContentType(CONTENT_TYPE);
    response.setCharacterEncoding(DEFAULT_CHARACTER_SET);
    response.getWriter().write(JSON.toJSONStringWithDateFormat(result, DATE_FORMAT));

  }
}
