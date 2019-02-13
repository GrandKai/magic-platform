package com.magic.platform.core.mongo.dao;

import com.magic.platform.core.mongo.BaseMongoRepository;
import com.magic.platform.core.mongo.entity.OpsLog;
import org.bson.types.ObjectId;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2018-10-15 17:17
 * @Modified By:
 */
public interface OpsLogRepository extends BaseMongoRepository<OpsLog, ObjectId> {

}
