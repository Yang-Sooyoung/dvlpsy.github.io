package com.gd.test.web.ajaxBoard.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AjaxBoardDao implements IAjaxBoardDao {
	@Autowired
	public SqlSessionTemplate sqlSession;

	@Override
	public void insertBoard(HashMap<String, String> params) throws Throwable {
		sqlSession.insert("ajaxBoard.insertBoard", params);
	}

	@Override
	public int getBoardCount(HashMap<String, String> params) throws Throwable {
		return (int) sqlSession.selectOne("ajaxBoard.getBoardCount", params);
	}

	@Override
	public List<HashMap<String, String>> getBoardList(HashMap<String, String> params) throws Throwable {
		return sqlSession.selectList("ajaxBoard.getBoardList", params);
	}

	@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, String> getBoardDetail(String boardNo) throws Throwable {
		return (HashMap<String, String>) sqlSession.selectOne("ajaxBoard.getBoardDetail", boardNo);
	}

	@Override
	public void updateHitCnt(String boardNo) throws Throwable {
		sqlSession.update("ajaxBoard.updateHitCnt", boardNo);
	}

	@Override
	public String checkPass(HashMap<String, String> abb) throws Throwable {
		return (String) sqlSession.selectOne("ajaxBoard.checkPass", abb);
	}

	@Override
	public void updateBoard(HashMap<String, String> abb) throws Throwable {
		sqlSession.update("ajaxBoard.updateBoard", abb);
	}

	@Override
	public void deleteBoard(HashMap<String, String> abb) throws Throwable {
		sqlSession.delete("ajaxBoard.deleteBoard", abb);
	}
}
