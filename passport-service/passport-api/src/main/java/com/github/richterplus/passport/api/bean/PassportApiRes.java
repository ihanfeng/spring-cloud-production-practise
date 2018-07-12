package com.github.richterplus.passport.api.bean;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * passport-api响应数据
 */
public abstract class PassportApiRes {

    /**
     * 响应日期
     */
    @ApiModelProperty("响应日期")
    private Date responseDateTime = new Date();

	/**
	 * @return 响应日期
	 */
	public Date getResponseDateTime() {
		return responseDateTime;
	}

	/**
	 * @param responseDateTime 响应日期
	 */
	public void setResponseDateTime(Date responseDateTime) {
		this.responseDateTime = responseDateTime;
	}
}