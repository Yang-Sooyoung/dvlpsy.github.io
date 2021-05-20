package com.gd.test.web.blog.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BlogDao implements IBlogDao {
	@Autowired
	public SqlSession sqlSession;

	@Override
	public int getBlogCnt(HashMap<String, String> moon) throws Throwable {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("Blog.getBlogCnt", moon);
	}

	@Override
	public List<HashMap<String, String>> getblogMembersList(HashMap<String, String> moon) throws Throwable {
		// TODO Auto-generated method stub
		return sqlSession.selectList("Blog.getblogMembersList", moon);
	}

	@Override
	public int getblogMDetailCnt(HashMap<String, String> moon) throws Throwable {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("Blog.getblogMDetailCnt", moon);
	}

	@Override
	public List<HashMap<String, String>> getblogMDetail(HashMap<String, String> moon) throws Throwable {
		// TODO Auto-generated method stub
		return sqlSession.selectList("Blog.getblogMDetail", moon);
	}

	@Override
	public HashMap<String, String> getBlogMDetailCon(HashMap<String, String> params) throws Throwable {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("Blog.getBlogMDetailCon", params);
	}
	
	@Override
	public int addBlogHit(HashMap<String, String> params) throws Throwable {
		// TODO Auto-generated method stub
		return sqlSession.update("Blog.addBlogHit", params);
	}
	
	@Override
	public int blogMUpdateAjax(HashMap<String, String> params) throws Throwable {
		// TODO Auto-generated method stub
		return sqlSession.update("Blog.blogMUpdateAjax", params);
	}

	@Override
	public void blogAdd(HashMap<String, String> params) throws Throwable {
		sqlSession.insert("Blog.blogAdd", params);
		
	}

	@Override
	public void blogDelete(HashMap<String, String> params) throws Throwable {
		sqlSession.update("Blog.blogDelete", params);
	}
	
}
