package com.gd.test.web.abook.dao;

import java.util.HashMap;
import java.util.List;

public interface IaBookDao {

	public int getaBookCnt(HashMap<String, String> params) throws Throwable;

	public List<HashMap<String, String>> getaBookList(HashMap<String, String> params) throws Throwable;

	public HashMap<String, String> getaBook(HashMap<String, String> params) throws Throwable;

	public void aBookAdd(HashMap<String, String> params) throws Throwable;

	public int aBookUpdate(HashMap<String, String> params) throws Throwable;

	public int aBookDelete(HashMap<String, String> params) throws Throwable;


}
