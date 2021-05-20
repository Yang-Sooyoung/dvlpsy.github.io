package com.gd.test.web.blog.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.test.web.blog.dao.IBlogDao;

@Service
public class BlogService implements IBlogService {
	@Autowired
	public IBlogDao iBlogDao;

	@Override
	public int getBlogCnt(HashMap<String, String> moon) throws Throwable {
		// TODO Auto-generated method stub
		return iBlogDao.getBlogCnt(moon);
	}

	@Override
	public List<HashMap<String, String>> getblogMembersList(HashMap<String, String> moon) throws Throwable {
		// TODO Auto-generated method stub
		return iBlogDao.getblogMembersList(moon);
	}

	@Override
	public int getblogMDetailCnt(HashMap<String, String> moon) throws Throwable {
		// TODO Auto-generated method stub
		return iBlogDao.getblogMDetailCnt(moon);
	}

	@Override
	public List<HashMap<String, String>> getblogMDetail(HashMap<String, String> moon) throws Throwable {
		// TODO Auto-generated method stub
		return iBlogDao.getblogMDetail(moon);
	}

	@Override
	public HashMap<String, String> getBlogMDetailCon(HashMap<String, String> params) throws Throwable {
		// TODO Auto-generated method stub
		return iBlogDao.getBlogMDetailCon(params);
	}

	@Override
	public int addBlogHit(HashMap<String, String> params) throws Throwable {
		// TODO Auto-generated method stub
		return iBlogDao.addBlogHit(params);
	}
	
	@Override
	public int blogMUpdateAjax(HashMap<String, String> params) throws Throwable {
		// TODO Auto-generated method stub
		return iBlogDao.blogMUpdateAjax(params);
	}

	@Override
	public void blogAdd(HashMap<String, String> params) throws Throwable {
		iBlogDao.blogAdd(params);
		
	}

	@Override
	public void blogDelete(HashMap<String, String> params) throws Throwable {
		iBlogDao.blogDelete(params);
		
	}
}
