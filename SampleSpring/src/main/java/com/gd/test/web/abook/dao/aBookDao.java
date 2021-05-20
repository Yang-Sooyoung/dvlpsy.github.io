package com.gd.test.web.abook.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class aBookDao implements IaBookDao {
	@Autowired
	public SqlSession sqlSession;

	@Override
	public int getaBookCnt(HashMap<String, String> params) {
		return sqlSession.selectOne("abook.getaBookCnt", params);
	}

	@Override
	public List<HashMap<String, String>> getaBookList(HashMap<String, String> params) {
		return sqlSession.selectList("abook.getaBookList", params);
	}

	@Override
	public HashMap<String, String> getaBook(HashMap<String, String> params) throws Throwable {
		return sqlSession.selectOne("abook.getaBook", params);
	}

	@Override
	public void aBookAdd(HashMap<String, String> params) throws Throwable {
		sqlSession.insert("abook.aBookAdd", params);
	}

	@Override
	public int aBookUpdate(HashMap<String, String> params) throws Throwable {
		return sqlSession.update("abook.aBookUpdate", params);
	}

	@Override
	public int aBookDelete(HashMap<String, String> params) throws Throwable {
		return sqlSession.delete("abook.aBookDelete", params);
	}

	
}
