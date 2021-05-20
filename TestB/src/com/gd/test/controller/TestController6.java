package com.gd.test.controller;

import com.gd.test.service.SingletonService;

public class TestController6 {//상수, 스테틱영역, 싱글톤서비스

	public static final String CO_NAME = "GOODEE"; //상수 : 어디든 똑같은 값 가져다 쓰는것, 몽땅다 대문자, 기울임 굵어짐 색바뀜
												   //공용이름
	public static void main(String[] args) { //static영역 : 자바가 따로 관리하는 공간
		TestController6 t = new TestController6();
		t.test();
		//같은공간 출신이면 출신 밝혀줄 필요 없다.
		TestController6.test2();
		
		final int a =10;
		
		//a = 7;

		System.out.println(TestController6.CO_NAME);
		
		SingletonService ss = SingletonService.getInstance();
		
		System.out.println(ss.msg);
	}
						 // static : 정적
	public void test() { // static영역에 out이라고 객체변수 만들어놈
		System.out.println("test");
	}
	
	public static void test2() {
		System.out.println("test2");
	}
}
