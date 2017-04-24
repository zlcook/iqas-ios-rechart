package com.rechart.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rechart.entity.learntime.LearnTime;
import com.rechart.service.learntimeservice.LearnTimeService;
import com.rechart.utils.PageViewConstant;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author 郭明丽 
 * @version 创建时间：2016年9月19日 上午9:57:12 
 * 类说明 
*/
@Controller
@RequestMapping(value="/rechart/")
public class LearnTimeDataController {

	private LearnTimeService learnTimeService;

	@RequestMapping(value="LearnTimeChart")
	public ModelAndView LearnTimeData(String userId){
		ModelAndView view = new ModelAndView("rechart/LearnTimeChart");
		view.addObject("userId", userId);
		return view;
	}
	
	@RequestMapping(value="LearnTime")
	public String getLearnTime(String userId,Model model) throws Exception{				
		double lastWeekLearnTime = 0; 
		double thisWeekLearnTime =  0;
		lastWeekLearnTime = learnTimeService.findLastWeekData(userId);
		thisWeekLearnTime = learnTimeService.findThisWeekData(userId);
		
		LearnTime learnTime = new LearnTime(lastWeekLearnTime, thisWeekLearnTime);
		//利用JSON进行封装数据
		JSONArray jsonArray = new JSONArray();
		//获取学生学号
		JSONObject data = new JSONObject();
		data.put("lastWeekDatas", learnTime.getLast_week());
		data.put("thisWeekDatas", learnTime.getThis_week());
		jsonArray.add(data);
		model.addAttribute("json", jsonArray.toString());
		
		return PageViewConstant.JSON;
	}
	
	public LearnTimeService getLearnTimeService() {
		return learnTimeService;
	}

	@Resource
	public void setLearnTimeService(LearnTimeService learnTimeService) {
		this.learnTimeService = learnTimeService;
	}		
	
}
