package com.gd.test.web.members.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MembersDao implements IMembersDao {
	@Autowired
	public SqlSession sqlSession;

	@Override
	public int getMemberCnt(HashMap<String, String> params) throws Throwable {
		return sqlSession.selectOne("members.getMemberCnt", params);
	}

	@Override
	public List<HashMap<String, String>> getMemberList(HashMap<String, String> params) throws Throwable {
		return sqlSession.selectList("members.getMemberList", params);
	}

	@Override
	public void memberAdd(HashMap<String, String> params) throws Throwable {
		sqlSession.insert("members.memberAdd", params);
	}

	@Override
	public HashMap<String, String> getMember(HashMap<String, String> params) throws Throwable {
		return sqlSession.selectOne("members.getMember", params);
	}

	@Override
	public int memberUpdate(HashMap<String, String> params) throws Throwable {
		return sqlSession.update("members.memberUpdate", params);
	}

	@Override
	public int memberDelete(HashMap<String, String> params) throws Throwable {
		return sqlSession.delete("members.memberDelete", params);
	}

	@Override
	public HashMap<String, String> getLoginInfo(HashMap<String, String> params) throws Throwable {
		return sqlSession.selectOne("members.getLoginInfo", params);
	}
}







