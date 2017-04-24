package com.rechart.entity.diarydata;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 郭明丽 
 * @version 创建时间：2016年9月18日 下午8:13:28 
 * 类说明 
*/
public class DiaryDatas implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6621882531843075081L;
	List<Integer> wordCounts = new ArrayList<Integer>();
	List<String> diaryDatas = new ArrayList<String>();
	
	public DiaryDatas(List<Integer> wordCounts, List<String> diaryDatas) {
		super();
		this.wordCounts = wordCounts;
		this.diaryDatas = diaryDatas;
	}
	public List<Integer> getWordCounts() {
		return wordCounts;
	}
	public void setWordCounts(List<Integer> wordCounts) {
		this.wordCounts = wordCounts;
	}
	public List<String> getDiaryDatas() {
		return diaryDatas;
	}
	public void setDiaryDatas(List<String> diaryDatas) {
		this.diaryDatas = diaryDatas;
	}
	
}
