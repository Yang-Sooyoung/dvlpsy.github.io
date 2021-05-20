package com.gd.test.web.aboard.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ABoardDao implements IABoardDao {
	@Autowired
	public SqlSession sqlSession;

	@Override
	public int getABoardCnt(HashMap<String, String> params) throws Throwable {
		return sqlSession.selectOne("aboard.getABoardCnt", params);
	}

	@Override
	public List<HashMap<String, String>> getABoardList(HashMap<String, String> params) throws Throwable {
		return sqlSession.selectList("aboard.getABoardList", params);
	}

	@Override
	public void ABoardAdd(HashMap<String, String> params) throws Throwable {
		sqlSession.insert("aboard.ABoardAdd", params);
	}

	@Override
	public HashMap<String, String> getABoard(HashMap<String, String> params) throws Throwable {
		return sqlSession.selectOne("aboard.getABoard", params);
	}

	@Override
	public void updateABoardHit(HashMap<String, String> params) throws Throwable {
		sqlSession.update("aboard.updateABoardHit", params);
	}

	@Override
	public int ABoardUpdate(HashMap<String, String> params) throws Throwable {
		return sqlSession.update("aboard.ABoardUpdate", params);
	}

	@Override
	public int ABoardDelete(HashMap<String, String> params) throws Throwable {
		return sqlSession.update("aboard.ABoardDelete", params);
	}
}
