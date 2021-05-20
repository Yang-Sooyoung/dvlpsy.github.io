package com.gd.test.controller;

import com.gd.test.bean.TestBean2;

public class TestController3 {

	public static void main(String[] args) { //빈, 리스트
		TestBean2 tb = new TestBean2();
		
		tb.setNo(1); //세팅
		tb.setName("홍길동");
		tb.setAge(300);
		
		System.out.println(tb.getNo() + "|" + tb.getName() + "|" + tb.getAge ());
		// 값 가진다
		TestBean2[] arr = new TestBean2[5];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = new TestBean2();
			arr[i].setNo(i);
			arr[i].setName("Test" + i);
			arr[i].setAge(i * 5);
		}
		
		arr[0].setName("홍순자");
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i].getName());
		}
	}

}
