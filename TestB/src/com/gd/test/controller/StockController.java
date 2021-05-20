package com.gd.test.controller;

import com.gd.test.service.StockService;

public class StockController {

	public static void main(String[] args) {
		StockService ss = new StockService();
		System.out.println("==================");
		System.out.println("     주식 게임           ");
		System.out.println("==================");
		ss.run();
	}
}
