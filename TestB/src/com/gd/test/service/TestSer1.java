package com.gd.test.service;

import java.util.Scanner;

public class TestSer1 { // 주사위 굴리기
	int num;
	int rect;
	int i;

	public void go() {
		Scanner sc = new Scanner(System.in);
		rect = sc.nextInt();
		num = sc.nextInt();

		for (i = 0; i < num; i++) {
			System.out.println((int) Math.floor(Math.random() * rect) + 1);
		}
	}
}