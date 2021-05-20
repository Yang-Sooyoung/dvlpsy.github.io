package com.gd.test.bean;

public class TestBean3 {
	private int no;
	private char bookname;
	private String writer;
	
	public TestBean3() {
		//기본 생성자
	}
	
	public TestBean3(int no, char bookname, String writer) {
		setNo(no);
		setBookname(bookname);
		setWriter(writer);
	}

	public int getNo() {
		return no;
	}
	public int setNo(int no) {
		return this.no = no;
	}
	public char getBookname() {
		return bookname;
	}
	public void setBookname(char bookname) {
		this.bookname = bookname;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
}
