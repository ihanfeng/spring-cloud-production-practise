package com.github.richterplus.passport.api.impl;

import com.github.richterplus.common.api.LogApi;
import com.github.richterplus.common.api.bean.log.AppendLogReq;
import com.github.richterplus.common.api.enums.LogType;
import com.github.richterplus.passport.api.AccountApi;
import com.github.richterplus.passport.api.bean.account.*;
import com.github.richterplus.passport.api.exception.PassportApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.UUID;

@RestController
class AccountApiImpl implements AccountApi {

    @Autowired
    private LogApi logApi;

    @Override
    public RegisterAccountRes register(@RequestBody @Validated RegisterAccountReq req) {

        logApi.append(new AppendLogReq() {
            {
                setLogType(LogType.REGISTER);
                setUserId(0);
                setObjectIds(Collections.emptyList());
                setMessage("用户【" + req.getUsername() + "】注册");
            }
        });

        return new RegisterAccountRes() {
            {
                setAccessToken(UUID.randomUUID().toString());
            }
        };
    }

    @Override
    public LoginRes login(@RequestBody @Validated LoginReq req) {

        if (!(req.getUsername().equals("admin") && req.getPassword().equals("123456"))) {
            throw new PassportApiException(PassportApiException.INVALID_CREDENTIAL, "登录凭据无效");
        }

        logApi.append(new AppendLogReq() {
            {
                setLogType(LogType.REGISTER);
                setUserId(0);
                setObjectIds(Collections.emptyList());
                setMessage("用户【" + req.getUsername() + "】登录");
            }
        });

        return new LoginRes() {
            {
                setAccessToken(UUID.randomUUID().toString());
            }
        };
    }

    @Override
    public ValidateTokenRes validate(@RequestBody @Validated ValidateTokenReq req) {

        return new ValidateTokenRes() {
            {
                setUserId(0);
            }
        };
    }
}
