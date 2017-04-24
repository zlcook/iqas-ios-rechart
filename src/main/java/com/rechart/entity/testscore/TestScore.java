package com.rechart.entity.testscore;

import java.util.List;

/**
 * @author 郭明丽 
 * @version 创建时间：2016年9月9日 下午3:55:42 
 * 类说明 
*/
public class TestScore {

	/**
	 * 上周小测成绩
	 * */
	private List<Double> lastWeekTestScore;
	
	/**
	 * 本周小测成绩
	 * */
	private List<Double> thisWeekTestScore;
	
	public TestScore(List<Double> lastWeekTestScore, List<Double> thisWeekTestScore) {
		super();
		this.lastWeekTestScore = lastWeekTestScore;
		this.thisWeekTestScore = thisWeekTestScore;
	}

	public List<Double> getLastWeekTestScore() {
		return lastWeekTestScore;
	}

	public void setLastWeekTestScore(List<Double> lastWeekTestScore) {
		this.lastWeekTestScore = lastWeekTestScore;
	}

	public List<Double> getThisWeekTestScore() {
		return thisWeekTestScore;
	}

	public void setThisWeekTestScore(List<Double> thisWeekTestScore) {
		this.thisWeekTestScore = thisWeekTestScore;
	}	
}
