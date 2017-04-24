package com.rechart.entity.diarydata;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author 郭明丽 
 * @version 创建时间：2016年9月9日 下午2:49:14 
 * 类说明 
*/
public class DiaryData {
	/**
	 * 学习日期
	 * */
	private Date diaryDate;	
	/**
	 * 每日学习单词数量
	 * */
	private int wordCount;
		
	public DiaryData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Date getDiaryDate() {
		return diaryDate;
	}

	public void setDiaryDate(Date diaryDate) {
		this.diaryDate = diaryDate;
	}

	public int getWordCount() {
		return wordCount;
	}

	public void setWordCount(int wordCount) {
		this.wordCount = wordCount;
	}	
						
}
