package com.gd.test.web.members.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.test.util.Utils;
import com.gd.test.web.members.dao.IMembersDao;

@Service
public class MembersService implements IMembersService {
	@Autowired
	public IMembersDao iMembersDao;

	@Override
	public int getMemberCnt(HashMap<String, String> params) throws Throwable {
		return iMembersDao.getMemberCnt(params);
	}

	@Override
	public List<HashMap<String, String>> getMemberList(HashMap<String, String> params) throws Throwable {
		return iMembersDao.getMemberList(params);
	}

	@Override
	public void memberAdd(HashMap<String, String> params) throws Throwable {
		//암호화
		params.put("mpw", Utils.encryptAES128(params.get("mpw")));
		
		iMembersDao.memberAdd(params);
	}

	@Override
	public HashMap<String, String> getMember(HashMap<String, String> params) throws Throwable {
		HashMap<String, String> member = iMembersDao.getMember(params); 
		//복호화
		member.put("MPW", Utils.decryptAES128(member.get("MPW")));
		
		return member;
	}

	@Override
	public int memberUpdate(HashMap<String, String> params) throws Throwable {
		if(params.get("mpw") != null && !params.get("mpw").equals("")) {
			//암호화
			params.put("mpw", Utils.encryptAES128(params.get("mpw")));
		}
		
		return iMembersDao.memberUpdate(params);
	}

	@Override
	public int memberDelete(HashMap<String, String> params) throws Throwable {
		return iMembersDao.memberDelete(params);
	}

	@Override
	public HashMap<String, String> getLoginInfo(HashMap<String, String> params) throws Throwable {
		//암호화
		params.put("mpw", Utils.encryptAES128(params.get("mpw")));
		
		return iMembersDao.getLoginInfo(params);
	}
}











