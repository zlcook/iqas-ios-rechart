package com.rechart.dao.logintimedao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.rechart.base.DaoSupport;
import com.rechart.dao.logintimedao.LoginTimeDao;
import com.rechart.entity.logintime.LoginTime;
import com.rechart.utils.DateUtils;

/**
 * @author 郭明丽 
 * @version 创建时间：2017年4月27日 上午11:30:03 
 * 类说明 
*/
@Repository("loginTimeDao")
public class LoginTimeDaoImpl extends DaoSupport<LoginTime> implements LoginTimeDao {

	@Override
	public LinkedHashMap<String, Integer> findLoginTime(final String userId) {
		// TODO Auto-generated method stub
		final String sql = "SELECT DATE_FORMAT(login_time,'%Y-%m-%d') date, sum(round( TIMESTAMPDIFF(minute, login_time, logout_time)))minuteCount FROM user_login WHERE user_Id=? and date_sub(curdate(), INTERVAL 7 DAY) < date(login_time)GROUP BY DATE_FORMAT(login_time,'%Y-%m-%d') ORDER BY date ASC";
		@SuppressWarnings("deprecation")
		LinkedHashMap<String, Integer> listLoginTime = getHt().execute(new HibernateCallback<LinkedHashMap<String, Integer>>(){

			@Override
			public LinkedHashMap<String, Integer> doInHibernate(Session session) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				Connection con = session.connection();
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, userId);
				ResultSet rs = ps.executeQuery();
				ResultSetMetaData md = rs.getMetaData();//得到结果集列的属性  
		        int i;  
				
				LinkedHashMap<String, Integer> linkMap = new LinkedHashMap<>();
				
				List<String> sevenDates = DateUtils.sevenDates();
				Map<String, Integer> map = new HashMap<String, Integer>();	
				while(rs.next()){
						int minuteCount = rs.getInt("minuteCount");
						String date = rs.getString("date");
						map.put(date, new Integer(minuteCount));//key = 2017-4-28  value = 3
				}
				for(  i =0;i < 7;i++){
					String key = sevenDates.get(i);
					if( map.containsKey(key) ){
						linkMap.put(key, map.get(key));
					}else{
						linkMap.put(key, new Integer(0));
					}
				}
				
				rs.close();
				ps.close();
				session.flush();
				session.close();
				
				return linkMap;
			}
			
		});
		return listLoginTime;
		
	}	
}
