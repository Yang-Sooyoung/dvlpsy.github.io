package com.gd.test.web.ajaxBoard.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.test.web.ajaxBoard.dao.IAjaxBoardDao;

@Service
public class AjaxBoardService implements IAjaxBoardService {
	@Autowired
	public IAjaxBoardDao iAjaxBoardDao;

	@Override
	public void insertBoard(HashMap<String, String> params) throws Throwable {
		iAjaxBoardDao.insertBoard(params);
	}

	@Override
	public int getBoardCount(HashMap<String, String> params) throws Throwable {
		return iAjaxBoardDao.getBoardCount(params);
	}

	@Override
	public List<HashMap<String, String>> getBoardList(HashMap<String, String> params) throws Throwable {
		return iAjaxBoardDao.getBoardList(params);
	}

	@Override
	public HashMap<String, String> getBoardDetail(String boardNo) throws Throwable {
		return iAjaxBoardDao.getBoardDetail(boardNo);
	}

	@Override
	public void updateHitCnt(String boardNo) throws Throwable {
		iAjaxBoardDao.updateHitCnt(boardNo);
	}

	@Override
	public String checkPass(HashMap<String, String> params) throws Throwable {
		return iAjaxBoardDao.checkPass(params);
	}

	@Override
	public void updateBoard(HashMap<String, String> params) throws Throwable {
		iAjaxBoardDao.updateBoard(params);
	}

	@Override
	public void deleteBoard(HashMap<String, String> params) throws Throwable {
		iAjaxBoardDao.deleteBoard(params);
	}
}
