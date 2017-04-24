package com.rechart.service.testscoreservice.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rechart.dao.testscoredao.TestScoreDao;
import com.rechart.service.testscoreservice.TestScoreService;

/**
 * @author 郭明丽 
 * @version 创建时间：2016年9月25日 下午10:16:17 
 * 类说明 
*/
@Service("testScoreService")
public class TestScoreServiceImpl implements TestScoreService {

	private TestScoreDao testScoreDao;
	
	@Override
	public List<Double> findLastWeekRefScore(String userId) {
		// TODO Auto-generated method stub
		return testScoreDao.findLastWeekRefScore(userId);
	}

	@Override
	public List<Double> findThisWeekRefScore(String userId) {
		// TODO Auto-generated method stub
		return testScoreDao.findThisWeekRefScore(userId);
	}

	@Override
	public List<Double> findLastWeekRealScore(String userId) {
		// TODO Auto-generated method stub
		return testScoreDao.findLastWeekRealScore(userId);
	}

	@Override
	public List<Double> findThisWeekRealScore(String userId) {
		// TODO Auto-generated method stub
		return testScoreDao.findThisWeekRealScore(userId);
	}

	public TestScoreDao getTestScoreDao() {
		return testScoreDao;
	}

	@Resource
	public void setTestScoreDao(TestScoreDao testScoreDao) {
		this.testScoreDao = testScoreDao;
	}

}
