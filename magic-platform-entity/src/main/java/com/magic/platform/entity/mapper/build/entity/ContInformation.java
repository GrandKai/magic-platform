package com.magic.platform.entity.mapper.build.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "cont_information")
public class ContInformation {
    @Id
    private String id;

    /**
     * 资讯所属栏目表
     */
    @Column(name = "catalog_id")
    private String catalogId;

    /**
     * 资讯标题
     */
    private String title;

    /**
     * 资讯封面图片
     */
    @Column(name = "cover_image")
    private String coverImage;

    /**
     * 摘要
     */
    private String summary;

    /**
     * 作者
     */
    private String author;

    /**
     * 来源
     */
    private String source;

    /**
     * 来源地址
     */
    @Column(name = "source_address")
    private String sourceAddress;

    /**
     * 置顶级别
     */
    @Column(name = "top_level")
    private Short topLevel;

    /**
     * 置顶到期时间
     */
    @Column(name = "top_end_time")
    private Date topEndTime;

    /**
     * 发布时间
     */
    @Column(name = "release_time")
    private Date releaseTime;

    /**
     * 有效期至
     */
    @Column(name = "validity_end_time")
    private Date validityEndTime;

    /**
     * 发布者
     */
    private String publisher;

    /**
     * 点击量
     */
    @Column(name = "click_amount")
    private Integer clickAmount;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "is_deleted")
    private String isDeleted;

    /**
     * 资讯内容 - 富文本（可以转移到 MongoDB 中，或者放到 redis 中，减少数据库查询压力）
     */
    private String content;

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
     * 获取资讯所属栏目表
     *
     * @return catalog_id - 资讯所属栏目表
     */
    public String getCatalogId() {
        return catalogId;
    }

    /**
     * 设置资讯所属栏目表
     *
     * @param catalogId 资讯所属栏目表
     */
    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId == null ? null : catalogId.trim();
    }

    /**
     * 获取资讯标题
     *
     * @return title - 资讯标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置资讯标题
     *
     * @param title 资讯标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取资讯封面图片
     *
     * @return cover_image - 资讯封面图片
     */
    public String getCoverImage() {
        return coverImage;
    }

    /**
     * 设置资讯封面图片
     *
     * @param coverImage 资讯封面图片
     */
    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage == null ? null : coverImage.trim();
    }

    /**
     * 获取摘要
     *
     * @return summary - 摘要
     */
    public String getSummary() {
        return summary;
    }

    /**
     * 设置摘要
     *
     * @param summary 摘要
     */
    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    /**
     * 获取作者
     *
     * @return author - 作者
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 设置作者
     *
     * @param author 作者
     */
    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    /**
     * 获取来源
     *
     * @return source - 来源
     */
    public String getSource() {
        return source;
    }

    /**
     * 设置来源
     *
     * @param source 来源
     */
    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    /**
     * 获取来源地址
     *
     * @return source_address - 来源地址
     */
    public String getSourceAddress() {
        return sourceAddress;
    }

    /**
     * 设置来源地址
     *
     * @param sourceAddress 来源地址
     */
    public void setSourceAddress(String sourceAddress) {
        this.sourceAddress = sourceAddress == null ? null : sourceAddress.trim();
    }

    /**
     * 获取置顶级别
     *
     * @return top_level - 置顶级别
     */
    public Short getTopLevel() {
        return topLevel;
    }

    /**
     * 设置置顶级别
     *
     * @param topLevel 置顶级别
     */
    public void setTopLevel(Short topLevel) {
        this.topLevel = topLevel;
    }

    /**
     * 获取置顶到期时间
     *
     * @return top_end_time - 置顶到期时间
     */
    public Date getTopEndTime() {
        return topEndTime;
    }

    /**
     * 设置置顶到期时间
     *
     * @param topEndTime 置顶到期时间
     */
    public void setTopEndTime(Date topEndTime) {
        this.topEndTime = topEndTime;
    }

    /**
     * 获取发布时间
     *
     * @return release_time - 发布时间
     */
    public Date getReleaseTime() {
        return releaseTime;
    }

    /**
     * 设置发布时间
     *
     * @param releaseTime 发布时间
     */
    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    /**
     * 获取有效期至
     *
     * @return validity_end_time - 有效期至
     */
    public Date getValidityEndTime() {
        return validityEndTime;
    }

    /**
     * 设置有效期至
     *
     * @param validityEndTime 有效期至
     */
    public void setValidityEndTime(Date validityEndTime) {
        this.validityEndTime = validityEndTime;
    }

    /**
     * 获取发布者
     *
     * @return publisher - 发布者
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * 设置发布者
     *
     * @param publisher 发布者
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }

    /**
     * 获取点击量
     *
     * @return click_amount - 点击量
     */
    public Integer getClickAmount() {
        return clickAmount;
    }

    /**
     * 设置点击量
     *
     * @param clickAmount 点击量
     */
    public void setClickAmount(Integer clickAmount) {
        this.clickAmount = clickAmount;
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

    /**
     * @return is_deleted
     */
    public String getIsDeleted() {
        return isDeleted;
    }

    /**
     * @param isDeleted
     */
    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted == null ? null : isDeleted.trim();
    }

    /**
     * 获取资讯内容 - 富文本（可以转移到 MongoDB 中，或者放到 redis 中，减少数据库查询压力）
     *
     * @return content - 资讯内容 - 富文本（可以转移到 MongoDB 中，或者放到 redis 中，减少数据库查询压力）
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置资讯内容 - 富文本（可以转移到 MongoDB 中，或者放到 redis 中，减少数据库查询压力）
     *
     * @param content 资讯内容 - 富文本（可以转移到 MongoDB 中，或者放到 redis 中，减少数据库查询压力）
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}