package com.github.richterplus.common.entity;

/**
 * 日志
 */
public class Log {

    /**
     * 日志id
     */
    private Integer logId;

    /**
     * 客户端id
     */
    private String clientId;

    /**
     * 客户端版本号
     */
    private String clientVersion;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 日志类型
     */
    private Integer logType;

    /**
     * 关联对象id
     */
    private String objectIds;

    /**
     * 日志内容
     */
    private String message;

    /**
     * 日志记录日期
     */
    private java.util.Date logDate;

    /**
     * 获取日志id
     * @return 日志id
     */
    public Integer getLogId() {
        return logId;
    }

    /**
     * 设置日志id
     * @param logId 日志id
     */
    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    /**
     * 获取客户端id
     * @return 客户端id
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * 设置客户端id
     * @param clientId 客户端id
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     * 获取客户端版本号
     * @return 客户端版本号
     */
    public String getClientVersion() {
        return clientVersion;
    }

    /**
     * 设置客户端版本号
     * @param clientVersion 客户端版本号
     */
    public void setClientVersion(String clientVersion) {
        this.clientVersion = clientVersion;
    }

    /**
     * 获取用户id
     * @return 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取日志类型
     * @return 日志类型
     */
    public Integer getLogType() {
        return logType;
    }

    /**
     * 设置日志类型
     * @param logType 日志类型
     */
    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    /**
     * 获取关联对象id
     * @return 关联对象id
     */
    public String getObjectIds() {
        return objectIds;
    }

    /**
     * 设置关联对象id
     * @param objectIds 关联对象id
     */
    public void setObjectIds(String objectIds) {
        this.objectIds = objectIds;
    }

    /**
     * 获取日志内容
     * @return 日志内容
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置日志内容
     * @param message 日志内容
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 获取日志记录日期
     * @return 日志记录日期
     */
    public java.util.Date getLogDate() {
        return logDate;
    }

    /**
     * 设置日志记录日期
     * @param logDate 日志记录日期
     */
    public void setLogDate(java.util.Date logDate) {
        this.logDate = logDate;
    }

}