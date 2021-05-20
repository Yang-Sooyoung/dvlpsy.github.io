package com.gd.test.web.aboard.service;

import java.util.HashMap;
import java.util.List;

public interface IABoardService {
	public int getABoardCnt(HashMap<String, String> params) throws Throwable;

	public List<HashMap<String, String>> getABoardList(HashMap<String, String> params) throws Throwable;
	
	public void updateABoardHit(HashMap<String, String> params) throws Throwable;

	public HashMap<String, String> getABoard(HashMap<String, String> params) throws Throwable;

	public void ABoardAdd(HashMap<String, String> params) throws Throwable;

	public int ABoardUpdate(HashMap<String, String> params) throws Throwable;

	public int ABoardDelete(HashMap<String, String> params) throws Throwable;

}
