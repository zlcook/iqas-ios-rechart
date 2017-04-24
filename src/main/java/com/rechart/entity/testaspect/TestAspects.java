package com.rechart.entity.testaspect;

import java.io.Serializable;
import java.util.List;

/**
 * @author 郭明丽 
 * @version 创建时间：2016年9月9日 下午3:53:35 
 * 类说明 
*/
public class TestAspects implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 考察方面
	 * */
	private List<Double> testAspectData;
	/**
	 * 考察方面成绩
	 * */
	private List<Double> testAspectScore;
	
	public TestAspects(List<Double> testAspectData, List<Double> testAspectScore) {
		super();
		this.testAspectData = testAspectData;
		this.testAspectScore = testAspectScore;
	}
	public List<Double> getTestAspectData() {
		return testAspectData;
	}
	public void setTestAspectData(List<Double> testAspectData) {
		this.testAspectData = testAspectData;
	}
	public List<Double> getTestAspectScore() {
		return testAspectScore;
	}
	public void setTestAspectScore(List<Double> testAspectScore) {
		this.testAspectScore = testAspectScore;
	}
}
