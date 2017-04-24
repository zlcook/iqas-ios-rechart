package com.rechart.dao.testscoredao;

import java.util.List;

/**
 * @author 郭明丽 
 * @version 创建时间：2016年9月25日 下午10:03:38 
 * 类说明 
*/
public interface TestScoreDao {

	/**
	 * 获取上周的参考数据
	 * */
	public List<Double> findLastWeekRefScore(String userId);
	
	/**
	 * 获取本周的参考数据
	 * */
	public List<Double> findThisWeekRefScore(String userId);
	
	/**
	 * 获取上周的实际数据
	 * */
	public List<Double> findLastWeekRealScore(String userId);
	
	/**
	 * 获取本周的实际数据
	 * */
	public List<Double> findThisWeekRealScore(String userId);
}
