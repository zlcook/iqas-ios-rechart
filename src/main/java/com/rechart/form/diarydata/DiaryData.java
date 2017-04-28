package com.rechart.form.diarydata;

import java.util.List;

/**
 * @author 郭明丽 
 * @version 创建时间：2017年4月27日 上午9:39:15 
 * 类说明 
*/
public class DiaryData {

	private List<Integer> wordCount;
	
	private List<Integer> workCount;
	
	private List<Integer> goldCount;

	public DiaryData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DiaryData(List<Integer> wordCount, List<Integer> workCount, List<Integer> goldCount) {
		super();
		this.wordCount = wordCount;
		this.workCount = workCount;
		this.goldCount = goldCount;
	}

	public List<Integer> getWordCount() {
		return wordCount;
	}

	public void setWordCount(List<Integer> wordCount) {
		this.wordCount = wordCount;
	}

	public List<Integer> getWorkCount() {
		return workCount;
	}

	public void setWorkCount(List<Integer> workCount) {
		this.workCount = workCount;
	}

	public List<Integer> getGoldCount() {
		return goldCount;
	}

	public void setGoldCount(List<Integer> goldCount) {
		this.goldCount = goldCount;
	}
	
}
