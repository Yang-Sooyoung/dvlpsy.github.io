package com.gd.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.gd.test.bean.FarmBean;

public class FarmService { // 농사 짓기
	Scanner sc = new Scanner(System.in);
	List<String> land = new ArrayList<String>();
	List<String> seed = new ArrayList<String>();
	FarmBean[] arr = new FarmBean[4];
	int money = 1000;
	int i = 0;
	int j = 0; //땅갯수
	int l = 0; //땅가격
	int c = 0; //농작물
	int d = 1; //날짜

	String[] seedname = { "감자", "호박", "보리", "쌀" };
	int[] seedCnt = { 0, 0, 0 }; // 씨앗 가진거 카운트
	int[] seedgrow = { 5, 8, 10, 20 };
	int[] landbuy = { 100, 300, 1000 };
	int springcooler = 100;

	public void Farm_game() { // 농작물명, 살때가격, 판매가격  + 성장일
		arr[0] = new FarmBean("감자", 100, 5, 150);
		arr[1] = new FarmBean("호박", 300, 8, 450);
		arr[2] = new FarmBean("보리", 500, 10, 720);
		arr[3] = new FarmBean("쌀", 1000, 20, 2250);
		
		for(int i = 0; i < 20; i++) {
			land.add("비어있음");
		}

		boolean runFlag = true;
		while (runFlag) { // 1.농지 구매 2.씨앗 구매 3.씨앗 심기 4.상태 보기 5.스프링쿨러 구매 6.농작물판매  7.다음날로 이동 8.종료
			System.out.println(""); //
			System.out.println("오늘은 " + d + "일 입니다."); // 날짜
			System.out.println(""); //
			System.out.println("메뉴를 선택하세요. (보유금액 : " + money + ")");
			System.out.println(""); //
			System.out.println("1.농지 구매(" + landbuy[l] + "원) 2.씨앗 구매 3.씨앗 심기 4.상태 보기 "
					+ "5.스프링쿨러 구매(" + springcooler + "원) 6.농작물판매  7.다음날로 이동 8.종료");

			switch (sc.nextLine()) {
			case "1" : buyLand(); // 농지 구매
				break;
			case "2" : buySeed(); // 씨앗 구매
				break;
			case "3" : plantSeed(); // 씨앗 심기
				break;
			case "4" : status(); // 상태보기 
				break;
			case "5" : buySpring(); // 스프링쿨러 구매
				break;
			case "6" : sellCrops(); // 작물 팔기
				break;
			case "7" : nextDay(); // 다음날로 이동
				break;
			case "8":
				runFlag = false; // 종료
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}
	public void buyLand() { // 안됌
			if (money < landbuy[l]) { // 변수 설정하고 == 로 바꾸기
				System.out.println("보유 잔액이 부족합니다."); 
			} else {
					money -= landbuy[l];
					land.add("비어있음");
					land.add("비어있음");
					land.add("비어있음");
					land.add("비어있음");
					land.add("비어있음");
					land.add("비어있음");
					land.add("비어있음");
					land.add("비어있음");
					land.add("비어있음");
					land.add("비어있음");
					l++;
				
				System.out.println("현재 농지 개수 : " + land.size());
				for (i = 0; i < land.size(); i++) {
				System.out.println("현재 농지 현황 : " + land.get(i));
				}
			}
		}
	public void buySeed() {
		for(i = 0; i < arr.length; i++) {
			if (money >= arr[i].getBuy()) {
	 			System.out.println("어떤 씨앗을 구매하시겠습니까?");
	 			System.out.println("");
	 			System.out.println("--가격표-------------------------------");
	 			System.out.println("농작물명\t구매\t성장\t판매"); // 성장 다되야 판매가능, 줄어들어서 0일떄부터
	 			System.out.println("-------------------------------------");
	 			for (FarmBean a : arr) {
	 				System.out.println(a.getName() + "\t" + a.getBuy() + "\t" + a.getGrow() + "\t" + a.getSell()); 
	 			}
	 			System.out.println("");
	 			System.out.println("1.감자 2.호박 3.보리 4.쌀");
	 			System.out.println("");
				String input = sc.nextLine();
			
				int choice = Integer.parseInt(input) - 1;
				
				if (money < arr[choice].getBuy()) {
					System.out.println("보유 잔액이 부족합니다.");
					break;
				}
				
				if(choice < 0 || choice >= seedname.length) {
					System.out.println("잘못입력하셨습니다.");
				} else {
						seed.add("비어있음");
					if (seed.contains("비어있음")== true) {
						for (i = 0; i < seed.size(); i++) {
							if (seed.get(i) == "비어있음") {
								seed.set(i, arr[choice].getName()+" | 남은 성장일 : "+ arr[choice].getGrow());
								System.out.println(seed.get(i));
								money-=arr[choice].getBuy();
								break;
							}
						}
					}	
				}
				break;
			}
		}
	}
	public void plantSeed() {
			if ( land.size() > seed.size() ) {
				System.out.println("어떤 씨앗을 심으시겠습니까?");
				System.out.println("");
/* seedstate */	for (i = 0; i < seed.size(); i++) {
					System.out.println(i+1+".현재 씨앗 현황 : " + seed.get(i));
				}	
				
				String input = sc.nextLine();
				
				int choice = Integer.parseInt(input) - 1;
				
				if(choice < 0 || choice >= seed.size()) {
					System.out.println("잘못입력하셨습니다.");
				} else {
					for(i=0; i < land.size(); i++) {
						if (land.get(i).equals("비어있음")) {
								land.set(i, seed.get(choice));
								System.out.println(land.get(i));
								seed.remove(choice);
								break;
						}
					}
				}
			}
		}
	public void status() {
			System.out.println("현재 농지 개수 : " + land.size());
			for(i = 0; i < land.size(); i++) {
				System.out.println("현재 농지 현황 : " + land.get(i));
			}	
		System.out.println("");
	}
	public void buySpring() { // 한번만 사기
		if(money < springcooler)	{
			System.out.println("금액이 부족합니다.");
		}else{
			money-=springcooler;
			for (FarmBean a : arr) {
				a.setGrow(a.getGrow()-2);
 				System.out.println(a.getName() + "\t" + a.getBuy() + "\t" + a.getGrow() + "\t" + a.getSell()); 
 			}
		}
	}
	public void sellCrops() { // 0되면, 돈으로 바꿔줌, 선생님꺼 참고해서
		
		
	}
	public void nextDay() { // -5되면
		for(int i = 0 ; i < land.size() ; i++) {
			if(!land.get(i).equals("비어있음")) {
				int gbn = land.get(i).indexOf(": ") + 2;
				
				String front = land.get(i).substring(0, gbn);
				
				int grow = Integer.parseInt(land.get(i).substring(gbn));
				
				grow--;
				
				if(grow < -5) {
					land.remove(i);
					i--;
					land.add("비어있음");
					 System.out.println("유통기한 지난 제품이 사라집니다."); //뭔지 찾기
				} else {
					land.set(i, front + grow);
				}
			}
		}
		d +=1; //날짜에 하루 추가
	}
}