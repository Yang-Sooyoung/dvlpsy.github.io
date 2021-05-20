package com.gd.test.controller;

import com.gd.test.service.FarmService;

public class FarmController { //농사 짓기

	public static void main(String[] args) {
		FarmService sc = new FarmService();
		System.out.println("==================");
		System.out.println("      농사 짓기              ");
		System.out.println("==================");
		sc.Farm_game();
	}

}
