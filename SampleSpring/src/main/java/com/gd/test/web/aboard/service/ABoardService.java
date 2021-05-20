package com.gd.test.web.aboard.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.test.web.aboard.dao.IABoardDao;

@Service
public class ABoardService implements IABoardService {
	@Autowired
	public IABoardDao iABoardDao;
	
	
	@Override
	public int getABoardCnt(HashMap<String, String> params) throws Throwable {
		return iABoardDao.getABoardCnt(params);
	}

	@Override
	public List<HashMap<String, String>> getABoardList(HashMap<String, String> params) throws Throwable {
		return iABoardDao.getABoardList(params);
	}

	@Override
	public void updateABoardHit(HashMap<String, String> params) throws Throwable {
		iABoardDao.updateABoardHit(params);
	}

	@Override
	public HashMap<String, String> getABoard(HashMap<String, String> params) throws Throwable {
		return iABoardDao.getABoard(params);
	}

	@Override
	public void ABoardAdd(HashMap<String, String> params) throws Throwable {
		iABoardDao.ABoardAdd(params);
	}

	@Override
	public int ABoardUpdate(HashMap<String, String> params) throws Throwable {
		return iABoardDao.ABoardUpdate(params);
	}

	@Override
	public int ABoardDelete(HashMap<String, String> params) throws Throwable {
		return iABoardDao.ABoardDelete(params);
	}

}
