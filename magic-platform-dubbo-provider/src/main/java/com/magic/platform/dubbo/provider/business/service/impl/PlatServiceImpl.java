package com.magic.platform.dubbo.provider.business.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.magic.platform.core.exception.CustomException;
import com.magic.platform.core.jwt.Token;
import com.magic.platform.dubbo.dto.PlatDto;
import com.magic.platform.dubbo.provider.business.mapper.custom.dao.DubboPlatMapper;
import com.magic.platform.dubbo.service.IPlatService;
import io.jsonwebtoken.Claims;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2018-10-12 20:20
 * @Modified By:
 */
@Service
public class PlatServiceImpl implements IPlatService {

  @Autowired
  private DubboPlatMapper dubboPlatMapper;

  @Override
  public List<PlatDto> selectAllGrantedPlats(String accessToken) throws CustomException {
    Claims claims = Token.parseAccessToken2Claims(accessToken);
    String userName = claims.getSubject();
    return dubboPlatMapper.selectAllGrantedPlats(userName);
  }
}
