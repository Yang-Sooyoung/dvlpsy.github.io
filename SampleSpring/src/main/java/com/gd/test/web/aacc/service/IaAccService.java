package com.gd.test.web.aacc.service;

import java.util.HashMap;
import java.util.List;

public interface IaAccService {

	public int getaAccCnt(HashMap<String, String> params) throws Throwable;

	public List<HashMap<String, String>> getaAccList(HashMap<String, String> params) throws Throwable;

	public HashMap<String, String> getaAcc(HashMap<String, String> params) throws Throwable;

	public void aAccAdd(HashMap<String, String> params) throws Throwable;

	public int aAccUpdate(HashMap<String, String> params) throws Throwable;

	public int aAccDelete(HashMap<String, String> params) throws Throwable;


}
