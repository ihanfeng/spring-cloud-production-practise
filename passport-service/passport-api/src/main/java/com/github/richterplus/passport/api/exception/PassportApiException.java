package com.github.richterplus.passport.api.exception;

import com.netflix.hystrix.exception.ExceptionNotWrappedByHystrix;
import com.netflix.hystrix.exception.HystrixBadRequestException;

public class PassportApiException extends HystrixBadRequestException implements ExceptionNotWrappedByHystrix {

    /**
     * 无效的登录凭据
     */
    public static final String INVALID_CREDENTIAL = "invalid_credential";

    /**
     * 创建Passport Api异常
     * @param code 异常码
     * @param message 异常信息
     */
    public PassportApiException(String code, String message) {
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
