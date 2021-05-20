package com.gd.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.gd.test.bean.AquaBean;

public class Ex2Service { // 수족관 게임
	Scanner sc = new Scanner(System.in);
	AquaBean[] arr = new AquaBean[3];
	//List<Integer> f = new ArrayList<Integer>();
	List<String> list = new ArrayList<String>();
	boolean g = true;
	int money = 300;
	int i;
	int j;
	int date = 0;

	public void fish_game() { // 어항 4개, 물고기 3, 자금 300원부터 시작
		arr[0] = new AquaBean("금붕어", 100, 150, 3);
		arr[1] = new AquaBean("잉어", 500, 1000, 7);
		arr[2] = new AquaBean("구피", 200, 350, 5);
		
		list.add("비어있음");
		list.add("비어있음");
		list.add("비어있음");
		list.add("비어있음");
		
		System.out.println("--가격표-------------------------------");
		System.out.println("물고기명\t구매\t판매\t성장"); // 성장 다되야 판매가능, 줄어들어서 0일떄부터
		System.out.println("-------------------------------------");
		for (AquaBean a : arr) {
			System.out.println(a.getName() + "\t" + a.getBuy() + "\t" + a.getSell() + "\t" + a.getGrow());
		}
		System.out.println("");
		System.out.println("날짜 : " +date);
		System.out.println("");
		System.out.println("현재 자금 : " + money);
		System.out.println("현재 어항 개수 : " + list.size());
		System.out.println("");
		for (int i = 0; i < list.size(); i++) {
			System.out.println("현재 어항 현황 : " + list.get(i));
		}		
	
		while (g) {
		System.out.println("=============================");
		System.out.println("무엇을 하시겠습니까?");
		System.out.println("1.어항구입(10000원) 2.물고기구입 3.먹이주기(200원) 4.다음날로 이동 5.어항 상태 보기 6.물고기 판매 9.종료");
		System.out.println("=============================");


			switch (sc.nextInt()) { // 어항구입, 물고기구입, 먹이주기, 다음날로 이동, 어항 상태 보기, 물고기 판매, 종료
			case (1): // 어항구입
				fishroom();
				break;
			case (2): // 물고기구입
				fish();
				break;
			case (3): // 먹이주기
				feed();
			break;
//			case (4): // 다음날로 이동
//				next();
//			break;
			case (5): // 어항 상태 보기
				state();
			break;
//			case (6): // 물고기판매
//				sell();
//			break;
			case (9): // 종료
				System.out.println("프로그램을 종료합니다.");
				g = false;
				break;
			default: // 잘못 입력
				System.out.println(" 잘못된 입력입니다.");
			}
		}
	}
	public void fishroom() {// 어항 구입 
		if (money >= 1) { // 변수 설정하고 == 로 바꾸기
			list.add("비어있음");
			System.out.println("현재 어항 개수 : " + list.size());
			for (i = 0; i < list.size(); i++) {
				System.out.println("현재 어항 현황 : " + list.get(i) + "날짜 : " +date);
			}					
		}	
	}
	public void fish() {
		System.out.println("어떤 물고기를 구매하시겠습니까?");
		System.out.println("1.금붕어 2.잉어 3.구피 ");
		switch (sc.nextInt()) {
		case 1 : // 금붕어
			if (list.contains("비어있음")== true) {
				for (i = 0; i < list.size(); i++) {
					if (list.get(i) == "비어있음") {
						list.set(i, arr[0].getName()+" | 남은 성장일 : "+arr[0].getGrow());
						System.out.println(list.get(i));
						break;
						} 
					}
			} else {
			System.out.println("비어있는 어항이 존재하지 않습니다.");
			}
		break;
		case 2 : // 잉어
			if (list.contains("비어있음")== true) {
				for (i = 0; i < list.size(); i++) {
					if (list.get(i) == "비어있음") {
						list.set(i, arr[1].getName()+" | 남은 성장일 : "+arr[1].getGrow());
						System.out.println(list.get(i));
						break;
						} 
					}
			} else {
			System.out.println("비어있는 어항이 존재하지 않습니다.");
			}
		break; // 케이스를 탈출
		case 3 : // 구피
			if (list.contains("비어있음")== true) {
				for (i = 0; i < list.size(); i++) {
					if (list.get(i) == "비어있음") {
						list.set(i, arr[2].getName()+" | 남은 성장일 : "+arr[2].getGrow());
						System.out.println(list.get(i));
						break;
						} 
					}
			} else {
			System.out.println("비어있는 어항이 존재하지 않습니다.");
			}
		break; // 케이스를 탈출
		default:
			System.out.println(" 잘못된 입력입니다.");
		}
	}
	private void feed() {  // Integer.parseInt("123") +2); //문자열123을 숫자로 바꿈 : 125// Grow 문자
		for (i = 0; i < list.size(); i++) {
			date += 1;
			arr[i].setGrow(i); 
			arr[i].getGrow();
			list.set(i, arr[i].getName()+" | 남은 성장일 : "+arr[i].getGrow());//arr[i].getGrow() -1씩
			//System.out.println("현재 어항 현황 : " + list.get(i)); 상태보기에서 찍자
			System.out.println("날짜 : " +date);
			System.out.println("");
/* 어항상태 */	System.out.println("현재 어항 개수 : " + list.size());
			for (i = 0; i < list.size(); i++) {
				System.out.println("현재 어항 현황 : " + list.get(i));
			}			
		}			
	}
//	private void next() {
//		date += 1;
//	}
	private void state() {
		System.out.println("현재 어항 개수 : " + list.size());
		for (i = 0; i < list.size(); i++) {
			System.out.println("현재 어항 현황 : " + list.get(i));
		}			
	}
//	private void sell() {
//		
//	}
}