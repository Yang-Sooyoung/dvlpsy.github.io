package com.gd.test.controller;

import com.gd.test.service.Ex1Service;

public class Ex1Controller { //냉장고

	public static void main(String[] args) {
		Ex1Service e = new Ex1Service();
		
		
		/*
		 * System.out.println("🎛🎛🎛 주사위 게임 🎛🎛🎛");
		 * System.out.println("===== START! ====="); e.game();
		 */
		
		/*
		 * System.out.println(" 📢 로또 번호를 몇 개 출력할까요? "); e.random();
		 */
		
		  System.out.println("🍕🍔🍟🌭🍖 냉장고에 뭐가 있을까 🍤🍕🍔🍟🌭🍖🍤");
		  
		  e.refrigerator();
		 
	}

}
