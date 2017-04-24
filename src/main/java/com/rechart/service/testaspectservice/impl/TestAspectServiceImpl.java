package com.rechart.service.testaspectservice.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rechart.dao.testaspectdao.TestAspectDao;
import com.rechart.service.testaspectservice.TestAspectService;

/**
 * @author 郭明丽 
 * @version 创建时间：2016年9月20日 下午4:08:13 
 * 类说明 
*/
@Service("testAspectService")
public class TestAspectServiceImpl implements TestAspectService {

	private TestAspectDao testAspectDao;
	
	@Override
	public List<Double> findTestAspectCount(String userId) {
		// TODO Auto-generated method stub
		return testAspectDao.findTestAspectCount(userId);
	}

	@Override
	public List<Double> findRefData(String userId) {
		// TODO Auto-generated method stub
		return testAspectDao.findRefData(userId);
	}

	@Override
	public List<Double> findRealData(String userId) {
		// TODO Auto-generated method stub
		return testAspectDao.findRealData(userId);
	}
	

	public TestAspectDao getTestAspectDao() {
		return testAspectDao;
	}

	@Resource
	public void setTestAspectDao(TestAspectDao testAspectDao) {
		this.testAspectDao = testAspectDao;
	}

	
}
