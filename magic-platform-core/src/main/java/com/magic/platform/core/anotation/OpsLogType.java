package com.magic.platform.core.anotation;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2018-09-20 14:14
 * @Modified By:
 */
public enum OpsLogType {
  /**
   * 添加
   */
  ADD,

  /**
   * 修改
   */
  UPDATE,

  /**
   * 删除
   */
  DELETE,

  /**
   * 查询
   */
  SELECT,

  /**
   * 设置
   */
  SET,

  /**
   * 重置
   */
  RESET,

  /**
   * 停用
   */
  STOP,

  /**
   * 登录
   */
  LOGIN,

  /**
   * 退出
   */
  LOGOUT,

  /**
   * 刷新token
   */
  REFRESH,

  /**
   * 上传
   */
  UPLOAD,

  /**
   * 下载
   */
  DOWNLOAD,

  /**
   * 检测
   */
  CHECK;

  @Override
  public String toString() {
    return this.name();
  }
}
