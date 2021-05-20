package com.gd.test.controller;
import com.gd.test.service.SubwayService;

public class SubwayController {

	public static void main(String[] args) {
		SubwayService ss = new SubwayService();
		
		System.out.println("---- Welcome Subway ----");
		
		ss.run();
	}

}
