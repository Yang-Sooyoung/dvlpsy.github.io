package com.gd.test.service;

import java.util.Scanner;

public class Ex1Service { // 냉장고 게임
	// 원하는 주사위면체와 주사위 개수 입력받아 출력

	Scanner sc = new Scanner(System.in);
	Scanner sc1 = new Scanner(System.in);

//	public void game() {
//		int i;
//		int rect;
//		int num;
//		int su;
//		System.out.println("몇 면체의 주사위를 원하십니까?"); // 주사위면체 입력
//		rect = sc.nextInt();
//		System.out.println(rect + "면체 주사위를 선택하셨습니다.");
//		System.out.println("");
//		System.out.println("몇 개의 주사위를 원하십니까?"); // 주사위 개수 입력
//		num = sc1.nextInt();
//		System.out.println(num + "개의  주사위를 선택하셨습니다.");
//		for (i = 0; i < num; i++) {
//			su = (int) Math.floor(Math.random() * rect) + 1;
//			System.out.println(i + 1 + "번째 주사위: " + su);
//		}
//	}
//
//	public void random() {
//		int cnt;
//		int j;
//		int luck[] = new int[6];
//		Scanner sc = new Scanner(System.in);
//		cnt = sc.nextInt();
//		
//		for (k = 0; k < cnt; k++) {
//			for (i = 0; i < 6; i++) {
//				luck[i] = (int) Math.floor(Math.random() * 45) + 1;
//				
//				// 중복제거
//				for (j = 0; j < i; j++) {
//					if (luck[i] == luck[j]) {
//						i--;
//						break;
//					}
//				} 
//			}
//			
//			// 번호 출력
//			System.out.print("로또번호  ");
//				for (int i = 0; i < 6; i++) {
//				System.out.print(luck[i]+" ");
//				}
//				System.out.println("");
//			}
//		}
	
	String[] food = new String[50]; // 배열길이 쓸 때 50번이 도는 문제가 발생. 해결 필요 [null, null, null]
	int[] date = new int[50];
	int size = 0;
	int egg_s = 1;
	int milk_s = 3;
	int watermelon_s = 5;
	boolean a = true;

	public void refrigerator() {
		for (int i = 0; i < food.length; i++) {
			food[i] = ""; // null값이 아니라 공백으로 값을 넣어준다. food ={"", "" , "" ....} food= {"계란", "", "", ""
		}
		while (a) {
			System.out.println("");
			System.out.println("=============================");
			System.out.println("기능을 선택 해 주세요");
			System.out.println("1.제품보관 2.현재품목 3.날짜이동 9.종료");
			System.out.println("=============================");

			switch (sc.nextInt()) {
			case (1): // 제품보관
				s();
				break;
			case (2): // 현재품목
				now();
				break;
			case (3): // 날짜이동
				move();
				break;
			case (9): // 종료
				System.out.println("프로그램을 종료합니다.");
				a = false;
				break;
			default:
				System.out.println(" 잘못된 입력입니다.");
			}

		}
	}

	int i = 0;
	int k = 0;

	public void s() { // 보관 기능, 조건3,
		System.out.println("냉장고에 어떤 제품을 넣으시겠어요?");
		System.out.println("[1.계란  2.우유  3.수박]");
		System.out.println("숫자만 입력 해주세요.");
		switch (sc.nextInt()) {
		case (1): //계란
			for ( i = 0; i < food.length; i++) { // 조건3
				if ((size <= 50 - egg_s && food[i] == "")) {
					size += egg_s; // 1 50
					food[i] = "계란"; // food[0] ="계란" food[0] food[1]
					date[i] = 3; // date [0] =3 date [1] =3
					System.out.println(i + 1 + "번째칸에 " + food[i] + " 이(가) 들어갔습니다.");
					break;
				}
				if (size >= 50 - egg_s) { // 조건5
					System.out.println("냉장고에 저장된 품목의 크기는 50을 넘을 수 없습니다.");
					System.out.println("현재 냉장고에 저장된 품목의 크기는 " + size + "입니다.");
					break;
				}
			}
			break;
		case (2): //우유
			for (i = 0; i < food.length; i++)
				if ((size <= 50 - milk_s && food[i] == "")) {
					size += milk_s;
					food[i] = "우유";
					date[i] = 5;
					System.out.println(i + 1 + "번째칸에 " + food[i] + " 이(가) 들어갔습니다.");
					break;
				}
			if (size >= 50 - milk_s) {
				System.out.println("냉장고에 저장된 품목의 크기는 50을 넘을 수 없습니다.");
				System.out.println("현재 냉장고에 저장된 품목의 크기는 " + size + "입니다.");
				break;
			}
			break;
		case (3): //수박
			for (i = 0; i < food.length; i++)
				if ((size <= 50 - watermelon_s && food[i] == "")) {
					size += watermelon_s;
					food[i] = "수박";
					date[i] = 7;
					System.out.println(i + 1 + "번째칸에 " + food[i] + " 이(가) 들어갔습니다.");
					break;
				}
			if (size >= 50 - watermelon_s) {
				System.out.println("냉장고에 저장된 품목의 크기는 50을 넘을 수 없습니다.");
				System.out.println("현재 냉장고에 저장된 품목의 크기는 " + size + "입니다.");
				break;
			}
			break;

		default:
			System.out.println(" 잘못된 입력입니다.");
		}

	}

	public void now() { // 현재품목 기능, 조건7
		System.out.println("냉장고 현황 /잔여 유통기한");
		for (int j = 0; j < food.length; j++) {
			if (food[j] != "") { // 비어있지 않을 때
				System.out.println(food[j] + "/" + date[j]);
			}
		}
		System.out.println("현재 냉장고자리 : " + size + "/50");
	}

	public void move() { // 날짜이동 기능
		int cnt = 0;
		System.out.println("하루가 지났습니다.");
		System.out.println("유통기한이 지난 음식은 폐기됩니다.");
		for (int j = 0; j < food.length; j++) {
			date[j] = date[j] - 1;
			if (date[j] == 0) {
				if (food[j].equals("계란")) {
					size -= egg_s;

				}
				if (food[j].equals("우유")) {
					size -= milk_s;
				}

				if (food[j].equals("수박")) {
					size -= watermelon_s;
				}

				food[j] = "";
				cnt++;
			}
		}

		System.out.println("📢 유통기한이 지난 음식 " + cnt + "개 폐기 되었습니다.");
		System.out.println("현재 냉장고자리 : " + size + "/50");

	}

}
