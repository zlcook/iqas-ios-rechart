package com.rechart.entity.resourcetype;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 郭明丽 
 * @version 创建时间：2017年4月27日 上午9:55:19 
 * 类说明 
*/
@Entity
@Table(name="user")
public class UserResourceType {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private Integer userId;
	@Column(name="resourcecount1")
	private Integer textCount;
	@Column(name="resourcecount2")
	private Integer pictureCount;
	@Column(name="resourcecount3")
	private Integer audioCount;
	@Column(name="resourcecount4")
	private Integer videoCount;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getTextCount() {
		return textCount;
	}
	public void setTextCount(Integer textCount) {
		this.textCount = textCount;
	}
	public Integer getPictureCount() {
		return pictureCount;
	}
	public void setPictureCount(Integer pictureCount) {
		this.pictureCount = pictureCount;
	}
	public Integer getAudioCount() {
		return audioCount;
	}
	public void setAudioCount(Integer audioCount) {
		this.audioCount = audioCount;
	}
	public Integer getVideoCount() {
		return videoCount;
	}
	public void setVideoCount(Integer videoCount) {
		this.videoCount = videoCount;
	}
}
