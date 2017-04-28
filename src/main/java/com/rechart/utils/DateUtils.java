package com.rechart.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 郭明丽 
 * @version 创建时间：2017年4月28日 上午9:35:44 
 * 类说明 
*/
public class DateUtils {
	
	/**
	 * 获取indexDate指定日期之前连续七天数据，包含indexDate
	 * @param indexDate  指定日期
	 * @param sdf  返回日期的格式
	 * @return 存放日期的集合：类似[2017-04-22, 2017-04-23, 2017-04-24, 2017-04-25, 2017-04-26, 2017-04-27, 2017-04-28]
	 */
	public static List<String> sevenDates(Date indexDate,SimpleDateFormat sdf){
		if( indexDate == null )
			indexDate =new Date();
		if( sdf == null )
			sdf = new SimpleDateFormat("yyyy-MM-dd");	
		
		List<String> sevenDate=new  ArrayList<String>();	
		//设置前一天的时间
	    Date predate = new Date();
	    for(int i = 6;i >= 0; --i){				
			long dif = indexDate.getTime() - i * 86400 * 1000;					
			//设置前一天的时间
			predate.setTime(dif);
			//将日期转化为String格式
			sevenDate.add(sdf.format(predate));	//2017-4-27				
	    }
	    return sevenDate;
	}
	/**
	 * 返回从当前天开始前7天数据
	 * @return
	 */
	public static List<String> sevenDates(){
		return sevenDates(null,null);
	}

}
