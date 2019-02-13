package com.magic.platform.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import javax.servlet.ServletRequest;

/**
 * @Author: zyn
 * @Description: 获取请求信息
 * @Date: Created in 2018-09-06 15:15
 * @Modified By:
 */
public class HttpUtil {

  public static String getBodyString(ServletRequest request) {
    BufferedReader bufferedReader = null;
    InputStream inputStream = null;

    StringBuilder sb = new StringBuilder("");
    try {
      inputStream = request.getInputStream();

      bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("utf-8")));

      String line = "";
      while ((line = bufferedReader.readLine()) != null) {
        sb.append(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {

      if (bufferedReader != null) {
        try {
          bufferedReader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

      if (inputStream != null) {
        try {
          inputStream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

    return sb.toString();
  }

}
