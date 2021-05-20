package com.gd.test.controller;

import com.gd.test.service.CarService;

public class CarController {

	public static void main(String[] args) {
		CarService sc = new CarService();
		
		System.out.println("---- 자동차 ----");
		
		sc.run();
	}

}
