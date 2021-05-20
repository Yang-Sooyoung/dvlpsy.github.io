package com.gd.test.service;

public class TestServiceB extends TestServiceA { //새로만든 메소드, 오버라이딩
// 오류 : 너도 추상클래스 되던지, 오버라이딩 하던지 해야함.

	@Override
	public void b() {
		System.out.println("새로만든 메소드");
	}
}
