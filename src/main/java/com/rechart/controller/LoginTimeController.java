package com.rechart.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rechart.service.logintimeservice.LoginTimeService;
import com.rechart.utils.PageViewConstant;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author 郭明丽 
 * @version 创建时间：2017年4月27日 下午10:14:18 
 * 类说明 
*/
@Controller
@RequestMapping(value="/rechart/")
public class LoginTimeController {

	private LoginTimeService loginTimeService;
	
	@RequestMapping(value="test")
	private String getLoginTime(String userId, Model model) throws Exception{
		
		LinkedHashMap<String, Integer> loginTime = loginTimeService.findLoginTime(userId);
		
		JSONObject json = new JSONObject();
		JSONArray dateArray = new JSONArray();
		JSONArray minuteArray = new JSONArray();
		for( Entry<String, Integer> entry :loginTime.entrySet()){
			dateArray.add(entry.getKey());
			minuteArray.add(entry.getValue());
		}
		json.put("date", dateArray);
		json.put("minuteCount",minuteArray);
		/**
		 * {
		 *  "date":["2017-4-28","2017-4-28","2017-4-28"，"2017-4-28"],
		 *  "minuteCount":[1,2,3,4,5,6,7]
		 * }
		 */
		model.addAttribute("json", json.toString());
		return PageViewConstant.JSON;
		
	}
	public LoginTimeService getLoginTimeService() {
		return loginTimeService;
	}
	@Resource
	public void setLoginTimeService(LoginTimeService loginTimeService) {
		this.loginTimeService = loginTimeService;
	}
	
}
