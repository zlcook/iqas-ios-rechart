package com.rechart.service.diarydataservice.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rechart.dao.diarydatadao.DiaryDataDao;
import com.rechart.entity.diarydata.DiaryData;
import com.rechart.service.diarydataservice.DiaryDataService;


/**
 * @author 郭明丽 
 * @version 创建时间：2016年9月12日 上午10:33:47 
 * 类说明 
*/
@Service("diaryDataService")
public class DiaryDataServiceImpl implements DiaryDataService {

	private DiaryDataDao diaryDataDao;
	
	public DiaryDataDao getDiaryDataDao() {
		return diaryDataDao;
	}
	@Resource
	public void setDiaryDataDao(DiaryDataDao diaryDataDao) {
		this.diaryDataDao = diaryDataDao;
	}
	
	@Override
	public DiaryData findDiaryData(String userId, Date date) {
		// TODO Auto-generated method stub			
		return diaryDataDao.findDiaryData(userId, date);
	}
}
