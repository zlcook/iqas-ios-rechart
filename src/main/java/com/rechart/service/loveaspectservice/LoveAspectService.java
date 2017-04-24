package com.rechart.service.loveaspectservice;

import java.util.List;

/**
 * @author 郭明丽 
 * @version 创建时间：2016年9月24日 下午10:21:40 
 * 类说明 
*/
public interface LoveAspectService {

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
