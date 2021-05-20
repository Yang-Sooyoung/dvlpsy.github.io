package com.gd.test.service;

import java.util.Arrays;
import java.util.Scanner;

public class TestSer2 { // 로또 추첨번호
	int num;
	int[] lotto = new int[6];

	public void go2() {
		Scanner sr = new Scanner(System.in);
		num = sr.nextInt();

		for (int h = 0; h < num; h++) {

			for (int i = 0; i < lotto.length; i++) {
				lotto[i] = (int) Math.floor(Math.random() * 45) + 1;
			}
			for (int j = 0; j < lotto.length; j++) {
				for (int k = 0; k < lotto.length; k++) {
					if (j != k && lotto[j] == lotto[k]) {
						lotto[k] = (int) Math.floor(Math.random() * 45) + 1;
						k--;
					}
				}
			}
			System.out.println(Arrays.toString(lotto));
		}
	}
}