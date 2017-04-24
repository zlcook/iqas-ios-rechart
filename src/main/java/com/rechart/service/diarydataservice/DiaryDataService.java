package com.rechart.service.diarydataservice;

import java.util.Date;
import java.util.List;

import com.rechart.entity.diarydata.DiaryData;


/**
 * @author 郭明丽 
 * @version 创建时间：2016年9月12日 上午10:25:50 
 * 类说明 
*/
public interface DiaryDataService {

	public DiaryData findDiaryData(String userId,Date Date);
	
}
