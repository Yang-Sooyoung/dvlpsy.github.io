package com.gd.test.controller;

import com.gd.test.service.ZooService;

public class ZooController { //농사 짓기

	public static void main(String[] args) {
		ZooService sc = new ZooService();
		System.out.println("==================");
		System.out.println("        동물원             ");
		System.out.println("==================");
		sc.Zoo_game();
	}

}
