package com.magic.platform.util;

import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2018-10-17 11:11
 * @Modified By:
 */
@Slf4j
public class IpUtil {

  public static String getRemoteAddr(HttpServletRequest request) {
    String ip = request.getHeader("x-forwarded-for");
    if (StringUtils.isNotEmpty(ip)) {
      log.info("x-forwarded-for ip: " + ip);
    }

    if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
      // 多次反向代理后会有多个ip值，第一个ip才是真实ip
      if (ip.indexOf(",") != -1) {
        ip = ip.split(",")[0];
      }
    }

    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getHeader("Proxy-Client-IP");
      if (StringUtils.isNotEmpty(ip)) {
        log.info("Proxy-Client-IP ip: " + ip);
      }
    }

    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getHeader("WL-Proxy-Client-IP");
      if (StringUtils.isNotEmpty(ip)) {
        log.info("WL-Proxy-Client-IP ip: " + ip);
      }
    }

    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getHeader("HTTP_CLIENT_IP");
      if (StringUtils.isNotEmpty(ip)) {
        log.info("HTTP_CLIENT_IP ip: " + ip);
      }
    }

    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getHeader("HTTP_X_FORWARDED_FOR");
      if (StringUtils.isNotEmpty(ip)) {
        log.info("HTTP_X_FORWARDED_FOR ip: " + ip);
      }
    }

    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getHeader("X-Real-IP");
      if (StringUtils.isNotEmpty(ip)) {
        log.info("X-Real-IP ip: " + ip);
      }
    }

    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getRemoteAddr();
      if (StringUtils.equals("0:0:0:0:0:0:0:1", ip)) {
        ip = "127.0.0.1";
      }
      if (StringUtils.isNotEmpty(ip)) {
        log.info("getRemoteAddr ip: " + ip);
      }
    }
    log.info("获取客户端ip: " + ip);
    return ip;
  }
}
