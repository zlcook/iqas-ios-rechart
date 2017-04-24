package com.rechart.entity.testtype;

import java.util.List;

/**
 * @author 郭明丽 
 * @version 创建时间：2016年9月23日 上午10:37:21 
 * 类说明 
*/
public class TestTypes {

	/**
	 * 测试题型
	 * */
	private List<Double> testTypeData;
	/**
	 * 测试题型正确率
	 * */
	private List<Double> testTypeScore;		
	
	public TestTypes(List<Double> testTypeData, List<Double> testTypeScore) {
		super();
		this.testTypeData = testTypeData;
		this.testTypeScore = testTypeScore;
	}
		
	public List<Double> getTestTypeData() {
		return testTypeData;
	}
	public void setTestTypeData(List<Double> testTypeData) {
		this.testTypeData = testTypeData;
	}
	public List<Double> getTestTypeScore() {
		return testTypeScore;
	}
	public void setTestTypeScore(List<Double> testTypeScore) {
		this.testTypeScore = testTypeScore;
	}
	
	
}
