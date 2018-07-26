package com.github.richterplus.passport.entity;

import java.util.Date;

/**
 * 授权
 */
public class Authorization {

    /**
     * 访问令牌
     */
    private String accessToken;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 过期时间
     */
    private Date expireDate;

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

    /**
     * 获取用户id
     * @return 用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     * @param userId 用户id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取过期时间
     * @return 过期时间
     */
    public Date getExpireDate() {
        return expireDate;
    }

    /**
     * 设置过期时间
     * @param expireDate 过期时间
     */
    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }
}
