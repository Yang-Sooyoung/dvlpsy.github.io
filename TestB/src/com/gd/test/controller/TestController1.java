package com.gd.test.controller;
import com.gd.test.service.CClass;
import com.gd.test.service.PClass;
// import 시 *는 모든파일을 나타냄
// import단축키 : ctrl + shift + o
import com.gd.test.service.TestService1;

public class TestController1 { // 상속, 지하철

   public static void main(String[] args) { // ?이거 메인 뜻이 뭐지..?
	  PClass P = new PClass();
	  
	  CClass c = new CClass();
	  
	  c.c();
	  
      TestService1 sc = new TestService1(); // 객체생성, 스캐너이름
      
      System.out.println("---- Welcome Subway ----");
		
      	sc.run();
	}
}

		/*
		 * System.out.println(sc.nextLine()); 
		 * System.out.println(sc.nextInt());
		 * System.out.println(sc.next()); 
		 * System.out.println(sc.nextLine());
		 */
		/*
		 * boolean a = true; 
		 * while(a) { 
		 * System.out.println("메뉴를 입력해 주세요.");
		 * System.out.println("1.ABC 9.종료");
		 * 
		 * switch(sc.nextLine()) { 
		 * case "1" : System.out.println("ABC"); 
		 * break; 
		 * case "9" : a = false; 
		 * break; 
		 * default : System.out.println("잘못입력하였습니다."); } }
		 */
      