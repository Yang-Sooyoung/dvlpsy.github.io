package com.gd.test.bean;

public class TestBean2 { //빈 쓸때 private 권장, 캡슐화
	private int no;
	private String name;
	private int age;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
