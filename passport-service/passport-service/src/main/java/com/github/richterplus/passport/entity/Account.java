package com.github.richterplus.passport.entity;

/**
 * 账号
 */
public class Account {

    /**
     * 账号id
     */
    private Integer accountId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 注册日期
     */
    private java.util.Date registerDate;

    /**
     * 获取账号id
     * @return 账号id
     */
    public Integer getAccountId() {
        return accountId;
    }

    /**
     * 设置账号id
     * @param accountId 账号id
     */
    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    /**
     * 获取用户名
     * @return 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     * @return 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取注册日期
     * @return 注册日期
     */
    public java.util.Date getRegisterDate() {
        return registerDate;
    }

    /**
     * 设置注册日期
     * @param registerDate 注册日期
     */
    public void setRegisterDate(java.util.Date registerDate) {
        this.registerDate = registerDate;
    }

}