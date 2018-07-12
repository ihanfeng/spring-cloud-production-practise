package com.github.richterplus.passport.api;

import com.github.richterplus.passport.api.bean.account.LoginReq;
import com.github.richterplus.passport.api.bean.account.LoginRes;
import com.github.richterplus.passport.api.bean.account.RegisterAccountReq;
import com.github.richterplus.passport.api.bean.account.RegisterAccountRes;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 账号API
 */
@RequestMapping("account")
public interface AccountApi {

    /**
     * 注册
     */
    @ApiOperation("注册")
    @RequestMapping(method = RequestMethod.PUT, value = "register")
    RegisterAccountRes register(@RequestBody RegisterAccountReq req);

    /**
     * 登录
     */
    @ApiOperation("登录")
    @RequestMapping(method = RequestMethod.POST, value = "login")
    LoginRes login(@RequestBody @Validated LoginReq req);
}
