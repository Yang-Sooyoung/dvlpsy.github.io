package com.gd.test.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.gd.test.controller.TestController6;

public class StockService2 { //주식 경영. ex
	int money = 500;
	String[] name = {"샘송", "까까오", "웹플릭스"};
	int[] price = {100, 80, 150};
	
	List<HashMap<String, Integer>> stock = new ArrayList<HashMap<String, Integer>>();
	// 리스트로 할때는 각각 주소 할당해줘야함..., 뉴 해줘야함
	List<HashMap<String, Integer>> pocket = new ArrayList<HashMap<String, Integer>>();
	//Bean11[String] = new Bean11 [list]; ... ????
	
	public StockService2() { //생성자 ()...
		for(int i = 0; i < name.length; i++) {
		HashMap<String, Integer> s = new HashMap<String, Integer>(); // 뉴를 잘해야함.
		
		s.put("com", i);
		s.put("price", price[i]);
		s.put("updown", 0);
		
		stock.add(s);
		}
		for(int i = 0; i < name.length; i++) {
			HashMap<String, Integer> s = new HashMap<String, Integer>();
			
			s.put("com", i);
			s.put("quantity", 0);
			
			pocket.add(s);
		}	
	}
}
