package com.gd.test.web.oboard.dao;

import java.util.HashMap;
import java.util.List;

public interface IOBoardDao {
	
	public int getOBoardCnt(HashMap<String, String> params) throws Throwable;

	public List<HashMap<String, String>> getOBoardList(HashMap<String, String> params) throws Throwable;

	public void oBoardAdd(HashMap<String, String> params) throws Throwable;

	public int oBoardUpdate(HashMap<String, String> params) throws Throwable;

	public int oBoardDelete(HashMap<String, String> params) throws Throwable;

}
