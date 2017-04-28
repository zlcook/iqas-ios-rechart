package com.rechart.dao.logintimedao;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 郭明丽 
 * @version 创建时间：2017年4月27日 上午11:29:38 
 * 类说明 
*/
public interface LoginTimeDao {

	public LinkedHashMap<String, Integer> findLoginTime(String userId);
}
