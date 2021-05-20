package com.gd.test.web.chat.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.test.web.chat.dao.IChatDao;

@Service
public class ChatService implements IChatService {
	@Autowired
	public IChatDao iChatDao;

	@Override
	public int getMaxNo() throws Throwable {
		return iChatDao.getMaxNo();
	}

	@Override
	public void insertChat(HashMap<String, String> params) throws Throwable {
		iChatDao.insertChat(params);
	}

	@Override
	public List<HashMap<String, String>> getChatList(int lastChatNo) throws Throwable {
		return iChatDao.getChatList(lastChatNo);
	}
}
