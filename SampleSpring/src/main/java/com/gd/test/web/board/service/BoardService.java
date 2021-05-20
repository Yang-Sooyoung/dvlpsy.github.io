package com.gd.test.web.board.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.test.web.board.dao.IBoardDao;

@Service
public class BoardService implements IBoardService {
	@Autowired
	public IBoardDao iBoardDao;

	@Override
	public int getBoardCnt(HashMap<String, String> params) throws Throwable {
		return iBoardDao.getBoardCnt(params);
	}

	@Override
	public List<HashMap<String, String>> getBoardList(HashMap<String, String> params) throws Throwable {
		return iBoardDao.getBoardList(params);
	}

	@Override
	public void boardAdd(HashMap<String, String> params) throws Throwable {
		iBoardDao.boardAdd(params);
	}

	@Override
	public HashMap<String, String> getBoard(HashMap<String, String> params) throws Throwable {
		return iBoardDao.getBoard(params);
	}

	@Override
	public void updateBoardHit(HashMap<String, String> params) throws Throwable {
		iBoardDao.updateBoardHit(params);
	}

	@Override
	public int boardUpdate(HashMap<String, String> params) throws Throwable {
		return iBoardDao.boardUpdate(params);
	}

	@Override
	public int boardDelete(HashMap<String, String> params) throws Throwable {
		return iBoardDao.boardDelete(params);
	}
}
