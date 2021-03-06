package com.github.richterplus.passport.api.bean.account;

import com.github.richterplus.passport.api.bean.PassportApiRes;

/**
 * 登录响应
 */
public class LoginRes extends PassportApiRes {

    /**
     * 访问令牌
     */
    private String accessToken;

    /**
     * @return 访问令牌
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * @param accessToken 访问令牌
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
