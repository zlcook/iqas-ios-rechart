package com.rechart.dao.diarydatadao;

import java.util.List;

/**
 * @author 郭明丽 
 * @version 创建时间：2017年4月27日 上午9:19:31 
 * 类说明 
*/
public interface DiaryDataDao {

	/**
	 * 查询单词数量
	 * @param userId
	 * @return
	 */
	public List<Integer> findWordCount(String userId);
	
	/**
	 * 查询上传作品数量
	 * @param userId
	 * @return
	 */
	public List<Integer> findWorkCount(String userId);
	
	/**
	 * 查询金币获取数量
	 * @param userId
	 * @return
	 */
	public List<Integer> findGoldCount(String userId);
	
	
}
