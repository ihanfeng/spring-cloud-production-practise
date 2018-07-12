package com.github.richterplus.passport.service;

import com.github.richterplus.common.api.LogApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "common-service")
interface LogService extends LogApi {
}
