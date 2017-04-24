package com.rechart.service.testtypeservice.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rechart.dao.testtypedao.TestTypeDao;
import com.rechart.service.testtypeservice.TestTypeService;

/**
 * @author 郭明丽 
 * @version 创建时间：2016年9月23日 上午11:13:33 
 * 类说明 
*/
@Service("testTypeService")
public class TestTypeServiceImpl implements TestTypeService {

	private TestTypeDao testTypeDao;

	@Override
	public List<Double> findTestTypeCount(String userId) {
		// TODO Auto-generated method stub
		return testTypeDao.findTestTypeCount(userId);
	}

	@Override
	public List<Double> findRefData(String userId) {
		// TODO Auto-generated method stub
		return testTypeDao.findRefData(userId);
	}

	@Override
	public List<Double> findRealData(String userId) {
		// TODO Auto-generated method stub
		return testTypeDao.findRealData(userId);
	}	
	
	public TestTypeDao getTestTypeDao() {
		return testTypeDao;
	}

	@Resource
	public void setTestTypeDao(TestTypeDao testTypeDao) {
		this.testTypeDao = testTypeDao;
	}

	
}
