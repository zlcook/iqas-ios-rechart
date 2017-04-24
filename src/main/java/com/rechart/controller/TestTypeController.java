package com.rechart.controller;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rechart.entity.testtype.TestTypes;
import com.rechart.service.testtypeservice.TestTypeService;
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
public class TestTypeController {

	private TestTypeService testTypeService;			

	/*public ModelAndView LearnTimeData(String userId){
		ModelAndView view = new ModelAndView("rechart/LearnTimeChart");
		view.addObject("userId", userId);
		return view;
	}*/
	@RequestMapping(value = "TestTypeChart")
	private ModelAndView TestAspectData(String userId){
		ModelAndView view = new ModelAndView("rechart/TestTypeChart");
		view.addObject("userId", userId);
		return view;
	}
	
	@RequestMapping(value="TestType")
	private String getTestType(String userId, Model model) throws Exception{
				
		List<Double> testTypeAnswerCount = new ArrayList<Double>();	//定义list集合存储每一种考察题型的回答记录		
		
		List<Double> testTypeRightCount = new ArrayList<Double>();	//定义list集合存储每一种考察题型的正确次数		
		
		List<Double> testScoreDatas = new ArrayList<Double>();	//定义list集合存储每一种考察题型的正确率
		
		if(userId != null){						
			testTypeAnswerCount = testTypeService.findAnswerCount(userId);	//获取每一种考察题型的回答次数
			
			testTypeRightCount = testTypeService.findRightCount(userId);	//获取每一种考察考察题型的正确次数			
			
			/**
			 * 计算正确率
			 * */
			//定义两个数组用来存储回答次数和正确次数
			double[] answerTimes_double = new double[testTypeAnswerCount.size()];
			double[] rightTimes_double = new double[testTypeRightCount.size()];
			
			//计算实际值和参考值
			for(int i = 0; i < testTypeRightCount.size(); ++i){
				Number numAnswerCount = (Number)testTypeAnswerCount.get(i);
				answerTimes_double[i] = numAnswerCount.doubleValue();
				Number numRightCount = (Number)testTypeRightCount.get(i);
				rightTimes_double[i] = numRightCount.doubleValue();
				
				// 创建一个数值格式化对象  					  
		        NumberFormat numberFormat = NumberFormat.getInstance();  					        
		        // 设置精确到小数点后2位  					  
		        numberFormat.setMaximumFractionDigits(2);  					  
		        String result = numberFormat.format((rightTimes_double[i]/answerTimes_double[i])*100);  					  
		        double testScores = Double.parseDouble(result);
		        testScoreDatas.add(testScores);
			}						
		}
		
		TestTypes testTypes = new TestTypes(testTypeAnswerCount, testScoreDatas);

		//利用JSON进行封装数据
		JSONArray jsonArray = new JSONArray();
		//获取学生学号
		JSONObject data = new JSONObject();
		data.put("testTypeCount", testTypes.getTestTypeData());
		data.put("testScoreDatas", testTypes.getTestTypeScore());
		jsonArray.add(data);
		model.addAttribute("json",jsonArray.toString());
		return PageViewConstant.JSON;
	}

	public TestTypeService getTestTypeService() {
		return testTypeService;
	}

	@Resource
	public void setTestTypeService(TestTypeService testTypeService) {
		this.testTypeService = testTypeService;
	}
}
