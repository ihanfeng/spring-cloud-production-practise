package com.github.richterplus.passport.api.bean.account;

import com.github.richterplus.passport.api.bean.PassportApiReq;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 鉴权请求
 */
public class ValidateTokenReq extends PassportApiReq {

    /**
     * 访问令牌
     */
    @ApiModelProperty("访问令牌")
    @NotNull
    @Size(min = 1)
    private String accessToken;

    /**
     * 获取访问令牌
     * @return 访问令牌
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * 设置访问令牌
     * @param accessToken 访问令牌
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
