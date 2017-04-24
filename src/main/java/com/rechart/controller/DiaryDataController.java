package com.rechart.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rechart.entity.diarydata.DiaryData;
import com.rechart.entity.diarydata.DiaryDatas;
import com.rechart.service.diarydataservice.DiaryDataService;
import com.rechart.utils.PageViewConstant;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/**
 * @author 郭明丽 
 * @version 创建时间：2016年9月13日 下午2:02:32 
 * 类说明 
*/
@Controller
@RequestMapping(value="/rechart/")	
public class DiaryDataController {
	private DiaryDataService diaryDataService;
	
	@RequestMapping(value="DiaryWord")	
	public String DiaryWord(){
		System.out.println("jianlai");
		return "rechart/DiaryWord";		
	}
	@RequestMapping(value="WChart")
	private String getDiaryData(String userId,Model model) throws Exception{
		DiaryData diaryData = null;
		
		List<Integer> wordCounts = new ArrayList<Integer>();
		List<String> diaryDatas = new ArrayList<String>();
		
		userId = "2151002001";
		if(userId != null){					
			//获取当前日期
			Date ondate = new Date();				
			//设置前一天的时间
		    Date predate = new Date();
		    
		    for(int i = 6;i >= 0; --i){
		    	//日期格式规范
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");					
				long dif = ondate.getTime() - i * 86400 * 1000;					
				//设置前一天的时间
				predate.setTime(dif);
				//将日期转化为String格式
				String PreDate = sdf.format(predate);
				diaryData = diaryDataService.findDiaryData(userId, predate);
				
				diaryDatas.add(sdf.format(diaryData.getDiaryDate()));
				wordCounts.add(diaryData.getWordCount());					
		    }		    		    
		    //diaryData = new DiaryData(diaryDatas,wordCounts); 
		    //System.out.println(diaryData);
		}
		
		DiaryDatas dirays=new DiaryDatas(wordCounts, diaryDatas);
		
		//利用JSON进行封装数据
		JSONArray jsonArray = new JSONArray();
		//获取学生学号
		JSONObject data = new JSONObject();
		data.put("diaryDates", dirays.getDiaryDatas());
		data.put("wordCounts", dirays.getWordCounts());
		jsonArray.add(data);
		model.addAttribute("json",jsonArray.toString());
		//System.out.println(jsonArray.toString());
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
