package com.gd.test.controller;

import com.gd.test.service.AnimalService;

public class AnimalController {

	public static void main(String[] args) {
		AnimalService an = new AnimalService();
		System.out.println("==================");
		System.out.println("🐆🐘🐒   동물원  🐆🐘🐒  ");
		System.out.println("==================");
		an.start();
	}

}
