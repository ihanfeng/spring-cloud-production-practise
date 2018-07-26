package com.github.richterplus.common.stream.message;

import com.github.richterplus.common.api.bean.log.AppendLogReq;

/**
 * 日志消息
 */
public class LogAppenderMessage extends AppendLogReq {

    /**
     * 日志uuid
     */
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
