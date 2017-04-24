package com.rechart.dao.testtypedao.impl;

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
import com.rechart.dao.testtypedao.TestTypeDao;
import com.rechart.entity.testtype.TestTypes;

/**
 * @author 郭明丽 
 * @version 创建时间：2016年9月23日 上午10:54:30 
 * 类说明 
*/
@Repository("testTypeDao")
public class TestTypeDaoImpl extends DaoSupport<TestTypes> implements TestTypeDao {

	@Override
	public List<Double> findTestTypeCount(String userId) {
		// TODO Auto-generated method stub
		List<Double> listTestTypeCount = (List<Double>) getHt().find("select count(u.testType) from UserTest as u where UserId = ? group by u.testType", userId);
		if(listTestTypeCount != null && listTestTypeCount.size() != 0){			
			return listTestTypeCount;
		}
		return null;
	}

	@Override
	public List<Double> findRefData(String userId) {
		// TODO Auto-generated method stub
		List<Double> listTestDifficultySum = (List<Double>)getHt().find("select sum(u.testDifficulty) from UserTest as u where UserId = ? group by u.testType", userId);
		if(listTestDifficultySum != null && listTestDifficultySum.size() != 0){			
			return listTestDifficultySum;
		}
		return null;
	}

	@Override
	public List<Double> findRealData(final String userId) {
		// TODO Auto-generated method stub
		final String sql = "select sum(round(testdifficulty/totalTimes,2))realScore from t_usertest where totalTimes > 0 and userid = ? group by TestType";
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
