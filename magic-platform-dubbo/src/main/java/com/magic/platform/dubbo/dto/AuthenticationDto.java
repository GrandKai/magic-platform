package com.magic.platform.dubbo.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2018-09-04 08:08
 * @Modified By:
 */
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class AuthenticationDto implements Serializable {

  private String accessToken;
  private String refreshToken;
  private String version;

  private UserDto userDto;
}
