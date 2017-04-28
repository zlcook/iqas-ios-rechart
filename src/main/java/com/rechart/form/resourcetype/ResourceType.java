package com.rechart.form.resourcetype;

import java.util.List;

/**
 * @author 郭明丽 
 * @version 创建时间：2017年4月27日 上午9:59:24 
 * 类说明 
*/
public class ResourceType {

	private List<Integer> textCount;	
	private List<Integer> pictureCount;
	private List<Integer> audioCount;
	private List<Integer> videoCount;
	
	public ResourceType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResourceType(List<Integer> textCount, List<Integer> pictureCount, List<Integer> audioCount,
			List<Integer> videoCount) {
		super();
		this.textCount = textCount;
		this.pictureCount = pictureCount;
		this.audioCount = audioCount;
		this.videoCount = videoCount;
	}

	public List<Integer> getTextCount() {
		return textCount;
	}

	public void setTextCount(List<Integer> textCount) {
		this.textCount = textCount;
	}

	public List<Integer> getPictureCount() {
		return pictureCount;
	}

	public void setPictureCount(List<Integer> pictureCount) {
		this.pictureCount = pictureCount;
	}

	public List<Integer> getAudioCount() {
		return audioCount;
	}

	public void setAudioCount(List<Integer> audioCount) {
		this.audioCount = audioCount;
	}

	public List<Integer> getVideoCount() {
		return videoCount;
	}

	public void setVideoCount(List<Integer> videoCount) {
		this.videoCount = videoCount;
	}
	
}
