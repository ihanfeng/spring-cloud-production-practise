package com.github.richterplus.common.api.bean;

import java.util.Date;

/**
 * common-api响应数据
 */
public abstract class CommonApiRes {

    /**
     * 响应日期
     */
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