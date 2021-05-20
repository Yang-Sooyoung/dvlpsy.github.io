package com.gd.test.service;

public class CClass extends PClass { //상속받음
	public void c() { //관리 효율적, 정말 상속해서 써야되는 내용인지 판별 중요.
		System.out.println(msg); //메세지 약자
	}

	@Override //오버라이딩 된 애들은 머릿말 달고감. (언옵테이션..?)
	public void p() { //접근권한 넓어질수 있음.
		System.out.println("오버라이딩했음P"); //새로운 내용으로 갈아엎음
	}
	
	private void c(String s) { //오버로딩. 이름만 같은 메소드 여러개 생성.
		System.out.println(s); //private : 이 클래스 안에서만 호출할수 있음
	}
	
	public void pp() {
		//super : 부모
		super.p();
	}
}