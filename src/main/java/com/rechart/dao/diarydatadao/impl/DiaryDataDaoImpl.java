package com.rechart.dao.diarydatadao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rechart.base.DaoSupport;
import com.rechart.dao.diarydatadao.DiaryDataDao;
import com.rechart.entity.diarydata.UserDiaryData;

/**
 * @author 郭明丽 
 * @version 创建时间：2017年4月27日 上午9:19:51 
 * 类说明 
*/
@Repository("diaryDataDao")
public class DiaryDataDaoImpl extends DaoSupport<UserDiaryData> implements DiaryDataDao {

	@Override
	public List<Integer> findWordCount(String userId) {
		// TODO Auto-generated method stub
		List<Integer> listWordCount = (List<Integer>) getHt().find("select wordCount from UserDiaryData as u where u.userId = ?", Integer.parseInt(userId));
		if(listWordCount != null && listWordCount.size() != 0){
			return listWordCount;
		}
		return null;
	}

	@Override
	public List<Integer> findWorkCount(String userId) {
		// TODO Auto-generated method stub
		List<Integer> listWorkCount = (List<Integer>) getHt().find("select workCount from UserDiaryData as u where u.userId = ?", Integer.parseInt(userId));
		if(listWorkCount != null && listWorkCount.size() != 0){
			return listWorkCount;
		}
		return null;
	}

	@Override
	public List<Integer> findGoldCount(String userId) {
		// TODO Auto-generated method stub
		List<Integer> listGoldCount = (List<Integer>) getHt().find("select goldCount from UserDiaryData as u where u.userId = ?", Integer.parseInt(userId));
		if(listGoldCount != null && listGoldCount.size() != 0){
			return listGoldCount;
		}
		return null;
	}

	
}
