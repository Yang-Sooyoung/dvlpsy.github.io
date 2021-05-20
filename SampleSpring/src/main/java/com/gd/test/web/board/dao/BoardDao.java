package com.gd.test.web.board.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao implements IBoardDao {
	@Autowired
	public SqlSession sqlSession;

	@Override
	public int getBoardCnt(HashMap<String, String> params) throws Throwable {
		return sqlSession.selectOne("board.getBoardCnt", params);
	}

	@Override
	public List<HashMap<String, String>> getBoardList(HashMap<String, String> params) throws Throwable {
		return sqlSession.selectList("board.getBoardList", params);
	}

	@Override
	public void boardAdd(HashMap<String, String> params) throws Throwable {
		sqlSession.insert("board.boardAdd", params);
	}

	@Override
	public HashMap<String, String> getBoard(HashMap<String, String> params) throws Throwable {
		return sqlSession.selectOne("board.getBoard", params);
	}

	@Override
	public void updateBoardHit(HashMap<String, String> params) throws Throwable {
		sqlSession.update("board.updateBoardHit", params);
	}

	@Override
	public int boardUpdate(HashMap<String, String> params) throws Throwable {
		return sqlSession.update("board.boardUpdate", params);
	}

	@Override
	public int boardDelete(HashMap<String, String> params) throws Throwable {
		return sqlSession.update("board.boardDelete", params);
	}

}