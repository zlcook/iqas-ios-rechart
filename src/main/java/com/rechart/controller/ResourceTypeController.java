package com.rechart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rechart.form.resourcetype.ResourceType;
import com.rechart.service.resourcetypeservice.ResourceTypeService;
import com.rechart.utils.PageViewConstant;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author 郭明丽 
 * @version 创建时间：2017年4月27日 上午10:24:21 
 * 类说明 
*/
@Controller
@RequestMapping(value="/rechart/")
public class ResourceTypeController {

	private ResourceTypeService resourceTypeService;
	
	@RequestMapping(value="ResourceTypeChart")
	public ModelAndView ResourceType(String userId){
		ModelAndView view = new ModelAndView("rechart/ResourceTypeChart");
		view.addObject("userId", userId);
		return view;
	}
	
	@RequestMapping(value = "ResourceType")
	private String getResourceType(String userId, Model model) throws Exception{
		
		List<Integer> textCount = new ArrayList<Integer>();
		
		List<Integer> pictureCount = new ArrayList<Integer>();
		
		List<Integer> audioCount = new ArrayList<Integer>();
		
		List<Integer> videoCount = new ArrayList<Integer>();
		
		if(userId != null){
			textCount = resourceTypeService.findTextCount(userId);
			pictureCount = resourceTypeService.findPictureCount(userId);
			audioCount = resourceTypeService.findAudioCount(userId);
			videoCount = resourceTypeService.findVideoCount(userId);
		}
		
		ResourceType resourceType = new ResourceType(textCount, pictureCount, audioCount, videoCount);
		//利用JSON进行封装数据
		JSONArray jsonArray = new JSONArray();
		//获取学生学号
		JSONObject data = new JSONObject();
		data.put("textCounts", resourceType.getTextCount());
		data.put("pictureCounts", resourceType.getPictureCount());
		data.put("audioCounts", resourceType.getAudioCount());
		data.put("videoCounts", resourceType.getVideoCount());
		
		jsonArray.add(data);
		model.addAttribute("json", jsonArray.toString());
		
		return PageViewConstant.JSON;
		
	}

	public ResourceTypeService getResourceTypeService() {
		return resourceTypeService;
	}

	@Resource
	public void setResourceTypeService(ResourceTypeService resourceTypeService) {
		this.resourceTypeService = resourceTypeService;
	}
}
