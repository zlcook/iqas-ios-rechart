package com.rechart.entity.logintime;

import java.util.Date;

/**
 * @author 郭明丽 
 * @version 创建时间：2017年4月27日 上午11:24:36 
 * 类说明 
*/
public class LoginTime {

	/**
	 * 登录日期
	 */
	private Date loginDate;
	
	/**
	 * 登录时长
	 */
	private int loginTime;

	public LoginTime() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginTime(Date loginDate, int loginTime) {
		super();
		this.loginDate = loginDate;
		this.loginTime = loginTime;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public int getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(int loginTime) {
		this.loginTime = loginTime;
	}
	
	
	
}
