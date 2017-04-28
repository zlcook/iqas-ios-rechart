package com.rechart.dao.resourcetypedao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rechart.base.DaoSupport;
import com.rechart.dao.resourcetypedao.ResourceTypeDao;
import com.rechart.entity.resourcetype.UserResourceType;

/**
 * @author 郭明丽 
 * @version 创建时间：2017年4月27日 上午10:03:39 
 * 类说明 
*/
@Repository("resourceTypeDao")
public class ResourceTypeDaoImpl extends DaoSupport<UserResourceType> implements ResourceTypeDao {
	
	@Override
	public List<Integer> findTextCount(String userId) {
		// TODO Auto-generated method stub
		List<Integer> listTextCount = (List<Integer>) getHt().find("select textCount from UserResourceType as u where u.userId = ?", Integer.parseInt(userId));
		if(listTextCount != null && listTextCount.size() != 0){			
			return listTextCount;
		}
		return null;
	}

	@Override
	public List<Integer> findPictureCount(String userId) {
		// TODO Auto-generated method stub
		List<Integer> listPictureCount = (List<Integer>) getHt().find("select pictureCount from UserResourceType as u where u.userId = ?", Integer.parseInt(userId));
		if(listPictureCount != null && listPictureCount.size() != 0){			
			return listPictureCount;
		}
		return null;
	}

	@Override
	public List<Integer> findAudioCount(String userId) {
		// TODO Auto-generated method stub
		List<Integer> listAudioCount = (List<Integer>) getHt().find("select audioCount from UserResourceType as u where u.userId = ?", Integer.parseInt(userId));
		if(listAudioCount != null && listAudioCount.size() != 0){			
			return listAudioCount;
		}
		return null;
	}

	@Override
	public List<Integer> findVideoCount(String userId) {
		// TODO Auto-generated method stub
		List<Integer> listVideoCount = (List<Integer>) getHt().find("select videoCount from UserResourceType as u where u.userId = ?", Integer.parseInt(userId));
		if(listVideoCount != null && listVideoCount.size() != 0){			
			return listVideoCount;
		}
		return null;
	}

}
