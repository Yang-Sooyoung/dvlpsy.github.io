package com.gd.test.web.chat.dao;

import java.util.HashMap;
import java.util.List;

public interface IChatDao {

	public int getMaxNo() throws Throwable;

	public void insertChat(HashMap<String, String> params) throws Throwable;

	public List<HashMap<String, String>> getChatList(int lastChatNo) throws Throwable;

}
