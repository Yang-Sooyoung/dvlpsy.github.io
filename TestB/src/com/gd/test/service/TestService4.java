package com.gd.test.service;

public class TestService4 { // 싱글톤 서비스
	public void test() { // 서비스에선 만들어줘야함..?
	SingletonService ss = SingletonService.getInstance();
	
	System.out.println(ss.msg);
	
	ss.msg = "안녕!";
	}

}
