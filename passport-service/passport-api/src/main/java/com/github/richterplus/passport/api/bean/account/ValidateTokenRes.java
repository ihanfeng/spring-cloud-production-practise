package com.github.richterplus.passport.api.bean.account;

import com.github.richterplus.passport.api.bean.PassportApiRes;
import io.swagger.annotations.ApiModelProperty;

/**
 * 鉴权响应
 */
public class ValidateTokenRes extends PassportApiRes {

    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private Integer userId;

    /**
     * 获取用户id
     * @return 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
