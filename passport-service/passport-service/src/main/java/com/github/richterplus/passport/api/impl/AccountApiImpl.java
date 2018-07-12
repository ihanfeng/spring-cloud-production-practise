package com.github.richterplus.passport.api.impl;

import com.github.richterplus.common.api.LogApi;
import com.github.richterplus.common.api.bean.log.AppendLogReq;
import com.github.richterplus.common.api.bean.log.AppendLogRes;
import com.github.richterplus.common.api.enums.LogType;
import com.github.richterplus.passport.api.AccountApi;
import com.github.richterplus.passport.api.bean.account.LoginReq;
import com.github.richterplus.passport.api.bean.account.LoginRes;
import com.github.richterplus.passport.api.bean.account.RegisterAccountReq;
import com.github.richterplus.passport.api.bean.account.RegisterAccountRes;
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

        AppendLogRes appendLogRes = logApi.append(new AppendLogReq() {
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
}
