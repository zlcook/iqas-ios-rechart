package com.rechart.entity.testaspect;

import java.util.List;

/**
 * @author 郭明丽 
 * @version 创建时间：2016年9月20日 下午3:17:14 
 * 类说明 
*/
public class TestAspect {

	private double testAspectCount;	//考察方式的总计数
	private List<Integer> testDifficulty;	//考察难度
	private double testDifficultySum;	//考察难度之和
	private double totalTimes;	//回答总次数
		
		
	public TestAspect() {
		super();
		// TODO Auto-generated constructor stub
	}


	public double getTestAspectCount() {
		return testAspectCount;
	}


	public void setTestAspectCount(double testAspectCount) {
		this.testAspectCount = testAspectCount;
	}


	public List<Integer> getTestDifficulty() {
		return testDifficulty;
	}


	public void setTestDifficulty(List<Integer> testDifficulty) {
		this.testDifficulty = testDifficulty;
	}


	public double getTestDifficultySum() {
		return testDifficultySum;
	}


	public void setTestDifficultySum(double testDifficultySum) {
		this.testDifficultySum = testDifficultySum;
	}


	public double getTotalTimes() {
		return totalTimes;
	}


	public void setTotalTimes(double totalTimes) {
		this.totalTimes = totalTimes;
	}				
}
