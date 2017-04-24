package com.rechart.entity.loveaspect;

import java.util.List;

/**
 * @author 郭明丽 
 * @version 创建时间：2016年9月9日 下午2:56:42 
 * 类说明 
*/
public class LoveAspect {

	/**
	 * 上周最爱的闯关方式
	 * */
	private List<Double> lastWeekLoveAspect;

	/**
	 * 本周最爱的闯关方式
	 * */
	private List<Double> thisWeekLoveAspect;

	public LoveAspect() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	public LoveAspect(List<Double> lastWeekLoveAspect, List<Double> thisWeekLoveAspect) {
		super();
		this.lastWeekLoveAspect = lastWeekLoveAspect;
		this.thisWeekLoveAspect = thisWeekLoveAspect;
	}

	public List<Double> getLastWeekLoveAspect() {
		return lastWeekLoveAspect;
	}

	public void setLastWeekLoveAspect(List<Double> lastWeekLoveAspect) {
		this.lastWeekLoveAspect = lastWeekLoveAspect;
	}

	public List<Double> getThisWeekLoveAspect() {
		return thisWeekLoveAspect;
	}

	public void setThisWeekLoveAspect(List<Double> thisWeekLoveAspect) {
		this.thisWeekLoveAspect = thisWeekLoveAspect;
	}
		
}
