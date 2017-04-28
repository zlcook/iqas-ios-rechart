package com.rechart.entity.diarydata;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 郭明丽 
 * @version 创建时间：2017年4月27日 上午9:12:55 
 * 类说明 
*/
@Entity
@Table(name="user")
public class UserDiaryData {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private Integer userId;
	@Column(name="wordcount")
	private Integer wordCount;
	@Column(name="workcount")
	private Integer workCount;
	@Column(name="score")
	private Integer goldCount;
	
	public UserDiaryData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getWordCount() {
		return wordCount;
	}
	public void setWordCount(Integer wordCount) {
		this.wordCount = wordCount;
	}
	public Integer getWorkCount() {
		return workCount;
	}
	public void setWorkCount(Integer workCount) {
		this.workCount = workCount;
	}
	public Integer getGoldCount() {
		return goldCount;
	}
	public void setGoldCount(Integer goldCount) {
		this.goldCount = goldCount;
	}
	
	
}
