package com.rechart.service.testaspectservice;

import java.util.List;


/**
 * @author 郭明丽 
 * @version 创建时间：2016年9月20日 下午4:07:41 
 * 类说明 
*/
public interface TestAspectService {
	
	/**
	 * 根据考察方面获取每一种考察方面的总记录
	 * */
	public List<Double> findTestAspectCount(String userId);		
	
	/**
	 * 根据考察方面获取每一种考察方面的参考值
	 * */
	public List<Double> findRefData(String userId);
	
	/**
	 * 根据考察方面获取每一种考察方面的实际值
	 * */
	public List<Double> findRealData(String userId);
}
