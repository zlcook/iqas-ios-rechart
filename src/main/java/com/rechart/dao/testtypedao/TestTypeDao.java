package com.rechart.dao.testtypedao;

import java.util.List;

/**
 * @author 郭明丽 
 * @version 创建时间：2016年9月23日 上午10:45:19 
 * 类说明 
*/
public interface TestTypeDao {

	/**
	 * 获取每一种考查题型的总积累
	 * */
	public List<Double> findTestTypeCount(String userId);
	
	/**
	 * 获取每一种考查题型的参考值
	 * */
	public List<Double> findRefData(String userId);
	
	/**
	 * 获取每一种考查题型的实际值
	 * */
	public List<Double> findRealData(String userId);
}
