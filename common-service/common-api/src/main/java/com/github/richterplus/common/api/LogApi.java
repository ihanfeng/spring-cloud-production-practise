package com.github.richterplus.common.api;

import com.github.richterplus.common.api.bean.log.AppendLogReq;
import com.github.richterplus.common.api.bean.log.AppendLogRes;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("log")
public interface LogApi {

    @RequestMapping(method = RequestMethod.PUT, value = "append")
    AppendLogRes append(@RequestBody AppendLogReq req);
}
