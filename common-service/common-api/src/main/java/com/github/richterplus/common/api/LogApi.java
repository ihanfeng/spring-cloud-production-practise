package com.github.richterplus.common.api;

import com.github.richterplus.common.api.bean.log.AppendLogReq;
import com.github.richterplus.common.api.bean.log.AppendLogRes;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 日志API
 */
@RequestMapping("log")
public interface LogApi {

    /**
     * 添加日志记录
     */
    @ApiOperation("添加日志记录")
    @RequestMapping(method = RequestMethod.PUT, value = "append")
    AppendLogRes append(@RequestBody AppendLogReq req);
}
