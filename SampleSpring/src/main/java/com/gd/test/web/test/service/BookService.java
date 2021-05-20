package com.gd.test.web.test.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.test.web.test.dao.IBookDao;

@Service
public class BookService implements IBookService {
	@Autowired
	public IBookDao iBookDao;

	@Override
	public List<HashMap<String, String>> getBookList(HashMap<String, String> params) throws Throwable {
		return iBookDao.getBookList(params);
	}

	@Override
	public HashMap<String, String> getBook(HashMap<String, String> params) throws Throwable {
		return iBookDao.getBook(params);
	}

	@Override
	public void addBook(HashMap<String, String> params) throws Throwable {
		iBookDao.addBook(params);
	}

	@Override
	public int updateBook(HashMap<String, String> params) throws Throwable {
		return iBookDao.updateBook(params);
	}

	@Override
	public int deleteBook(HashMap<String, String> params) throws Throwable {
		return iBookDao.deleteBook(params);
	}

	@Override
	public int getBookCnt(HashMap<String, String> params) throws Throwable {
		return iBookDao.getBookCnt(params);
	}

}
