package com.gd.test.web.test.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.test.web.test.dao.IAccDao;

@Service
public class AccService implements IAccService {
	@Autowired
	public IAccDao iAccDao;

	@Override
	public int getAccCnt(HashMap<String, String> params) throws Throwable {
		return iAccDao.getAccCnt(params);
	}

	@Override
	public List<HashMap<String, String>> getAccList(HashMap<String, String> params) throws Throwable {
		return iAccDao.getAccList(params);
	}

	@Override
	public HashMap<String, String> getAcc(HashMap<String, String> params) throws Throwable {
		return iAccDao.getAcc(params);
	}

	@Override
	public void addAcc(HashMap<String, String> params) throws Throwable {
		iAccDao.addAcc(params);
	}

	@Override
	public int updateAcc(HashMap<String, String> params) throws Throwable {
		return iAccDao.updateAcc(params);
	}

	@Override
	public int deleteAcc(HashMap<String, String> params) throws Throwable {
		return iAccDao.deleteAcc(params);
	}
}
