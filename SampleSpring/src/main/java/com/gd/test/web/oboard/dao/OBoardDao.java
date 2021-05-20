package com.gd.test.web.oboard.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OBoardDao implements IOBoardDao {
	@Autowired
	public SqlSession sqlSession;

	@Override
	public int getOBoardCnt(HashMap<String, String> params) throws Throwable {
		return sqlSession.selectOne("oboard.getOBoardCnt", params);
	}

	@Override
	public List<HashMap<String, String>> getOBoardList(HashMap<String, String> params) throws Throwable {
		return sqlSession.selectList("oboard.getOboardList", params);
	}

	@Override
	public void oBoardAdd(HashMap<String, String> params) throws Throwable {
		sqlSession.insert("oboard.oBoardAdd", params);
	}

	@Override
	public int oBoardUpdate(HashMap<String, String> params) throws Throwable {
		return sqlSession.update("oboard.oBoardUpdate", params);
	}

	@Override
	public int oBoardDelete(HashMap<String, String> params) throws Throwable {
		return sqlSession.update("oboard.oBoardDelete", params);
	}
}
