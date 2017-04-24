package com.rechart.service.loveaspectservice.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rechart.dao.loveaspectdao.LoveAspectDao;
import com.rechart.service.loveaspectservice.LoveAspectService;

/**
 * @author 郭明丽 
 * @version 创建时间：2016年9月24日 下午10:22:06 
 * 类说明 
*/
@Service("loveAspectService")
public class LoveAspectServiceImpl implements LoveAspectService {

	private LoveAspectDao loveAspectDao;
	
	@Override
	public List<Double> findLastWeekRefScore(String userId) {
		// TODO Auto-generated method stub
		return loveAspectDao.findLastWeekRefScore(userId);
	}

	@Override
	public List<Double> findThisWeekRefScore(String userId) {
		// TODO Auto-generated method stub
		return loveAspectDao.findThisWeekRefScore(userId);
	}

	@Override
	public List<Double> findLastWeekRealScore(String userId) {
		// TODO Auto-generated method stub
		return loveAspectDao.findLastWeekRealScore(userId);
	}

	@Override
	public List<Double> findThisWeekRealScore(String userId) {
		// TODO Auto-generated method stub
		return loveAspectDao.findThisWeekRealScore(userId);
	}

	public LoveAspectDao getLoveAspectDao() {
		return loveAspectDao;
	}

	@Resource
	public void setLoveAspectDao(LoveAspectDao loveAspectDao) {
		this.loveAspectDao = loveAspectDao;
	}		

}
