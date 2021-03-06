package com.rechart.service.logintimeservice;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 郭明丽 
 * @version 创建时间：2017年4月27日 下午10:03:31 
 * 类说明 
*/
public interface LoginTimeService {

	/**
	 * 查询最近七天登录时长
	 * @param userId
	 * @return
	 */
	public LinkedHashMap<String, Integer> findLoginTime(String userId);
	
}
