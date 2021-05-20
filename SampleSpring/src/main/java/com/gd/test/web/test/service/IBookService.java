package com.gd.test.web.test.service;

import java.util.HashMap;
import java.util.List;

public interface IBookService {

	public List<HashMap<String, String>> getBookList(HashMap<String, String> params) throws Throwable;

	public HashMap<String, String> getBook(HashMap<String, String> params) throws Throwable;

	public void addBook(HashMap<String, String> params) throws Throwable;

	public int updateBook(HashMap<String, String> params) throws Throwable;

	public int deleteBook(HashMap<String, String> params) throws Throwable;

	public int getBookCnt(HashMap<String, String> params) throws Throwable;

}
