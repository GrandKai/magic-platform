package com.magic.platform.core.util;

import com.magic.platform.core.constant.Constant;
import com.magic.platform.core.exception.CustomException;
import java.util.Collection;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2018-09-21 15:15
 * @Modified By:
 */
public class Objects {

  public static <T> T requireNonNull(T obj, String message) {
    if (obj == null || "".equals(obj)) {
      throw new CustomException(Constant.EXCEPTION_CODE, message);
    }
    return obj;
  }

  public static void requireNonNull(Collection collection, String message) {
    if (collection == null || collection.isEmpty()) {
      throw new CustomException(Constant.EXCEPTION_CODE, message);
    }
  }

  public static <T> T requireNonNull(T obj, Integer code, String message) {
    if (obj == null || "".equals(obj)) {
      throw new CustomException(code, message);
    }
    return obj;
  }

  public static void requireNonNull(Collection collection, Integer code,  String message) {
    if (collection == null || collection.isEmpty()) {
      throw new CustomException(code, message);
    }
  }
}
