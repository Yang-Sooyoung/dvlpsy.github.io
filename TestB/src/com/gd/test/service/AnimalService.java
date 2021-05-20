package com.gd.test.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class AnimalService {
	List<HashMap<String, Integer>> dongmul = new ArrayList<HashMap<String, Integer>>(); // 우리 리스트 한 줄 한 줄
	List<Integer> woori = new ArrayList<Integer>(); // 우리 리스트 한 줄 한 줄
	List<HashMap<String, Integer>> wooriAnimal = new ArrayList<HashMap<String, Integer>>(); // 우리 리스트 한 줄 한 줄
	String[] animal = { "사자", "코끼리", "기린", "원숭이", "곰" };
	int[] animalCnt = { 0, 0, 0, 0, 0 }; // 현황 보여 줄 때 총 마릿수
	int[] bonus = { 10, 5, 2, 1, 6 };
	int[] buy = { 100000, 80000, 70000, 10000, 50000 };
	int[] food = { 100, 80, 30, 10, 7000 };
	String[] fenceSize = { "소", "중", "대" };
	int[] fenceBuy = { 200000, 500000, 1000000 };
	int[] fenceScale = { 4, 8, 12 };
	int money = 300000;
	int sonnim = 0;

	boolean al = true;
	Scanner sc = new Scanner(System.in);

	public void start() {
		while (al) {
			System.out.println("----------------------------------------");
			System.out.println("🐆🐘🐒   메뉴를 선택해주세요  🐆🐘🐒  ");
			System.out.println("1. 동물 구매  2. 우리 구매  3. 날짜변경  4. 동물원 현황 ");
			System.out.println("----------------------------------------");

			switch (sc.nextLine()) {
			case "1":
				animal();
				break;
			case "2":
				fence();
				break;
			case "3":
				date();
				if(money < 0) {
					System.out.println("파산으로 인한 동물원 폐장");	
					al = false;
				}
				break;
			case "4":
				board();
				break;

			default:
				System.out.println("잘못된 입력입니다.");
			}
		}

	}

	public void animal() {
		if (fenceCnt == 0) {
			System.out.println("우리가 없습니다.");
		} else {
			System.out.println("-------우리를 선택하세요--------");
			System.out.println("번호\t남은자리\t");
			for (int i = 0; i < woori.size(); i++) {
				System.out.println((i + 1) + "\t" + woori.get(i)); // 우리 남은 수만 알려주고 다음에 못 들어가게 하면 되징
			}
			String numFence = sc.nextLine();
			int num = Integer.parseInt(numFence) - 1;
			if (woori.get(num) == 0) {
				System.out.println("자리가 부족합니다.");
			} else {

				System.out.println("--------------------------");
				System.out.println("-------------동물  정보-------------");
				System.out.println("---------------------------------");
				System.out.println("동물명\t금액\t추가방문객\t마리당먹이비용\t");
				System.out.println("---------------------------------");
				for (int i = 0; i < animal.length; i++) {
					System.out.println(
							(i + 1) + "." + animal[i] + "\t" + buy[i] + "\t" + bonus[i] + "\t" + food[i] + "\t");
				}
				System.out.println("---------------------------------");

				String input = sc.nextLine();
				int choice = Integer.parseInt(input) - 1; // 동물을 선택해.
				if (money - buy[choice] < 0) {
					System.out.println("돈이 부족합니다.");
				}else {

				HashMap<String, Integer> ani = new HashMap<String, Integer>();
				ani.put("animalNum", choice); // 동물의 종류 인덱스
				ani.put("cageNum", num); // 우리의 번호

				if (checkCageAnimal(ani.get("cageNum"), ani.get("animalNum"))) {
					wooriAnimal.add(ani);
					animalCnt[choice]++; // 동물 종류에 따른 마릿수

					woori.set(num, woori.get(num) - 1); // 이렇게 우리를 제어해 준다.
					money -= buy[choice];
					System.out.println(buy[choice]);
					System.out.println(money);

				} else {
					System.out.println("우리에 넣을 수 없습니다.");
				}

			}
			}
		}
	}

	int fenceCnt = 0;

	public void fence() {
		System.out.println("-----------동물 우리 정보-----------");
		System.out.println("---------------------------------");
		System.out.println("크기\t비용\t허용동물\t");
		System.out.println("---------------------------------");
		for (int i = 0; i < fenceSize.length; i++) {
			System.out.println((i + 1) + "." + fenceSize[i] + "\t" + fenceBuy[i] + "\t" + fenceScale[i] + "\t");
		}
		System.out.println("---------------------------------");

		String input = sc.nextLine();
		int choice = Integer.parseInt(input) - 1;
		if (money - fenceBuy[choice] < 0) {
			System.out.println("돈이 부족합니다.");
		} else {
			switch (choice) {

			case 0:
				woori.add(4);
				break;
			case 1:
				woori.add(8);
				break;
			case 2:
				woori.add(12);
				break;
			}
			money -= fenceBuy[choice];
			System.out.println(money);
			fenceCnt++;

		}
	}

	int date = 0;
	int guest = 0;
	int foodDay = 0;

	public void date() {
		date++;
		System.out.println("-------개장  " + date + "일 째입니다.--------");
		if (fenceCnt >= 1 && fenceCnt < 5) {
			guest = (int) Math.floor(Math.random() * 21) + 80;
		} else if (fenceCnt >= 5 && fenceCnt < 9) {
			guest = (int) Math.floor(Math.random() * 201) + 100;
		} else if (fenceCnt >= 9) {
			guest = (int) Math.floor(Math.random() * (fenceCnt * 100)) + 400;
		}
		for (int i = 0; i < animalCnt.length; i++) {
			sonnim += animalCnt[i] * bonus[i];
			foodDay += animalCnt[i] * food[i];

		}
		int sonson = guest + sonnim;
		System.out.println("-------금일 방문객은 " + sonson + "입니다.--------");

		money += sonson * 10;
		money -= foodDay;
		System.out.println("-------금일 수익은 " + sonson * 10 + "입니다.--------");
		System.out.println("-------현재 자산은" + money + "입니다.--------");
	}

	public void board() {
		System.out.println("----------------------------");
		System.out.println("🐆🐘🐒   동물원 현황입니다 🐆🐘🐒  ");
		System.out.println("동물명\t마리 수\t");
		for (int i = 0; i < animal.length; i++) {
			System.out.println((i + 1) + "." + animal[i] + "\t" + animalCnt[i] + "\t");
		}
		System.out.println("----------------------------");

	}

	public boolean checkCageAnimal(int cageNum, int animalNum) { // 동물을 우리에 넣어줄 때 제어하기
		boolean res = false;

		int cnt = 0;

		int cageAnimalNum = -1;

		for (HashMap<String, Integer> ani : wooriAnimal) {
			if (ani.get("cageNum") == cageNum) {
				cnt++;
				cageAnimalNum = ani.get("animalNum");
			}
		}

		if (cnt == 0) {
			res = true;
		} else if (cageAnimalNum == animalNum) {
			res = true;
		}

		return res;
	}
}
