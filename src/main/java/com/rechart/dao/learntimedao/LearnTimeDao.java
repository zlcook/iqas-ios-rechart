package com.rechart.dao.learntimedao;

import java.util.List;

import com.rechart.entity.learntime.LearnTime;

/**
 * @author 郭明丽 
 * @version 创建时间：2016年9月19日 上午9:04:09 
 * 类说明 
*/
public interface LearnTimeDao {
	
	/**
	 *查询上周学习时长 
	 **/
	public double findLastWeekData(String userId);
	
	/**
	 * 查询本周学习时长
	 * */
	public double findThisWeekData(String userId);
}
