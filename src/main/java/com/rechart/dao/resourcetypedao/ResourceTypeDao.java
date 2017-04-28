package com.rechart.dao.resourcetypedao;

import java.util.List;

/**
 * @author 郭明丽 
 * @version 创建时间：2017年4月27日 上午10:03:15 
 * 类说明 
*/
public interface ResourceTypeDao {

	/**
	 * 查询文本点击数量
	 * @param userId
	 * @return
	 */
	public List<Integer> findTextCount(String userId);
	
	/**
	 * 查询图片点击数量
	 * @param userId
	 * @return
	 */
	public List<Integer> findPictureCount(String userId);
	
	/**
	 * 查询音频点击数量
	 * @param userId
	 * @return
	 */
	public List<Integer> findAudioCount(String userId);
	
	/**
	 * 查询视频点击数量
	 * @param userId
	 * @return
	 */
	public List<Integer> findVideoCount(String userId);
}
