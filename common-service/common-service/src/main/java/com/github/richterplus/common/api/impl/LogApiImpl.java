package com.github.richterplus.common.api.impl;

import com.github.richterplus.common.api.LogApi;
import com.github.richterplus.common.api.bean.log.AppendLogReq;
import com.github.richterplus.common.api.bean.log.AppendLogRes;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
class LogApiImpl implements LogApi {

    @Override
    public AppendLogRes append(@RequestBody @Validated AppendLogReq req) {

        return new AppendLogRes() {
            {
                setLogUuid(UUID.randomUUID().toString());
            }
        };
    }
}
