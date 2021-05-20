package com.gd.test.web.members.service;

import java.util.HashMap;
import java.util.List;

public interface IMembersService {

	public int getMemberCnt(HashMap<String, String> params) throws Throwable;

	public List<HashMap<String, String>> getMemberList(HashMap<String, String> params) throws Throwable;

	public void memberAdd(HashMap<String, String> params) throws Throwable;

	public HashMap<String, String> getMember(HashMap<String, String> params) throws Throwable;

	public int memberUpdate(HashMap<String, String> params) throws Throwable;

	public int memberDelete(HashMap<String, String> params) throws Throwable;

	public HashMap<String, String> getLoginInfo(HashMap<String, String> params) throws Throwable;

}
