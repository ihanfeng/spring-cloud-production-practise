package com.github.richterplus.common.api.bean.log;

import com.github.richterplus.common.api.bean.CommonApiRes;
import io.swagger.annotations.ApiModelProperty;

/**
 * 添加日志响应
 */
public class AppendLogRes extends CommonApiRes {

    /**
     * 日志uuid
     */
    @ApiModelProperty("日志uuid")
    private String logUuid;

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
}
