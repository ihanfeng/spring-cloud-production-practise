package com.github.richterplus.passport.service;

import com.github.richterplus.common.api.LogApi;
import com.github.richterplus.common.api.bean.log.AppendLogReq;
import com.github.richterplus.common.api.bean.log.AppendLogRes;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient(name = "common-service", fallbackFactory = LogService.LogApiFallbackFactory.class)
interface LogService extends LogApi {

    @Component
    class LogApiFallbackFactory implements FallbackFactory<LogService> {

        @Override
        public LogService create(Throwable throwable) {
            return new LogService() {
                @Override
                public AppendLogRes append(AppendLogReq req) {

                    return new AppendLogRes() {
                        {
                            setLogUuid("");
                        }
                    };
                }
            };
        }
    }
}
