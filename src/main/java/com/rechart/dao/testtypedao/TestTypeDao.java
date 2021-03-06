package com.rechart.dao.testtypedao;

import java.util.List;

/**
 * @author 郭明丽 
 * @version 创建时间：2016年9月23日 上午10:45:19 
 * 类说明 
*/
public interface TestTypeDao {

	/**
	 * 获取每一种考查题型的回答次数
	 * */
	public List<Double> findAnswerCount(String userId);
	
	/**
	 * 获取每一种考查题型的正确次数
	 * */
	public List<Double> findRightCount(String userId);
	
}
