package com.gd.test.web.test.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestDao implements ITestDao { /* 에드하기 */
	@Autowired
	public SqlSession sqlSession;

	@Override
	public List<HashMap<String, String>> getMem(HashMap<String,String> params) throws Throwable {
		// 복수의 row취득 시 selectList사용
		// ()에는 쿼리의 위치 지정 : 네임스페이스명.아이디명
		return sqlSession.selectList("test.getMem", params);
	}

	@Override
	public List<HashMap<String, String>> getB(HashMap<String,String> params) throws Throwable {
		return sqlSession.selectList("test.getB", params);
	}

	@Override
	public HashMap<String, String> getMemDetail(HashMap<String, String> params) throws Throwable {
		return sqlSession.selectOne("test.getMemDetail", params);
	}

	@Override
	public HashMap<String, String> getBDetail(HashMap<String, String> params) throws Throwable {
		return sqlSession.selectOne("test.getBDetail", params);
	}

	@Override
	public void addMem(HashMap<String, String> params) throws Throwable {
		sqlSession.insert("test.addMem", params);
	}

	@Override
	public void addB(HashMap<String, String> params) throws Throwable {
		sqlSession.insert("test.addB", params);
	}

	@Override
	public int updateMem(HashMap<String, String> params) throws Throwable {
		return sqlSession.update("test.updateMem", params);
	}

	@Override
	public int updateB(HashMap<String, String> params) throws Throwable {
		return sqlSession.update("test.updateB", params);
	}

	@Override
	public int deleteMem(HashMap<String, String> params) throws Throwable {
		return sqlSession.delete("test.deleteMem", params);
	}

	@Override
	public int deleteB(HashMap<String, String> params) throws Throwable {
		return sqlSession.delete("test.deleteB", params);
	}

	@Override
	public int getMemCnt(HashMap<String, String> params) throws Throwable {
		return sqlSession.selectOne("test.getMemCnt", params);
	}

	@Override
	public int getBCnt(HashMap<String, String> params) throws Throwable {
		return sqlSession.selectOne("test.getBCnt", params);
	}
}







