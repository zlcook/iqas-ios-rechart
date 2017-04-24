package com.rechart.dao.testaspectdao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.rechart.base.DaoSupport;
import com.rechart.dao.testaspectdao.TestAspectDao;
import com.rechart.entity.testaspect.TestAspects;

/**
 * @author 郭明丽 
 * @version 创建时间：2016年9月20日 下午3:22:44 
 * 类说明 
*/
@Repository("testAspectDao")
public class TestAspectDaoImpl extends DaoSupport<TestAspects> implements TestAspectDao {

	@Override
	public List<Double> findTestAspectCount(String userId) {			
		// TODO Auto-generated method stub
		List<Double> listTestAspectCount = (List<Double>) getHt().find("select count(u.testAspect) from UserTest as u where UserId = ? group by u.testAspect", userId);
		if(listTestAspectCount != null && listTestAspectCount.size() != 0){			
			return listTestAspectCount;
		}
		return null;
	}

	
	@Override
	public List<Double> findRefData(String userId) {
		// TODO Auto-generated method stub
		List<Double> listTestDifficultySum = (List<Double>)getHt().find("select sum(u.testDifficulty) from UserTest as u where UserId = ? group by u.testAspect", userId);
		if(listTestDifficultySum != null && listTestDifficultySum.size() != 0){			
			return listTestDifficultySum;
		}
		return null;
	}

	@Override
	public List<Double> findRealData(final String userId) {
		// TODO Auto-generated method stub		
		final String sql = "select sum(round(testdifficulty/totalTimes,2))realScore from t_usertest where totalTimes > 0 and userid = ? group by TestAspect";
		List listRealData = getHt().execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
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
		return listRealData;
	}	
	
	
}
