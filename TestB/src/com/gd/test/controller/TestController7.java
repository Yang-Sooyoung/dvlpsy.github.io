package com.gd.test.controller;

import com.gd.test.service.SingletonService;
import com.gd.test.service.TestService4;

public class TestController7 { //싱글톤서비스

	public static void main(String[] args) {
		SingletonService ss = SingletonService.getInstance();
		
		System.out.println(ss.msg);
		
		ss.msg = "Hello~";
		
		TestService4 ts = new TestService4();
		
		ts.test();

		System.out.println(ss.msg);
	}

}
