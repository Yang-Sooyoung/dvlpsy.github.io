package com.gd.test.web.board.service;

import java.util.HashMap;
import java.util.List;

public interface IBoardService {

	public int getBoardCnt(HashMap<String, String> params) throws Throwable;

	public List<HashMap<String, String>> getBoardList(HashMap<String, String> params) throws Throwable;

	public void updateBoardHit(HashMap<String, String> params) throws Throwable;

	public void boardAdd(HashMap<String, String> params) throws Throwable;
	
	public HashMap<String, String> getBoard(HashMap<String, String> params) throws Throwable;

	public int boardUpdate(HashMap<String, String> params) throws Throwable;

	public int boardDelete(HashMap<String, String> params) throws Throwable;

}
