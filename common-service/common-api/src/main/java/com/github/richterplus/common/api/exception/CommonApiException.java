package com.github.richterplus.common.api.exception;

import com.netflix.hystrix.exception.ExceptionNotWrappedByHystrix;
import com.netflix.hystrix.exception.HystrixBadRequestException;

public class CommonApiException extends HystrixBadRequestException implements ExceptionNotWrappedByHystrix {

    /**
     * 创建Common Api异常
     * @param code 异常码
     * @param message 异常信息
     */
    public CommonApiException(String code, String message) {
        super(message);
        this.code = code;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

    /**
     * 异常码
     */
    private String code;

    /**
     * 获取异常码
     * @return 异常码
     */
    public String getCode() {
        return code;
    }
}
