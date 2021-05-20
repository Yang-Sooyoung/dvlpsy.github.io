package com.gd.test.web.oboard.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.test.web.oboard.dao.IOBoardDao;


@Service
public class OBoardService implements IOBoardService {
	@Autowired
	public IOBoardDao iOBoardDao;

	@Override
	public int getOBoardCnt(HashMap<String, String> params) throws Throwable {
		return iOBoardDao.getOBoardCnt(params);
	}

	@Override
	public List<HashMap<String, String>> getOBoardList(HashMap<String, String> params) throws Throwable {
		return iOBoardDao.getOBoardList(params);
	}

	@Override
	public void oBoardAdd(HashMap<String, String> params) throws Throwable {
		iOBoardDao.oBoardAdd(params);
	}

	@Override
	public int oBoardUpdate(HashMap<String, String> params) throws Throwable {
		return iOBoardDao.oBoardUpdate(params);
	}

	@Override
	public int oBoardDelete(HashMap<String, String> params) throws Throwable {
		return iOBoardDao.oBoardDelete(params);
	}
}
