package com.rechart.entity.usertest;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* @author 周亮 
* @version 创建时间：2017年4月24日 下午7:08:24
* 类说明
*/
@Entity
@Table(name="user_test")
public class UserTest {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="usertest_id")
	private Integer usertestId;
	@Column(name="answertimes")
    private Integer answertimes;

	@Column(name="righttimes")
    private Integer righttimes;

	@Column(name="testin_time")
    private Date testinTime;

	@Column(name="testout_time")
    private Date testoutTime;

	@Column(name="testtype")
    private Integer testtype;

	@Column(name="user_id")
    private Integer userId;

	@Column(name="word")
    private String word;

	@Column(name="wrongtimes")
    private Integer wrongtimes;
  
	public UserTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getUsertestId() {
		return usertestId;
	}

	public void setUsertestId(Integer usertestId) {
		this.usertestId = usertestId;
	}

	public Integer getAnswertimes() {
		return answertimes;
	}

	public void setAnswertimes(Integer answertimes) {
		this.answertimes = answertimes;
	}

	public Integer getRighttimes() {
		return righttimes;
	}

	public void setRighttimes(Integer righttimes) {
		this.righttimes = righttimes;
	}

	public Date getTestinTime() {
		return testinTime;
	}

	public void setTestinTime(Date testinTime) {
		this.testinTime = testinTime;
	}

	public Date getTestoutTime() {
		return testoutTime;
	}

	public void setTestoutTime(Date testoutTime) {
		this.testoutTime = testoutTime;
	}

	public Integer getTesttype() {
		return testtype;
	}

	public void setTesttype(Integer testtype) {
		this.testtype = testtype;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Integer getWrongtimes() {
		return wrongtimes;
	}

	public void setWrongtimes(Integer wrongtimes) {
		this.wrongtimes = wrongtimes;
	}
    
}
