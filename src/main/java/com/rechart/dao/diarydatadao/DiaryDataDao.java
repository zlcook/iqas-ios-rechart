package com.rechart.dao.diarydatadao;

import java.util.Date;
import java.util.List;

import com.rechart.entity.diarydata.DiaryData;



/**
 * @author 郭明丽 
 * @version 创建时间：2016年9月12日 上午9:58:00 
 * 类说明 
*/
public interface DiaryDataDao {
	
	public DiaryData findDiaryData(String userId, Date date);

}

