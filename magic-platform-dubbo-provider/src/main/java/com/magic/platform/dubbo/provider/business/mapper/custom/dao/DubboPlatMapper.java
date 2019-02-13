package com.magic.platform.dubbo.provider.business.mapper.custom.dao;

import com.magic.platform.dubbo.dto.PlatDto;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2018-10-12 20:20
 * @Modified By:
 */
public interface DubboPlatMapper {

  List<PlatDto> selectAllGrantedPlats(@Param("userName") String userName);
}
