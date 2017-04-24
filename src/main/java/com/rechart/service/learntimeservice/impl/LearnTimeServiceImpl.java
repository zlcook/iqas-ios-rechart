package com.rechart.service.learntimeservice.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rechart.dao.learntimedao.LearnTimeDao;
import com.rechart.entity.learntime.LearnTime;
import com.rechart.service.learntimeservice.LearnTimeService;

/**
 * @author 郭明丽 
 * @version 创建时间：2016年9月19日 上午9:52:06 
 * 类说明 
*/

@Service("learnTimeService")
public class LearnTimeServiceImpl implements LearnTimeService {

	private LearnTimeDao learnTimeDao;
	
	@Override
	public double findLastWeekData(String userId) {
		// TODO Auto-generated method stub
		return learnTimeDao.findLastWeekData(userId);
	}

	@Override
	public double findThisWeekData(String userId) {
		// TODO Auto-generated method stub
		return learnTimeDao.findThisWeekData(userId);
	}

	public LearnTimeDao getLearnTimeDao() {
		return learnTimeDao;
	}

	@Resource
	public void setLearnTimeDao(LearnTimeDao learnTimeDao) {
		this.learnTimeDao = learnTimeDao;
	}	
}
