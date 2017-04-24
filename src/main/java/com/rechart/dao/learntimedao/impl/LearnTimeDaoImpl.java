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
		final String sql = "select sum(round( TIMESTAMPDIFF(minute, logintime, exittime)))minuteCount from t_userlogininfo where userid = ? and DATE_FORMAT(logintime,'%Y%u')=yearweek( now(),1 )-1";
		List listLastWeekData = getHt().execute(new HibernateCallback(){

			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				Connection con = session.connection();
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, userId);
				ResultSet rs = ps.executeQuery();
				List all = new ArrayList();
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
		return (double) listLastWeekData.get(0);
	}

	/**
	 * 查询本周数据
	 * */
	@Override
	public double findThisWeekData(final String userId) {
		// TODO Auto-generated method stub
		final String sql = "select sum(round( TIMESTAMPDIFF(minute, logintime, loginouttime)))minuteCount from t_userlogininformation where userid = ? and DATE_FORMAT(logintime,'%Y%u')=yearweek( now(),1 )";
		List listThisWeekData = getHt().execute(new HibernateCallback(){

			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				Connection con = session.connection();
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, userId);
				ResultSet rs = ps.executeQuery();
				List all = new ArrayList();
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
		return (double) listThisWeekData.get(0);
	}	
	
}
