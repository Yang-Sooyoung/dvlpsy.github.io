package com.gd.test.web.aacc.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class aAccDao implements IaAccDao {
	@Autowired
	public SqlSession sqlSession;

	@Override
	public int getaAccCnt(HashMap<String, String> params) throws Throwable {
		return sqlSession.selectOne("aacc.getaAccCnt", params);
	}

	@Override
	public List<HashMap<String, String>> getaAccList(HashMap<String, String> params) throws Throwable {
		return sqlSession.selectList("aacc.getaAccList", params);
	}

	@Override
	public HashMap<String, String> getaAcc(HashMap<String, String> params) throws Throwable {
		return sqlSession.selectOne("aacc.getaAcc", params);
	}

	@Override
	public void aAccAdd(HashMap<String, String> params) throws Throwable {
		sqlSession.insert("aacc.aAccAdd", params);
	}

	@Override
	public int aAccUpdate(HashMap<String, String> params) throws Throwable {
		return sqlSession.update("aacc.aAccUpdate", params);
	}

	@Override
	public int aAccDelete(HashMap<String, String> params) throws Throwable {
		return sqlSession.update("aacc.aAccDelete", params);
	}

}
