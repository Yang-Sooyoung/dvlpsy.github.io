package com.gd.test.web.abook.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.test.web.abook.dao.IaBookDao;

@Service
public class aBookService implements IaBookService{
	@Autowired
	public IaBookDao iaBookDao;

	@Override
	public int getaBookCnt(HashMap<String, String> params) throws Throwable {
		return iaBookDao.getaBookCnt(params);
	}

	@Override
	public List<HashMap<String, String>> getaBookList(HashMap<String, String> params) throws Throwable {
		return iaBookDao.getaBookList(params);
	}

	@Override
	public HashMap<String, String> getaBook(HashMap<String, String> params) throws Throwable {
		return iaBookDao.getaBook(params);
	}

	@Override
	public void aBookAdd(HashMap<String, String> params) throws Throwable {
		iaBookDao.aBookAdd(params);
	}

	@Override
	public int aBookUpdate(HashMap<String, String> params) throws Throwable {
		return iaBookDao.aBookUpdate(params);
		
	}

	@Override
	public int aBookDelete(HashMap<String, String> params) throws Throwable {
		return iaBookDao.aBookDelete(params);
	}

}
