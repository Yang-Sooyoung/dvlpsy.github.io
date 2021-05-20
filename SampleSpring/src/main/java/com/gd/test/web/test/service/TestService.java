package com.gd.test.web.test.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.test.web.test.dao.ITestDao;

@Service /* 언옵테이션, 인터페이스 참조  */
public class TestService implements ITestService {
	@Autowired /* 오토와이얼드 */
	public ITestDao iTestDao;

	@Override
	public List<HashMap<String, String>> getMem(HashMap<String,String> params) throws Throwable { /* 예외처리 달아주기 */
		return iTestDao.getMem(params);
	}

	@Override
	public List<HashMap<String, String>> getB(HashMap<String,String> params) throws Throwable {
		return iTestDao.getB(params); /* Dao에 메소드 호출, 데이터 가져올것이다. */
	}

	@Override
	public HashMap<String, String> getMemDetail(HashMap<String, String> params) throws Throwable {
		return iTestDao.getMemDetail(params);
	}

	@Override
	public HashMap<String, String> getBDetail(HashMap<String, String> params) throws Throwable {
		return iTestDao.getBDetail(params);
	}

	@Override
	public void addMem(HashMap<String, String> params) throws Throwable {
		iTestDao.addMem(params);
	}

	@Override
	public void addB(HashMap<String, String> params) throws Throwable {
		iTestDao.addB(params);
	}

	@Override
	public int updateMem(HashMap<String, String> params) throws Throwable {
		return iTestDao.updateMem(params);
	}

	@Override
	public int updateB(HashMap<String, String> params) throws Throwable {
		return iTestDao.updateB(params);
	}

	@Override
	public int deleteMem(HashMap<String, String> params) throws Throwable {
		return iTestDao.deleteMem(params);
	}

	@Override
	public int deleteB(HashMap<String, String> params) throws Throwable {
		return iTestDao.deleteB(params);
	}

	@Override
	public int getMemCnt(HashMap<String, String> params) throws Throwable {
		return iTestDao.getMemCnt(params);
	}

	@Override
	public int getBCnt(HashMap<String, String> params) throws Throwable {
		return iTestDao.getBCnt(params);
	}

}


