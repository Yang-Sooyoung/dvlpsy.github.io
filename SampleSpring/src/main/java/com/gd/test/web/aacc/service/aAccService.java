package com.gd.test.web.aacc.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.test.web.aacc.dao.IaAccDao;

@Service
public class aAccService implements IaAccService{
	@Autowired
	public IaAccDao iaAccDao;
	
	@Override
	public int getaAccCnt(HashMap<String, String> params) throws Throwable {
		return iaAccDao.getaAccCnt(params);
	}

	@Override
	public List<HashMap<String, String>> getaAccList(HashMap<String, String> params) throws Throwable {
		return iaAccDao.getaAccList(params);
	}

	@Override
	public HashMap<String, String> getaAcc(HashMap<String, String> params) throws Throwable {
		return iaAccDao.getaAcc(params);
	}

	@Override
	public void aAccAdd(HashMap<String, String> params) throws Throwable {
		iaAccDao.aAccAdd(params);
	}

	@Override
	public int aAccUpdate(HashMap<String, String> params) throws Throwable {
		return iaAccDao.aAccUpdate(params);
	}

	@Override
	public int aAccDelete(HashMap<String, String> params) throws Throwable {
		return iaAccDao.aAccDelete(params);
	}

}
