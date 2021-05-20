package com.gd.test.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class StockService { // 주식 경영, 내꺼
	Scanner sc = new Scanner(System.in);
	List<String> list = new ArrayList<String>();
	int d = 1;
	
	int[] StockCnt = {0,0,0}; // 주식 가진거 카운트
	int[] BuyCost = {0,0,0};
	int[] SellCost = {0,0,0};
	int money = 500; // 시작금액
	boolean food = false;
	int i;
	int[] Score;
	
	String[] StockName = {"샘성", "까까오", "웹플릭스"};
	int[] StockCost = {100, 80, 150}; // +++
	int[] Buyfees = { 1/100, // 살때 수수료
					  1/100, // 살때 수수료
					  1/100}; // 살때 수수료
	int[] Sellfees = { 4/100, // 팔때 수수료  +++
					   4/100, // 팔때 수수료  +++
					   4/100}; // 팔때 수수료  +++
	int[] Updown = {0,0,0}; // 등락률 +++
	
	int minStockBuy;
	
	public StockService() {
		minStockBuy = StockCost[0];
		
		for(int i = 1 ; i < StockCost.length ; i++) {
			if(minStockBuy > StockCost[i]) {
				minStockBuy = StockCost[i];
			}
		}
	}
	
	public void run() {
		boolean runFlag = true;
	
		while(runFlag) {// 1.주식 구매 2.주식 판매 3.보유내역 조회 4.다음날로 이동 5.종료
			System.out.println("오늘은 "+ d +"일 입니다."); // 날짜
			System.out.println("");
			for(int i = 0 ; i < StockName.length ; i++) {
				System.out.println((i + 1) + ". 종목명 :" + StockName[i] 
						+ " (금액 " + StockCost[i] + "원, 등락률 " + Updown[i] + "%)");
			}
			System.out.println("");
			System.out.println("메뉴를 선택하시오. (보유금액 : " + money + ")");
			System.out.println("1.주식 구매 2.주식 판매 3.보유내역 조회 4.다음날로 이동 5.종료");
			
			switch(sc.nextLine()) {
			case "1" : stockBuy();
				break;
			case "2" : stockSell();
				break;
			case "3" : status();
				break;
			case "4" : next();
				break;
			case "5" : runFlag = false;
				break;
			default : System.out.println("잘못 입력하셨습니다.");
			}
		}
	}

	public void stockBuy() { // 1.주식 구매 , 3
			if(money < StockCost[i]) {
			System.out.println("금액이 부족합니다.");
			} else {
			System.out.println("----- 구입할 주식을 선택하세요. (보유금액 : " + money + "원) -----");
			for(i = 0 ; i < StockName.length ; i++) {
				System.out.println((i + 1) + ". 종목명 :" + StockName[i] 
						+ " (금액 " + StockCost[i] + "원, 등락률 " + Updown[i] + "%)");
				}
			String input = sc.nextLine();
			
			int choice = Integer.parseInt(input) - 1;
			
			if(choice < 0 || choice >= StockName.length) {
				System.out.println("잘못입력하셨습니다.");
			} else {
				System.out.println("종목명\t"+"개수\t"+"구매금액");
				list.add("");
				for(i = 0 ; i < choice ; i++) {
					StockCnt[i] += 1; // : 초이스 - ( 초이스 * ( 4/100))
				StockCost[choice] = (int) ((int) StockCost[choice]-(-(StockCost[choice]*Updown[choice]*0.01))+(StockCost[choice]*0.01f));
				money -= StockCost[choice]; //돈 깎기, 수수료
				list.set(i, StockName[choice]+"\t"+StockCnt[choice]+"\t"+StockCost[choice]); //이상
				System.out.println(list.get(i));
				}
			}
		}
	}
	public void stockSell() { // 2.주식 판매
		
	}

	public void status() { // 3.보유내역 조회
			System.out.println("종목명\t"+"개수\t"+"총자산가치");
			for(i = 0 ; i < StockCnt.length ; i++) {
			list.set(i, StockName[i]+"\t"+StockCnt[i]); //+"\t"+SellCost[i]); //이상
			System.out.println(list.get(i)); //총 값 넣기 , 보유내역조회
 			} // Score[choice] += ( StockCost[choice] * Sellfees[choice] );
			System.out.println("");
		}
	
	public void next() { // 4.다음날로 이동
			d +=1; //날짜에 하루 추가
			for(int i=0; i < Updown.length; i++) {
			Updown[i] = (int) (Math.floor(Math.random() * 10) -5); // 등락률 +++}; // 등락률 +++
		}
	}
}