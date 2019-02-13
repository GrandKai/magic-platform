package com.magic.platform.dubbo.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2018-09-18 14:14
 * @Modified By:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenDto implements Serializable {

  private String accessToken;
  private String refreshToken;

}
