package com.rechart.dao.learntimedao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.rechart.base.DaoSupport;
import com.rechart.dao.learntimedao.LearnTimeDao;
import com.rechart.entity.learntime.LearnTime;

/**
 * @author 郭明丽 
 * @version 创建时间：2016年9月19日 上午9:05:00 
 * 类说明 
*/

@Repository("learnTimeDao")
public class LearnTimeDaoImpl extends DaoSupport<LearnTime> implements LearnTimeDao {

	/**
	 * 查询上周数据
	 * */
	@Override
	public double findLastWeekData(final String userId) {
		// TODO Auto-generated method stub		 
		final String sql = "select sum(round( TIMESTAMPDIFF(minute, login_time, logout_time)))minuteCount from user_login where user_id = ? and DATE_FORMAT(login_time,'%Y%u')=yearweek( now(),1 )-1";
		List<Double> listLastWeekData = getHt().execute(new HibernateCallback<List<Double>>(){

			@Override
			public List<Double> doInHibernate(Session session) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				Connection con = session.connection();
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, userId);
				ResultSet rs = ps.executeQuery();
				List<Double> all = new ArrayList();
				while(rs.next()){
					double result = rs.getDouble("minuteCount");
					all.add(result);
				}
				rs.close();
				ps.close();
				session.flush();
				session.close();
				
				return all;
			}
			
		});		
		return listLastWeekData.get(0);
	}

	/**
	 * 查询本周数据
	 * */
	@Override
	public double findThisWeekData(final String userId) {
		// TODO Auto-generated method stub
		final String sql = "select sum(round( TIMESTAMPDIFF(minute, login_time, logout_time)))minuteCount from user_login where user_id = ? and DATE_FORMAT(login_time,'%Y%u')=yearweek( now(),1 )";
		List<Double> listThisWeekData = getHt().execute(new HibernateCallback<List<Double>>(){

			@Override
			public List<Double> doInHibernate(Session session) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				Connection con = session.connection();
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, userId);
				ResultSet rs = ps.executeQuery();
				List<Double> all = new ArrayList();
				while(rs.next()){
					double result = rs.getDouble("minuteCount");
					all.add(result);
				}
				rs.close();
				ps.close();
				session.flush();
				session.close();
				
				return all;
			}
			
		});		
		return listThisWeekData.get(0);
	}	
	
}
