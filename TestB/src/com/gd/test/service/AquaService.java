package com.gd.test.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class AquaService { // 수족관 경영
	Scanner sc = new Scanner(System.in);
	List<HashMap<String, Integer>> bowl = new ArrayList<HashMap<String, Integer>>();
	int bowlCnt = 4;
	int money = 300;
	boolean food = false;
	
	String[] fishName = {"금붕어", "잉어", "구피", "상어", "고래"};
	int[] fishBuy = {100, 500, 200, 1000, 5000};
	int[] fishSell = {150, 1000, 350, 3000, 20000};
	int[] fishGrow = {3, 7, 5, 6, 10};
	int minFishBuy;
	
	int bowlBuy = 10000;
	int foodBuy = 200;
	
	public AquaService() {
		minFishBuy = fishBuy[0];
		
		for(int i = 1 ; i < fishBuy.length ; i++) {
			if(minFishBuy > fishBuy[i]) {
				minFishBuy = fishBuy[i];
			}
		}
	}
	
	public void run() {
		boolean runFlag = true;
		
		while(runFlag) {
			System.out.println("메뉴를 선택하시오. (보유금액 : " + money + ")");
			System.out.println("1.물고기구매  2.물고기판매  3.어항구매(" + bowlBuy + "원)  4.상태보기  5.먹이주기(" + foodBuy + "원)  6.다음날  7.종료");
			
			switch(sc.nextLine()) {
			case "1" : buyFish();
				break;
			case "2" : sellFish();
				break;
			case "3" : buyBowl();
				break;
			case "4" : status();
				break;
			case "5" : if(money < foodBuy) {
						   	System.out.println("먹이 비용이 부족합니다.");
					   } else if(bowl.size() == 0) {
						   	System.out.println("물고기가 없습니다.");
					   } else if(!food) {
					   		food = true;
					   		money -= foodBuy;
							grow(1);
					   } else {
							System.out.println("이미 먹이를 제공하였습니다.");
					   }
				break;
			case "6" : 
				food = false;
				grow(0);
				break;
			case "7" : runFlag = false;
				break;
			default : System.out.println("잘못 입력하셨습니다.");
			}
		}
	}
	
	public void buyFish() {
		if(money < minFishBuy) {
			System.out.println("금액이 부족합니다.");
		} else if(bowl.size() == bowlCnt) {
			System.out.println("어항에 공간이 없습니다.");
		} else {
			System.out.println("----- 구입할 물고기를 선택하세요. (보유금액 : " + money + "원) -----");
			for(int i = 0 ; i < fishName.length ; i++) {
				System.out.println((i + 1) + "." + fishName[i] 
						+ "(구매가 " + fishBuy[i] + "원, 판매가 " 
						+ fishSell[i] + "원, 성장 " + fishGrow[i] + "일)");
			}
			String input = sc.nextLine();
			
			int choice = Integer.parseInt(input) - 1;
			
			if(choice < 0 || choice >= fishName.length) {
				System.out.println("잘못입력하셨습니다.");
			} else {
				HashMap<String, Integer> fish = new HashMap<String, Integer>();
				fish.put("type", choice);
				int age = fishGrow[choice] * - 1;
				fish.put("age", age);
				
				bowl.add(fish);
				
				money -= fishBuy[choice];
			}
		}
	}
	
	// gbn : 0 - 다음날, 1 - 먹이주기
	public void grow(int gbn) {
		for(int i = 0 ; i < bowl.size() ; i++) {
			HashMap<String, Integer> fish = bowl.get(i);
			int age = fish.get("age");

			if(gbn == 1 && age < 0) {
				age++;
				fish.put("age", age);
			} else if(gbn == 0) {
				age++;
				fish.put("age", age);
			}
			
			if(age > 3) {
				System.out.println(fishName[fish.get("type")] + "가 죽었습니다.");
				
				bowl.remove(i);
				
				i--;
			}
		}
	}
	
	public void sellFish() {
		for(int i = bowl.size() - 1 ; i >= 0 ; i--) {
			HashMap<String, Integer> fish = bowl.get(i);
			int age = fish.get("age");
			
			if(age >= 0) {
				int type = fish.get("type");
				
				money += fishSell[type];
				
				System.out.println(fishName[type] + "가 " + fishSell[type] + "원에 팔렸습니다.");
				
				bowl.remove(i);
			}
		}
	}
	
	public void buyBowl() {
		if(money < bowlBuy) {
			System.out.println("어항 구매비용이 부족합니다.");
		} else {
			money -= bowlBuy;
			bowlCnt++;
		}
	}
	
	public void status() {
		System.out.println("----- 보유금액 : " + money + "원 -----");
		System.out.println("----- 보유어항 : " + bowlCnt + "개 -----");
		
		System.out.println("----- 어항상태 -----");
		
		for(HashMap<String, Integer> fish : bowl) {
			int type = fish.get("type");
			int age = fish.get("age");
			
			if(age < 0) {
				System.out.println(fishName[type] + "(성장완료까지 " + (age * - 1) + "일 남음)");
			} else {
				System.out.println(fishName[type] + "(성장완료 " + age + "일)");
			}
		}
	}
}
