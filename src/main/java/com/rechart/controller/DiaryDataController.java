package com.rechart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rechart.form.diarydata.DiaryData;
import com.rechart.service.diarydataservice.DiaryDataService;
import com.rechart.utils.PageViewConstant;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author 郭明丽 
 * @version 创建时间：2017年4月27日 上午9:33:10 
 * 类说明 
*/
@Controller
@RequestMapping(value="/rechart/")
public class DiaryDataController {

	private DiaryDataService diaryDataService;
	
	@RequestMapping(value="DiaryDataChart")
	public ModelAndView DiaryData(String userId){
		ModelAndView view = new ModelAndView("rechart/DiaryDataChart");
		view.addObject("userId", userId);
		return view;
	}
	
	@RequestMapping(value="DiaryData")
	private String getDiaryData(String userId, Model model) throws Exception{
		
		List<Integer> wordCount = new ArrayList<Integer>();
		
		List<Integer> workCount = new ArrayList<Integer>();
		
		List<Integer> goldCount = new ArrayList<Integer>();
		
		if(userId != null){
			wordCount = diaryDataService.findWordCount(userId);
			workCount = diaryDataService.findWorkCount(userId);
			goldCount = diaryDataService.findGoldCount(userId);
		}
		
		DiaryData diaryData = new DiaryData(wordCount, workCount, goldCount);
		
		//利用JSON进行封装数据
		JSONArray jsonArray = new JSONArray();
		//获取学生学号
		JSONObject data = new JSONObject();
		data.put("wordCounts", diaryData.getWordCount());
		data.put("workCounts", diaryData.getWorkCount());
		data.put("goldCounts", diaryData.getGoldCount());
		
		jsonArray.add(data);
		model.addAttribute("json", jsonArray.toString());
		
		return PageViewConstant.JSON;
		
	}

	public DiaryDataService getDiaryDataService() {
		return diaryDataService;
	}

	@Resource
	public void setDiaryDataService(DiaryDataService diaryDataService) {
		this.diaryDataService = diaryDataService;
	}
	
}
