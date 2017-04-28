package com.rechart.service.diarydataservice.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rechart.dao.diarydatadao.DiaryDataDao;
import com.rechart.service.diarydataservice.DiaryDataService;

/**
 * @author 郭明丽 
 * @version 创建时间：2017年4月27日 上午9:29:44 
 * 类说明 
*/
@Service("diaryDataService")
public class DiaryDataServiceImpl implements DiaryDataService {

	private DiaryDataDao diaryDataDao;
	
	@Override
	public List<Integer> findWordCount(String userId) {
		// TODO Auto-generated method stub
		return diaryDataDao.findWordCount(userId);
	}

	@Override
	public List<Integer> findWorkCount(String userId) {
		// TODO Auto-generated method stub
		return diaryDataDao.findWorkCount(userId);
	}

	@Override
	public List<Integer> findGoldCount(String userId) {
		// TODO Auto-generated method stub
		return diaryDataDao.findGoldCount(userId);
	}

	public DiaryDataDao getDiaryDataDao() {
		return diaryDataDao;
	}

	@Resource
	public void setDiaryDataDao(DiaryDataDao diaryDataDao) {
		this.diaryDataDao = diaryDataDao;
	}

	
	
}
