package com.github.richterplus.common.api.bean.log;

import com.github.richterplus.common.api.bean.CommonApiReq;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * 添加日志请求
 */
public class AppendLogReq extends CommonApiReq {

    /**
     * 客户端id
     */
    @NotNull
    @Size(max = 20)
    private String clientId;

    /**
     * 客户端版本号
     */
    @NotNull
    @Size(max = 10)
    private String clientVersion;

    /**
     * 用户id
     */
    @NotNull
    private Integer userId;

    /**
     * 日志类型
     */
    @NotNull
    private Integer logType;

    /**
     * 对象id
     */
    @NotNull
    private List<Integer> objectIds;

    /**
     * 日志内容
     */
    @NotNull
    private String message;

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
     * 获取对象id
     * @return 对象id
     */
    public List<Integer> getObjectIds() {
        return objectIds;
    }

    /**
     * 设置对象id
     * @param objectIds 对象id
     */
    public void setObjectIds(List<Integer> objectIds) {
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
}