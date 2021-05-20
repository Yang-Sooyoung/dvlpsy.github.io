package com.gd.test.web.test.service;

import java.util.HashMap;
import java.util.List;

public interface IAccService {

	public int getAccCnt(HashMap<String, String> params) throws Throwable;

	public List<HashMap<String, String>> getAccList(HashMap<String, String> params) throws Throwable;

	public HashMap<String, String> getAcc(HashMap<String, String> params) throws Throwable;

	public void addAcc(HashMap<String, String> params) throws Throwable;

	public int updateAcc(HashMap<String, String> params) throws Throwable;

	public int deleteAcc(HashMap<String, String> params) throws Throwable;
}
