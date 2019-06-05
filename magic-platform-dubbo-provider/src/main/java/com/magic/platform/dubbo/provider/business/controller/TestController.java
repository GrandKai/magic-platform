package com.magic.platform.dubbo.provider.business.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.magic.platform.core.model.ResponseModel;
import com.magic.platform.core.mongo.dao.OpsLogRepository;
import com.magic.platform.core.mongo.entity.OpsLog;
import com.magic.platform.util.UUIDUtils;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2018-10-15 17:17
 * @Modified By:
 */
@RestController
public class TestController {

  @Autowired
  private OpsLogRepository opsLogRepository;

  @GetMapping("/mongo")
  public String insertMongoData() {

    OpsLog opsLog = new OpsLog();
    opsLog.setCreateTime(new Date());

    opsLog.setPath("/mongo");

    opsLog.setUserName("GrandKai");

    opsLog.setIp("127.0.0.1");
    opsLog.setPath("123456");
    opsLog.setPlatId(UUIDUtils.uuid());
    opsLog.setPlatName("权限管理系统");
    opsLog.setPlatVersion("v1.0.0");
    opsLog.setOpsType("ADD");

    Object result = opsLogRepository.insert(opsLog);

    return JSONObject.toJSONString(result);
  }

  @GetMapping("/page")
  public ResponseModel page(Integer pageNum, Integer pageSize) {
    PageInfo page = new PageInfo();

    Sort sort = new Sort(Direction.DESC, "createTime");
    Pageable pageable = new PageRequest(pageNum, pageSize, sort);
    org.springframework.data.domain.Page<OpsLog> page1 = opsLogRepository.findAll(pageable);

    page.setList(page1.getContent());
    page.setTotal(page1.getTotalPages());

    page.setPageNum(pageNum);
    page.setPageSize(pageSize);

    return new ResponseModel(page);
  }

}
