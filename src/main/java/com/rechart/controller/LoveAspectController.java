package com.rechart.controller;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rechart.entity.loveaspect.LoveAspect;
import com.rechart.service.loveaspectservice.LoveAspectService;
import com.rechart.utils.PageViewConstant;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author 郭明丽 
 * @version 创建时间：2016年9月25日 下午9:01:39 
 * 类说明 
*/
@Controller
@RequestMapping(value = "/rechart/")
public class LoveAspectController {

	private LoveAspectService loveAspectService;

	@RequestMapping(value = "LoveAspectChart")
	private String TestAspectData(){
		return "rechart/LoveAspectChart";
	}
	
	@RequestMapping(value = "LoveAspect")
	private String getLoveAspect(String userId, Model model) throws Exception{
		
		userId = "001";
		
		List<Double> lastWeekRefScore = new ArrayList<Double>();	//定义list集合存储上周各考察方面的参考数据						
		
		List<Double> thisWeekRefScore = new ArrayList<Double>();	//定义list集合存储本周各考察方面的参考数据
		
		List<Double> lastWeekRealScore = new ArrayList<Double>();	//定义list集合存储上周各考察方面的实际数据
		
		List<Double> thisWeekRealScore = new ArrayList<Double>();	//定义list集合存储本周各考察方面的实际数据 
		
		List<Double> lastWeekAccuracy = new ArrayList<Double>();	//定义list集合存储上周各考察方面的正确率
		
		List<Double> thisWeekAccuracy = new ArrayList<Double>();	//定义list集合存储本周各考察方面的正确率
		
		if(userId != null){						
			lastWeekRefScore = loveAspectService.findLastWeekRefScore(userId);	//获取每一种考察方面的总记录
			
			thisWeekRefScore = loveAspectService.findThisWeekRefScore(userId);	//获取每一种考察方面的参考值
			
			lastWeekRealScore = loveAspectService.findLastWeekRealScore(userId);	//获取每一种考察方面的实际值
			
			thisWeekRealScore = loveAspectService.findThisWeekRealScore(userId);
			
			lastWeekAccuracy = this.getAccuracy(lastWeekRealScore, lastWeekRefScore);
			
			thisWeekAccuracy = this.getAccuracy(thisWeekRealScore, thisWeekRefScore);		
		}		
		
		LoveAspect loveAspect = new LoveAspect(lastWeekAccuracy, thisWeekAccuracy);
		
		//利用JSON进行封装数据
		JSONArray jsonArray = new JSONArray();
		//获取学生学号
		JSONObject data = new JSONObject();
		data.put("lastWeekDatas", loveAspect.getLastWeekLoveAspect());
		data.put("thisWeekDatas", loveAspect.getThisWeekLoveAspect());
		jsonArray.add(data);
		model.addAttribute("json",jsonArray.toString());
		return PageViewConstant.JSON;		
	}
	
	/**
	 * 计算正确率
	 * */
	public List<Double> getAccuracy(List<Double> realScore, List<Double> refScore){
		
		double[] refScore_double = new double[refScore.size()];
		double[] realScore_double = new double[realScore.size()];
		List<Double> testScore_double = new ArrayList<Double>();
		
		for (int i = 0; i < refScore.size(); ++i) {
			
				Number numRefScore = (Number)refScore.get(i);			
				refScore_double[i] = numRefScore.doubleValue();
			
				Number numRealScore = (Number)realScore.get(i);
				realScore_double[i] = numRealScore.doubleValue();
			 
	  
		        // 创建一个数值格式化对象  		  
		        NumberFormat numberFormat = NumberFormat.getInstance();  
		        
		        // 设置精确到小数点后2位  		  
		        numberFormat.setMaximumFractionDigits(2);  
		        
		        if(realScore_double[i] != 0){
		        	String result = numberFormat.format((realScore_double[i]/refScore_double[i])*100); 		        
		        	double testScores = Double.parseDouble(result);		        	
		        	testScore_double.add(testScores);
		        }
			}        			        
		return testScore_double;	
	}
	
	public LoveAspectService getLoveAspectService() {
		return loveAspectService;
	}

	@Resource
	public void setLoveAspectService(LoveAspectService loveAspectService) {
		this.loveAspectService = loveAspectService;
	}
	
	
}
