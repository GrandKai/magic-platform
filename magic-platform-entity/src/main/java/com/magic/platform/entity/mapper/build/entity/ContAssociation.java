package com.magic.platform.entity.mapper.build.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "cont_association")
public class ContAssociation {
    @Id
    private String id;

    /**
     * 资源id
     */
    @Column(name = "source_id")
    private String sourceId;

    /**
     * 与资源相关联的id
     */
    @Column(name = "association_id")
    private String associationId;

    /**
     * 资源类型（1：资讯，2：视频），todo:优化读取数据字典
     */
    @Column(name = "source_type")
    private String sourceType;

    /**
     * 排序字段
     */
    @Column(name = "sort_number")
    private Short sortNumber;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取资源id
     *
     * @return source_id - 资源id
     */
    public String getSourceId() {
        return sourceId;
    }

    /**
     * 设置资源id
     *
     * @param sourceId 资源id
     */
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId == null ? null : sourceId.trim();
    }

    /**
     * 获取与资源相关联的id
     *
     * @return association_id - 与资源相关联的id
     */
    public String getAssociationId() {
        return associationId;
    }

    /**
     * 设置与资源相关联的id
     *
     * @param associationId 与资源相关联的id
     */
    public void setAssociationId(String associationId) {
        this.associationId = associationId == null ? null : associationId.trim();
    }

    /**
     * 获取资源类型（1：资讯，2：视频），todo:优化读取数据字典
     *
     * @return source_type - 资源类型（1：资讯，2：视频），todo:优化读取数据字典
     */
    public String getSourceType() {
        return sourceType;
    }

    /**
     * 设置资源类型（1：资讯，2：视频），todo:优化读取数据字典
     *
     * @param sourceType 资源类型（1：资讯，2：视频），todo:优化读取数据字典
     */
    public void setSourceType(String sourceType) {
        this.sourceType = sourceType == null ? null : sourceType.trim();
    }

    /**
     * 获取排序字段
     *
     * @return sort_number - 排序字段
     */
    public Short getSortNumber() {
        return sortNumber;
    }

    /**
     * 设置排序字段
     *
     * @param sortNumber 排序字段
     */
    public void setSortNumber(Short sortNumber) {
        this.sortNumber = sortNumber;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}