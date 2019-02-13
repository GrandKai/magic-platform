package com.magic.platform.core.exception;

import com.magic.platform.core.constant.Constant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

/**
 * @Author: zhangyn
 * @Description:
 * @Date: Created in 2018-05-17 14:14
 * @Modified By:
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomException extends RuntimeException {
  @NonNull
  private Integer code;
  @NonNull
  private String message;

  public CustomException(String message) {
    super(message);
    this.message = message;
    this.code = Constant.EXCEPTION_CODE;
  }

  public CustomException(Throwable cause) {
    super(cause);
    this.message = cause.getLocalizedMessage();
  }
}
