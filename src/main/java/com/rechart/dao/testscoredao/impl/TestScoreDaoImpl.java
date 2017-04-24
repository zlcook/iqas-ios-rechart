package com.rechart.dao.testscoredao.impl;

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
import com.rechart.dao.testscoredao.TestScoreDao;
import com.rechart.entity.testscore.TestScore;

/**
 * @author 郭明丽 
 * @version 创建时间：2016年9月25日 下午10:04:03 
 * 类说明 
*/
@Repository("testScoreDao")
public class TestScoreDaoImpl extends DaoSupport<TestScore> implements TestScoreDao {

	@Override
	public List<Double> findLastWeekRefScore(String userId) {
		// TODO Auto-generated method stub
		List<Double> listLastWeekRefScore = (List<Double>) getHt().find("select sum(u.testDifficulty) from UserTest as u where userId = ? and DATE_FORMAT(startTime,'%Y%u')=yearweek( now(),1 )-1", userId);
		if(listLastWeekRefScore != null && listLastWeekRefScore.size() != 0){
			return listLastWeekRefScore;
		}
		return null;
	}

	@Override
	public List<Double> findThisWeekRefScore(String userId) {
		// TODO Auto-generated method stub
		List<Double> listThisWeekRefScore = (List<Double>) getHt().find("select sum(u.testDifficulty) from UserTest as u where userId = ? and DATE_FORMAT(startTime,'%Y%u')=yearweek( now(),1 )", userId);
		if(listThisWeekRefScore != null && listThisWeekRefScore.size() != 0){
			return listThisWeekRefScore;
		}
		return null;
	}

	@Override
	public List<Double> findLastWeekRealScore(final String userId) {
		// TODO Auto-generated method stub
		final String sql = "select sum(round(testdifficulty/totalTimes,2))realScore from t_usertest where totalTimes > 0 and userid = ? and DATE_FORMAT(startTime,'%Y%u')=yearweek( now(),1 )-1";
		List<Double> listLastWeekRealScore = getHt().execute(new HibernateCallback<List<Double>>() {
			@Override
			public List<Double> doInHibernate(Session session) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				Connection con = session.connection();
				PreparedStatement ps = con.prepareStatement(sql);  
				ps.setString(1, userId);
				ResultSet rs = ps.executeQuery();
				List all = new ArrayList();
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
		final String sql = "select sum(round(testdifficulty/totalTimes,2))realScore from t_usertest where totalTimes > 0 and userid = ? and DATE_FORMAT(startTime,'%Y%u')=yearweek( now(),1 )";
		List<Double> listThisWeekRealScore = getHt().execute(new HibernateCallback<List<Double>>() {
			@Override
			public List<Double> doInHibernate(Session session) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				Connection con = session.connection();
				PreparedStatement ps = con.prepareStatement(sql);  
				ps.setString(1, userId);
				ResultSet rs = ps.executeQuery();
				List all = new ArrayList();
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
