package com.rechart.service.resourcetypeservice.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rechart.dao.resourcetypedao.ResourceTypeDao;
import com.rechart.service.resourcetypeservice.ResourceTypeService;

/**
 * @author 郭明丽 
 * @version 创建时间：2017年4月27日 上午10:20:36 
 * 类说明 
*/
@Service("resourceTypeService")
public class ResourceTypeServiceImpl implements ResourceTypeService {

	private ResourceTypeDao resourceTypeDao;
	
	@Override
	public List<Integer> findTextCount(String userId) {
		// TODO Auto-generated method stub
		return resourceTypeDao.findTextCount(userId);
	}

	@Override
	public List<Integer> findPictureCount(String userId) {
		// TODO Auto-generated method stub
		return resourceTypeDao.findPictureCount(userId);
	}

	@Override
	public List<Integer> findAudioCount(String userId) {
		// TODO Auto-generated method stub
		return resourceTypeDao.findAudioCount(userId);
	}

	@Override
	public List<Integer> findVideoCount(String userId) {
		// TODO Auto-generated method stub
		return resourceTypeDao.findVideoCount(userId);
	}

	public ResourceTypeDao getResourceTypeDao() {
		return resourceTypeDao;
	}

	@Resource
	public void setResourceTypeDao(ResourceTypeDao resourceTypeDao) {
		this.resourceTypeDao = resourceTypeDao;
	}

}
