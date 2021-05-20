package com.gd.test.service;

public class SingletonService { // 싱글톤 서비스
	private static SingletonService instance;
	
	public String msg = "Hi~";
	
	public static SingletonService getInstance() {
		if(instance == null) {
			instance = new SingletonService();
		}
		
		return instance;
	}
}
