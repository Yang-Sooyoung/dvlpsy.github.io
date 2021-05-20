package com.gd.test.web.test.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao implements IBookDao {
	@Autowired
	public SqlSession sqlSession;
	
	@Override
	public List<HashMap<String, String>> getBookList(HashMap<String, String> params) throws Throwable {
		return sqlSession.selectList("book.getBookList", params);
	}

	@Override
	public HashMap<String, String> getBook(HashMap<String, String> params) throws Throwable {
		return sqlSession.selectOne("book.getBook", params);
	}

	@Override
	public void addBook(HashMap<String, String> params) throws Throwable {
		sqlSession.insert("book.addBook", params);
	}

	@Override
	public int updateBook(HashMap<String, String> params) throws Throwable {
		return sqlSession.update("book.updateBook", params);
	}

	@Override
	public int deleteBook(HashMap<String, String> params) throws Throwable {
		return sqlSession.delete("book.deleteBook", params);
	}

	@Override
	public int getBookCnt(HashMap<String, String> params) throws Throwable {
		return sqlSession.selectOne("book.getBookCnt", params);
	}
}
