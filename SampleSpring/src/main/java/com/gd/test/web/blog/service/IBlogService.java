package com.gd.test.web.blog.service;

import java.util.HashMap;
import java.util.List;

public interface IBlogService {

	public int getBlogCnt(HashMap<String, String> moon) throws Throwable;

	public List<HashMap<String, String>> getblogMembersList(HashMap<String, String> moon) throws Throwable;

	public int getblogMDetailCnt(HashMap<String, String> moon) throws Throwable;

	public List<HashMap<String, String>> getblogMDetail(HashMap<String, String> moon) throws Throwable;

	public HashMap<String, String> getBlogMDetailCon(HashMap<String, String> params) throws Throwable;

	public int addBlogHit(HashMap<String, String> params) throws Throwable;
	
	public int blogMUpdateAjax(HashMap<String, String> params) throws Throwable;

	public void blogAdd(HashMap<String, String> params) throws Throwable;

	public void blogDelete(HashMap<String, String> params) throws Throwable;
}
