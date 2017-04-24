package com.rechart.service.learntimeservice;

import java.util.List;

import com.rechart.entity.learntime.LearnTime;

/**
 * @author 郭明丽 
 * @version 创建时间：2016年9月19日 上午9:51:13 
 * 类说明 
*/
public interface LearnTimeService {

	/**
	 *查询上周学习时长 
	 **/
	public double findLastWeekData(String userId);
	
	/**
	 * 查询本周学习时长
	 * */
	public double findThisWeekData(String userId);
}
