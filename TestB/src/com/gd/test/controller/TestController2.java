package com.gd.test.controller;

import com.gd.test.service.TestServiceB;

public class TestController2 { //추상클래스

	public static void main(String[] args) {
		//TestServiceA ta = new TestSErviceA(); // 객체는 완전해야함. B호출해야하는데  B내용이 없음
		TestServiceB tb = new TestServiceB();
		
		tb.a();
		tb.b();
	}

}
