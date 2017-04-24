package com.rechart.controller;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rechart.entity.testaspect.TestAspects;
import com.rechart.service.testaspectservice.TestAspectService;
import com.rechart.utils.PageViewConstant;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author 郭明丽 
 * @version 创建时间：2016年9月23日 上午9:05:08 
 * 类说明 
*/
@Controller
@RequestMapping(value = "/rechart/")
public class TestAspectController {

	private TestAspectService testAspectService;			

	@RequestMapping(value = "TestAspectChart")
	private String TestAspectData(){
		return "rechart/TestAspectChart";
	}
	
	@RequestMapping(value="TestAspect")
	private String getTestAspect(String userId, Model model) throws Exception{
				
		List<Double> testAspectCount = new ArrayList<Double>();	//定义list集合存储每一种考察方面的总记录		
		
		List<Double> testRefData = new ArrayList<Double>();	//定义list集合存储每一种考察方面的参考值
		
		List<Double> testRealData = new ArrayList<Double>();	//定义list集合存储每一种考察方面的实际值
		
		List<Double> testScoreDatas = new ArrayList<Double>();	//定义list集合存储每一种考察方面的正确率
		
		userId = "001";
		
		if(userId != null){						
			testAspectCount = testAspectService.findTestAspectCount(userId);	//获取每一种考察方面的总记录
			
			testRefData = testAspectService.findRefData(userId);	//获取每一种考察方面的参考值
			
			testRealData = testAspectService.findRealData(userId);	//获取每一种考察方面的实际值
			
			/**
			 * 计算正确率
			 * */
			//定义两个数组用来存储参考值和实际值
			double[] refScore_double = new double[testRefData.size()];
			double[] realScore_double = new double[testRealData.size()];
			
			//计算实际值和参考值
			for(int i = 0; i < testRefData.size(); ++i){
				Number numRefData = (Number)testRefData.get(i);
				refScore_double[i] = numRefData.doubleValue();
				Number numRealData = (Number)testRealData.get(i);
				realScore_double[i] = numRealData.doubleValue();
				
				// 创建一个数值格式化对象  					  
		        NumberFormat numberFormat = NumberFormat.getInstance();  					        
		        // 设置精确到小数点后2位  					  
		        numberFormat.setMaximumFractionDigits(2);  					  
		        String result = numberFormat.format((realScore_double[i]/refScore_double[i])*100);  					  
		        double testScores = Double.parseDouble(result);
		        testScoreDatas.add(testScores);
			}						
		}
		
		TestAspects testAspects = new TestAspects(testAspectCount, testScoreDatas);

		//利用JSON进行封装数据
		JSONArray jsonArray = new JSONArray();
		//获取学生学号
		JSONObject data = new JSONObject();
		data.put("testAspectCount", testAspects.getTestAspectData());
		data.put("testScoreDatas", testAspects.getTestAspectScore());
		jsonArray.add(data);
		model.addAttribute("json",jsonArray.toString());
		return PageViewConstant.JSON;
	}
	
	public TestAspectService getTestAspectService() {
		return testAspectService;
	}

	@Resource
	public void setTestAspectService(TestAspectService testAspectService) {
		this.testAspectService = testAspectService;
	}
}
