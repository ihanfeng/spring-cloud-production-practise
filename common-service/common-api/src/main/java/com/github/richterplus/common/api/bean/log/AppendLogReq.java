package com.github.richterplus.common.api.bean.log;

import com.github.richterplus.common.api.bean.CommonApiReq;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * 添加日志请求
 */
public class AppendLogReq extends CommonApiReq {

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id", required = true)
    @NotNull
    private Integer userId;

    /**
     * 日志类型
     */
    @ApiModelProperty(value = "日志类型", required = true)
    @NotNull
    private Integer logType;

    /**
     * 对象id
     */
    @ApiModelProperty(value = "对象id", required = true)
    @NotNull
    private List<Integer> objectIds;

    /**
     * 日志内容
     */
    @ApiModelProperty(value = "日志内容", required = true)
    @NotNull
    private String message;

    /**
     * @return 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return 日志类型
     */
    public Integer getLogType() {
        return logType;
    }

    /**
     * @param logType 日志类型
     */
    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    /**
     * @return 对象id
     */
    public List<Integer> getObjectIds() {
        return objectIds;
    }

    /**
     * @param objectIds 对象id
     */
    public void setObjectIds(List<Integer> objectIds) {
        this.objectIds = objectIds;
    }

    /**
     * @return 日志内容
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message 日志内容
     */
    public void setMessage(String message) {
        this.message = message;
    }
}