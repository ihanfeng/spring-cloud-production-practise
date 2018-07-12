package com.github.richterplus.common.entity;

/**
 * 日志
 */
public class Log {

    /**
     * 用户日志id
     */
    private Integer logId;

    /**
     * 日志uuid
     */
    private String logUuid;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 日志类型
     */
    private Integer logType;

    /**
     * 对象id
     */
    private String objectIds;

    /**
     * 日志内容
     */
    private String message;

    /**
     * 日志日期
     */
    private java.util.Date logDate;

    /**
     * 获取用户日志id
     * @return 用户日志id
     */
    public Integer getLogId() {
        return logId;
    }

    /**
     * 设置用户日志id
     * @param logId 用户日志id
     */
    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    /**
     * 获取日志uuid
     * @return 日志uuid
     */
    public String getLogUuid() {
        return logUuid;
    }

    /**
     * 设置日志uuid
     * @param logUuid 日志uuid
     */
    public void setLogUuid(String logUuid) {
        this.logUuid = logUuid;
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
     * 获取对象id
     * @return 对象id
     */
    public String getObjectIds() {
        return objectIds;
    }

    /**
     * 设置对象id
     * @param objectIds 对象id
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
     * 获取日志日期
     * @return 日志日期
     */
    public java.util.Date getLogDate() {
        return logDate;
    }

    /**
     * 设置日志日期
     * @param logDate 日志日期
     */
    public void setLogDate(java.util.Date logDate) {
        this.logDate = logDate;
    }

}