package com.gd.test.web.test.service;

import java.util.HashMap;
import java.util.List;

public interface ITestService {
	
	public List<HashMap<String, String>> getMem(HashMap<String,String> params) throws Throwable; /* 예외처리 달아주기 */

	public List<HashMap<String, String>> getB(HashMap<String,String> params) throws Throwable;

	public HashMap<String, String> getMemDetail(HashMap<String, String> params) throws Throwable;

	public HashMap<String, String> getBDetail(HashMap<String, String> params) throws Throwable;

	public void addMem(HashMap<String, String> params) throws Throwable;

	public void addB(HashMap<String, String> params) throws Throwable;

	public int updateMem(HashMap<String, String> params) throws Throwable;

	public int updateB(HashMap<String, String> params) throws Throwable;

	public int deleteMem(HashMap<String, String> params) throws Throwable;

	public int deleteB(HashMap<String, String> params) throws Throwable;

	public int getMemCnt(HashMap<String, String> params) throws Throwable;

	public int getBCnt(HashMap<String, String> params) throws Throwable;

}


