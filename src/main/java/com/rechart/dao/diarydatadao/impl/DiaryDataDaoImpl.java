package com.rechart.dao.diarydatadao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.rechart.base.DaoSupport;
import com.rechart.dao.diarydatadao.DiaryDataDao;
import com.rechart.entity.diarydata.DiaryData;



/**
 * @author 郭明丽 
 * @version 创建时间：2016年9月12日 上午9:59:10 
 * 类说明 
*/

@Repository("diaryDataDao")
public class DiaryDataDaoImpl extends DaoSupport<DiaryData> implements DiaryDataDao{

	@Override
	public DiaryData findDiaryData(String userId, Date date) {
		// TODO Auto-generated method stub
		
		List<Integer> list = (List<Integer>) getHt().find("select count(date) from UserWord where UserId = ? and date = ?", userId,date);
		
		DiaryData diaryData = new DiaryData();
		diaryData.setDiaryDate(date);
		if(list != null && list.size() == 1){
			Number num = (Number)list.get(0);
			diaryData.setWordCount(num.intValue());
		}
		
		return diaryData;
	}
}
