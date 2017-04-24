package com.rechart.dao.loveaspectdao.impl;

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
import com.rechart.dao.loveaspectdao.LoveAspectDao;
import com.rechart.entity.loveaspect.LoveAspect;

/**
 * @author 郭明丽 
 * @version 创建时间：2016年9月23日 下午2:42:41 
 * 类说明 
*/
@Repository("loveAspectDao")
public class LoveAspectDaoImpl extends DaoSupport<LoveAspect> implements LoveAspectDao {

	@Override
	public List<Double> findLastWeekRefScore(final String userId) {
		// TODO Auto-generated method stub
		List<Double> listLastWeekRefScore = (List<Double>) getHt().find("select sum(u.testDifficulty) from UserTest as u where userId = ? and DATE_FORMAT(startTime,'%Y%u')=yearweek( now(),1 )-1 group by u.testAspect", userId);
		if(listLastWeekRefScore != null && listLastWeekRefScore.size() != 0){
			return listLastWeekRefScore;
		}
		return null;
	}	

	@Override
	public List<Double> findThisWeekRefScore(final String userId) {		
		// TODO Auto-generated method stub
		List<Double> listThisWeekRefScore = (List<Double>) getHt().find("select sum(u.testDifficulty) from UserTest as u where userId = ? and DATE_FORMAT(startTime,'%Y%u')=yearweek( now(),1 ) group by u.testAspect", userId);
		if(listThisWeekRefScore != null && listThisWeekRefScore.size() != 0){
			return listThisWeekRefScore;
		}
		return null;
	}

	@Override
	public List<Double> findLastWeekRealScore(final String userId) {
		// TODO Auto-generated method stub
		final String sql = "select sum(round(testdifficulty/totalTimes,2))realScore from t_usertest where totalTimes > 0 and userid = ? and DATE_FORMAT(startTime,'%Y%u')=yearweek( now(),1 )-1 group by testaspect";
		List<Double> listLastWeekRealScore = getHt().execute(new HibernateCallback<List<Double>>() {
			@Override
			public List<Double> doInHibernate(Session session) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				Connection con = session.connection();
				PreparedStatement ps = con.prepareStatement(sql);  
				ps.setString(1, userId);
				ResultSet rs = ps.executeQuery();
				List<Double> all = new ArrayList();
				while(rs.next()){
					double result = rs.getDouble("realScore");
					all.add(result); 
				}
				rs.close();
				ps.close();
				session.flush();
				session.close();
				
				return all;
			}
		});		
		return listLastWeekRealScore;
	}

	@Override
	public List<Double> findThisWeekRealScore(final String userId) {
		// TODO Auto-generated method stub
		final String sql = "select sum(round(testdifficulty/totalTimes,2))realScore from t_usertest where totalTimes > 0 and userid = ? and DATE_FORMAT(startTime,'%Y%u')=yearweek( now(),1 ) group by testaspect";
		List<Double> listThisWeekRealScore = getHt().execute(new HibernateCallback<List<Double>>() {
			@Override
			public List<Double> doInHibernate(Session session) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				Connection con = session.connection();
				PreparedStatement ps = con.prepareStatement(sql);  
				ps.setString(1, userId);
				ResultSet rs = ps.executeQuery();
				List<Double> all = new ArrayList();
				while(rs.next()){
					double result = rs.getDouble("realScore");
					all.add(result); 
				}
				rs.close();
				ps.close();
				session.flush();
				session.close();
				
				return all;
			}
		});		
		return listThisWeekRealScore;
	}
}
