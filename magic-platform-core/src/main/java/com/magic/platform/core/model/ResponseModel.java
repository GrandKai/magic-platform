package com.magic.platform.core.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;

/**
 * @Author: zhangyn
 * @Description:
 * @Date: Created in 2018-05-17 15:15
 * @Modified By:
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@JsonInclude(Include.NON_NULL)
@Validated
public class ResponseModel<T> {

  /**
   * 响应码
   */
  @NonNull
  private Integer code;

  /**
   * 响应消息
   */
  @NonNull
  private String message;

  /**
   * 响应内容
   */
  private T content;

  /**
   * 请求路径
   */
  private String path;

  /**
   * 响应时间,格式统一使用 jackson 进行处理，也可以使用注解
   *
   * @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") 进行指定
   */
  private Date timestamp;

  public ResponseModel() {
    this.code = HttpStatus.OK.value();
    this.message = HttpStatus.OK.name();
  }


  public ResponseModel(T content) {
    this.code = HttpStatus.OK.value();
    this.message = HttpStatus.OK.name();
    this.content = content;
  }


  public ResponseModel(String message) {
    this.code = HttpStatus.OK.value();
    this.message = message;
  }


  public ResponseModel(String message, T content) {
    this.code = HttpStatus.OK.value();
    this.message = message;
    this.content = content;
  }

  public ResponseModel(Integer code, String message, T content) {
    this.code = code;
    this.message = message;
    this.content = content;
  }

}
