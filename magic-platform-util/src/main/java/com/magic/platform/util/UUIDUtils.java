package com.magic.platform.util;

import java.util.UUID;

/**
 * @Author: zhangyn
 * @Description:
 * @Date: Created in 2018-05-16 10:10
 * @Modified By:
 */
public class UUIDUtils {

  private UUIDUtils() {
  }

  public static String uuid() {
    return UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
  }

  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      System.out.println(uuid());

    }
  }
}
