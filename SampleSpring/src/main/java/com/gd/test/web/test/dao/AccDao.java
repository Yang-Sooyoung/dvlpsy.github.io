package com.gd.test.web.test.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccDao implements IAccDao {
	@Autowired
	public SqlSession sqlSession;

	@Override
	public int getAccCnt(HashMap<String, String> params) throws Throwable {
		return sqlSession.selectOne("acc.getAccCnt", params);
	}

	@Override
	public List<HashMap<String, String>> getAccList(HashMap<String, String> params) throws Throwable {
		return sqlSession.selectList("acc.getAccList", params);
	}

	@Override
	public HashMap<String, String> getAcc(HashMap<String, String> params) throws Throwable {
		return sqlSession.selectOne("acc.getAcc", params);
	}

	@Override
	public void addAcc(HashMap<String, String> params) throws Throwable {
		sqlSession.insert("acc.addAcc", params);
	}

	@Override
	public int updateAcc(HashMap<String, String> params) throws Throwable {
		return sqlSession.update("acc.updateAcc", params);
	}

	@Override
	public int deleteAcc(HashMap<String, String> params) throws Throwable {
		return sqlSession.delete("acc.deleteAcc", params);
	}
}
