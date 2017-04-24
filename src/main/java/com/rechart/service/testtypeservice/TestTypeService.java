package com.rechart.service.testtypeservice;

import java.util.List;

/**
 * @author 郭明丽 
 * @version 创建时间：2016年9月23日 上午11:13:04 
 * 类说明 
*/
public interface TestTypeService {
	/**
	 * 获取每一种考查题型的回答次数
	 * */
	public List<Double> findAnswerCount(String userId);
	
	/**
	 * 获取每一种考查题型的正确次数
	 * */
	public List<Double> findRightCount(String userId);	
}
