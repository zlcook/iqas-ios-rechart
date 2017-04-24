package com.rechart.dao.loveaspectdao;

import java.util.List;

/**
 * @author 郭明丽 
 * @version 创建时间：2016年9月23日 下午2:27:28 
 * 类说明 
*/
public interface LoveAspectDao {

	/**
	 * 获取上周各考察方面的参考数据
	 * */
	public List<Double> findLastWeekRefScore(String userId);
	
	/**
	 * 获取本周各考察方面的参考数据
	 * */
	public List<Double> findThisWeekRefScore(String userId);
	
	/**
	 * 获取上周各考察方面的实际数据
	 * */
	public List<Double> findLastWeekRealScore(String userId);
	
	/**
	 * 获取本周各考察方面的实际数据
	 * */
	public List<Double> findThisWeekRealScore(String userId);
}
