package com.rechart.entity.learntime;
/**
 * @author 郭明丽 
 * @version 创建时间：2016年9月9日 下午2:54:01 
 * 类说明 
*/
public class LearnTime {

	/**
	 * 上周学习总时长
	 * */
	private double last_week;
	/**
	 * 本周学习总时长
	 * */
	private double this_week;		
		
	
	public LearnTime() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LearnTime(double last_week, double this_week) {
		super();
		this.last_week = last_week;
		this.this_week = this_week;
	}

	public double getLast_week() {
		return last_week;
	}


	public void setLast_week(double last_week) {
		this.last_week = last_week;
	}


	public double getThis_week() {
		return this_week;
	}


	public void setThis_week(double this_week) {
		this.this_week = this_week;
	}
	
	
	
}
