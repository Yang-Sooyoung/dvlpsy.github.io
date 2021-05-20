package com.gd.test.controller;

import com.gd.test.bean.TestBean1;

public class ExController { //빈, 배열, 오름차순 정렬

	public static void main(String[] args) {
		TestBean1[] arr = new TestBean1[4]; // 클래스명 = 새로운 배열객체 생성, 생성자가 초기에 한번 실행됨

		//		TestBean2 temp; // 배열객체랑 클래스명은 같게 생성됨
//	
//		for(int i=0; i<arr.length; i++) {
//			arr[i]=new TestBean2();// 
//		}
//		arr[0].setNo(7);
//		arr[0].setBookname('A');
//		arr[0].setWriter("홍길동");
//	
//		arr[1].setNo(5);
//		arr[1].setBookname('B');
//		arr[1].setWriter("김철수");
//						
//		arr[2].setNo(9);
//		arr[2].setBookname('C');
//		arr[2].setWriter("가나다");
//								
//		arr[3].setNo(3);
//		arr[3].setBookname('D');
//		arr[3].setWriter("나몰라");
//
		arr[0] = new TestBean1(7, 'A', "홍길동");
		arr[1] = new TestBean1(5, 'B', "김철수");
		arr[2] = new TestBean1(9, 'C', "가나다");
		arr[3] = new TestBean1(3, 'D', "나몰라");

		TestBean1 temp;

		System.out.println(" 책번호, " + "책제목, " + "저자");

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i].getNo() > arr[j].getNo()) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for (TestBean1 a : arr) { // 변수 a 아무거나 선언 ; 배열에서 0부터 a까지 한번씩 찍어주는것...?
			System.out.println("  " + a.getNo() + "  |  " + a.getBookname() + "  |  " + a.getWriter());
		}
	}
}