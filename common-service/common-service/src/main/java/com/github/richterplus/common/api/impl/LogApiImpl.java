package com.github.richterplus.common.api.impl;

import com.github.richterplus.common.api.LogApi;
import com.github.richterplus.common.api.bean.log.AppendLogReq;
import com.github.richterplus.common.api.bean.log.AppendLogRes;
import com.github.richterplus.common.stream.binding.LogAppenderBinding;
import com.github.richterplus.common.stream.message.LogAppenderMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
class LogApiImpl implements LogApi {

    @Autowired
    private LogAppenderBinding logAppenderBinding;

    @Override
    public AppendLogRes append(@RequestBody @Validated AppendLogReq req) {

        AppendLogRes res = new AppendLogRes();
        res.setLogUuid(UUID.randomUUID().toString());

        logAppenderBinding.output().send(MessageBuilder.withPayload(new LogAppenderMessage() {
            {
                setLogUuid(res.getLogUuid());
                setLogType(req.getLogType());
                setMessage(req.getMessage());
                setObjectIds(req.getObjectIds());
                setRequestDateTime(req.getRequestDateTime());
                setUserId(req.getUserId());
            }
        }).build());

        return res;
    }
}
