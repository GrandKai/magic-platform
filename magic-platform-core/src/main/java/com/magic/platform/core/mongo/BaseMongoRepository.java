package com.magic.platform.core.mongo;

import java.io.Serializable;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Author: zyn
 * @Description: MongoDB 增删改查基类
 * @Date: Created in 2018-10-15 17:17
 * @Modified By:
 */
@ConditionalOnExpression("${framework.config.mongo.enable: false}")
@ConditionalOnBean(MongoDbFactory.class)
public interface BaseMongoRepository<T, K extends Serializable> extends MongoRepository<T, K> {

}
