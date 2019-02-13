package com.magic.platform.core.model;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2018-10-16 13:13
 * @Modified By:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonInclude(Include.NON_NULL)
public class MongoPageResult<T> {

    @ApiModelProperty("页码，从1开始")
    private Integer pageNum;

    @ApiModelProperty("页面大小")
    private Integer pageSize;

    @ApiModelProperty("总数")
    private Long total;

    @ApiModelProperty("总页数")
    private Integer pages;

    @ApiModelProperty("数据")
    private List<T> list;

}
