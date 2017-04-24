package com.rechart.controller;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rechart.entity.testscore.TestScore;
import com.rechart.service.testscoreservice.TestScoreService;
import com.rechart.utils.PageViewConstant;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author 郭明丽 
 * @version 创建时间：2016年9月26日 上午9:04:36 
 * 类说明 
*/
@Controller
@RequestMapping(value = "/rechart/")
public class TestScoreController {

	private TestScoreService testScoreService;
	
	

	@RequestMapping(value = "TestScoreChart")
	private String TestScoreData(){
		return "rechart/TestScoreChart";		
	}
	
	@RequestMapping(value = "TestScore")
	private String getTestScore(String userId, Model model) throws Exception{
		
		userId = "001";
		
		List<Double> lastWeekRefScore = new ArrayList<Double>();	//定义list集合存储上周的参考数据						
		
		List<Double> thisWeekRefScore = new ArrayList<Double>();	//定义list集合存储本周的参考数据
		
		List<Double> lastWeekRealScore = new ArrayList<Double>();	//定义list集合存储上周的实际数据
		
		List<Double> thisWeekRealScore = new ArrayList<Double>();	//定义list集合存储本周的实际数据 
		
		List<Double> lastWeekAccuracy = new ArrayList<Double>();	//定义list集合存储上周的正确率
		
		List<Double> thisWeekAccuracy = new ArrayList<Double>();	//定义list集合存储本周的正确率
		
		if(userId != null){						
			lastWeekRefScore = testScoreService.findLastWeekRefScore(userId);	//获取每一种考察方面的总记录
			
			thisWeekRefScore = testScoreService.findThisWeekRefScore(userId);	//获取每一种考察方面的参考值
			
			lastWeekRealScore = testScoreService.findLastWeekRealScore(userId);	//获取每一种考察方面的实际值
			
			thisWeekRealScore = testScoreService.findThisWeekRealScore(userId);
			
			lastWeekAccuracy = this.getAccuracy(lastWeekRealScore, lastWeekRefScore);
			
			thisWeekAccuracy = this.getAccuracy(thisWeekRealScore, thisWeekRefScore);
					
		}
				
		TestScore testScore = new TestScore(lastWeekAccuracy, thisWeekAccuracy);
		
		//利用JSON进行封装数据
		JSONArray jsonArray = new JSONArray();
		//获取学生学号
		JSONObject data = new JSONObject();
		data.put("lastWeekDatas", testScore.getLastWeekTestScore());
		data.put("thisWeekDatas", testScore.getThisWeekTestScore());
		jsonArray.add(data);
		model.addAttribute("json",jsonArray.toString());
		return PageViewConstant.JSON;		
	}
	
	/**
	 * 计算正确率
	 * */
	public List<Double> getAccuracy(List<Double> realScore, List<Double> refScore){
		
		double[] realScore_double = new double[realScore.size()];
		double[] refScore_double = new double[refScore.size()];
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
	
	public TestScoreService getTestScoreService() {
		return testScoreService;
	}

	@Resource
	public void setTestScoreService(TestScoreService testScoreService) {
		this.testScoreService = testScoreService;
	}
}
