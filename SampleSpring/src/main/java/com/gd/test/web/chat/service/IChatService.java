package com.gd.test.web.chat.service;

import java.util.HashMap;
import java.util.List;

public interface IChatService {

	public int getMaxNo() throws Throwable;

	public void insertChat(HashMap<String, String> parmas) throws Throwable;

	public List<HashMap<String, String>> getChatList(int lastChatNo) throws Throwable;

}
