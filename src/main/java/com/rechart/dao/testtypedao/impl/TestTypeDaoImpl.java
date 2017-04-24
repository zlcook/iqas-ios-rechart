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
	public List<Double> findAnswerCount(String userId) {
		// TODO Auto-generated method stub
		List<Double> listTestTypeCount = (List<Double>) getHt().find("select sum(u.answertimes) from UserTest as u where u.userId = ? group by u.testtype", Integer.parseInt(userId));
		if(listTestTypeCount != null && listTestTypeCount.size() != 0){			
			return listTestTypeCount;
		}
		return null;
	}

	@Override
	public List<Double> findRightCount(String userId) {
		// TODO Auto-generated method stub
		List<Double> listTestDifficultySum = (List<Double>)getHt().find("select sum(u.righttimes) from UserTest as u where userId = ? group by u.testtype", Integer.parseInt(userId));
		if(listTestDifficultySum != null && listTestDifficultySum.size() != 0){			
			return listTestDifficultySum;
		}
		return null;
	}
}
