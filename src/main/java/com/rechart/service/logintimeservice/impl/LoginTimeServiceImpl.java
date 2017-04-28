package com.rechart.service.logintimeservice.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rechart.dao.logintimedao.LoginTimeDao;
import com.rechart.service.logintimeservice.LoginTimeService;

/**
 * @author 郭明丽 
 * @version 创建时间：2017年4月27日 下午10:07:18 
 * 类说明 
*/
@Service("loginTimeService")
public class LoginTimeServiceImpl implements LoginTimeService {

	
	private LoginTimeDao loginTimeDao;
	@Override
	public LinkedHashMap<String, Integer> findLoginTime(String userId) {
		// TODO Auto-generated method stub
		return loginTimeDao.findLoginTime(userId);
	}
	public LoginTimeDao getLoginTimeDao() {
		return loginTimeDao;
	}
	@Resource
	public void setLoginTimeDao(LoginTimeDao loginTimeDao) {
		this.loginTimeDao = loginTimeDao;
	}

}
