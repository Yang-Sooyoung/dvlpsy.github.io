package com.gd.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZooService {
	Scanner sc = new Scanner(System.in);
	List<String> Cage = new ArrayList<String>(); // 우리 현황
	List<String> Animal = new ArrayList<String>();
	int[] VisitCtn = {0,0,0,0};
	int money = 3000;
	boolean food = false;
	
	String[] animalName = {"사자", "코끼리", "기린", "원숭이", "곰"};
	int[] animalCost = {1000, 800, 700, 100, 500}; //동물 구입비
	int[] addVisit = {10, 5, 2, 1, 6}; //추가 방문자
	int[] eatCost = {100, 80, 30, 10, 70}; //먹이 비용
	int[] animalCtn = {0, 0, 0, 0, 0,}; // 동물 갯수
	
	String[] cageSize = {"소", "중", "대"}; // 0 소 1 중 2 대
	int[] cageCost = {2000, 5000, 10000}; // 케이지 가격
	int i = 0;
	int[] CageCtn = {0, 0, 0}; // 케이지 동물수 소 중 대, 동물 넣을때마다 수를 넣어줘야함
	int[] MaxAni = {4, 8, 12}; 
	int minanimalCost;
	
	int bowlBuy = 10000;
	int foodBuy = 200;
	int d = 1; //날짜
	int CoCtn; // 총 케이지 수 합
	
	public void Zoo_game() { // 동물명, 금액, 추가방문객, 마리당 먹이비용,

		boolean runFlag = true;
		while (runFlag) { // 1.우리 구매 2.동물 구매 3.동물 배치 4.상태 보기 5.다음날로 이동 9.종료
			System.out.println(""); //방문객 랜덤, 우리마다,  다음날 이동 하면 먹이비용 -,  
			System.out.println("오늘은 " + d + "일 입니다."); // 날짜
			System.out.println(""); //
			System.out.println("메뉴를 선택하세요. (보유금액 : " + money + ")");
			System.out.println(""); //
			System.out.println("1.우리 구매 2.동물 구매 3.동물 배치 4.상태 보기 5.다음날로 이동 9.종료");

			switch (sc.nextLine()) { // 이름바꾸기
			case "1" : buyCage(); // 우리 구매
				break;
			case "2" : buyAnimal(); // 동물 구매
				break;
			case "3" : plantAnimal(); // 동물 배치
				break;
			case "4" : status(); // 상태보기 
				break;
			case "5" : nextDay(); // 다음날로 이동
				break;
			case "9":
				runFlag = false; // 종료
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}

	public void buyCage() { // 사이즈
		System.out.println("어떤 우리를 구매하시겠습니까?");
			System.out.println("");
			System.out.println("--가격표-------------------------------");
			System.out.println("크기\t비용\t최대허용동물");
			System.out.println("-------------------------------------");
			for (int i=0; i < cageSize.length; i++) {
 				System.out.println(cageSize[i] + "\t" + cageCost[i] + "\t" + MaxAni[i]); 
 			}
			System.out.println("");
 			System.out.println("1.소 2.중 3.대");
 			System.out.println("");
 			
		String input = sc.nextLine();
		
		int choice = Integer.parseInt(input) - 1;
		
		if (money < cageCost[choice]) { // 변수 설정하고 == 로 바꾸기, 비용
			System.out.println("보유 잔액이 부족합니다."); 
		} else {
		
		if(choice < 0 || choice >= cageSize.length) {
			System.out.println("잘못입력하셨습니다.");
		} else {
				if (cageSize[choice] == "소"){ // 종류
					money -= cageCost[choice]; //비용
					Cage.add("비어있음"); // 넣을수 있는 양
					Cage.add("비어있음"); // 넣을수 있는 양
					Cage.add("비어있음"); // 넣을수 있는 양
					Cage.add("비어있음"); // 넣을수 있는 양
					CageCtn[choice] += 1;
				} 
				if (cageSize[choice] == "중"){ // 종류
					money -= cageCost[choice]; //비용
					Cage.add("비어있음"); // 넣을수 있는 양
					Cage.add("비어있음"); // 넣을수 있는 양
					Cage.add("비어있음"); // 넣을수 있는 양
					Cage.add("비어있음"); // 넣을수 있는 양
					Cage.add("비어있음"); // 넣을수 있는 양
					Cage.add("비어있음"); // 넣을수 있는 양
					Cage.add("비어있음"); // 넣을수 있는 양
					Cage.add("비어있음"); // 넣을수 있는 양
					CageCtn[choice] += 1;
				} 
				if (cageSize[choice] == "대"){ // 종류
					money -= cageCost[choice]; //비용
					Cage.add("비어있음"); // 넣을수 있는 양
					Cage.add("비어있음"); // 넣을수 있는 양
					Cage.add("비어있음"); // 넣을수 있는 양
					Cage.add("비어있음"); // 넣을수 있는 양
					Cage.add("비어있음"); // 넣을수 있는 양
					Cage.add("비어있음"); // 넣을수 있는 양
					Cage.add("비어있음"); // 넣을수 있는 양
					Cage.add("비어있음"); // 넣을수 있는 양
					Cage.add("비어있음"); // 넣을수 있는 양
					Cage.add("비어있음"); // 넣을수 있는 양
					CageCtn[choice] += 1;
				}
				for (i = 0; i < Cage.size(); i++) {
					System.out.println("우리 개수 : " + cageSize[i] + CageCtn[i]);
				break;
				}
				for (int i = 0; i < Cage.size(); i++) {
					System.out.println("현재 우리 현황 | "+ Cage.get(i));
				}
			}
		}
	}
	public void buyAnimal() {
	 			System.out.println("어떤 동물을 구매하시겠습니까?");
	 			System.out.println("");
	 			System.out.println("--가격표-------------------------------");
	 			System.out.println("동물명\t금액\t추가방문객\t마리당 먹이비용"); // 성장 다되야 판매가능, 줄어들어서 0일떄부터
	 			System.out.println("-------------------------------------");
	 			for (int i=0; i < 5; i++) {
	 				System.out.println(animalName[i] + "\t" + animalCost[i] + "\t" + addVisit[i] + "\t" + eatCost[i]); 
	 			}
	 			System.out.println("");
	 			System.out.println("1.사자 2.코끼리 3.기린 4.원숭이 5.곰");
	 			System.out.println("");
	 			
				String input = sc.nextLine();
			
				int choice = Integer.parseInt(input) - 1;
				
				if (money < animalCost[choice]) {
					System.out.println("보유 잔액이 부족합니다.");
				} else {
				
				if(choice < 0 || choice >= animalName.length) {
					System.out.println("잘못입력하셨습니다.");
				} else {
					Animal.add("비어있음"); //이름 넣어줌
					if (Animal.contains("비어있음")== true) {
						for (i = 0; i < Animal.size(); i++) {
							if (Animal.get(i) == "비어있음"){ //종류
							money -= animalCost[choice]; //비용
							animalCtn[choice] += 1; //동물수,
							Animal.set(i, animalName[choice]+" "+animalCtn[choice]);
							System.out.println(Animal.get(i));
							break;
							}
						}
					}	
				}
			}
		}
	public void plantAnimal() {
		if ( Cage.contains("비어있음")== true ) {
			System.out.println("어떤 동물을 배치하시겠습니까?");
			System.out.println("");
			for (i = 0; i < Cage.size(); i++) {
				System.out.println("우리 개수 : " + cageSize[i] + CageCtn[i]);
			break;
			}
			for (int i = 0; i < Animal.size(); i++) {
				System.out.println(i+1+".현재 동물 현황 : " + Animal.get(i));
			}
			
			String input = sc.nextLine();
			
			int choice = Integer.parseInt(input) - 1;
			
			if(choice < 0 || choice >= Animal.size()) {
				System.out.println("잘못입력하셨습니다.");
			} else {
				for(i=0; i < Cage.size(); i++) {
					if (Cage.get(i).equals("비어있음")) {
							Cage.set(i, Animal.get(choice));
							System.out.println(Cage.get(i));
							animalCtn[choice] += 1; //케이지에 넣은 동물수,
							Animal.remove(choice);
							break;
						}
					}
				}
			}
		}
	public void status() {
		for (i = 0; i < Cage.size(); i++) {
			System.out.println("우리 개수 : " + cageSize[i] + CageCtn[i]);
		break;
		}
		for (i = 0; i < Cage.size(); i++) {
			System.out.println("현재 우리 현황 | "+ Cage.get(i) + "\t관광객 : " + VisitCtn[i]);
		}
		System.out.println(" ");
	}
	
	public void nextDay() {
		for(int i = 0; i < CageCtn.length; i++) {
			CoCtn += CageCtn[i];
		}
		d += 1 ;
		
		for(int i = 0 ; i < CageCtn.length ; i++) {
			if(Cage.size() != 0 && !Cage.get(i).equals("비어있음")) {
				if (CoCtn < 5 && CoCtn > 0) {
						 if (Cage.get(i).equals(animalName[i]))
							 VisitCtn[i] += ((Math.floor(Math.random() * 20) +80) + addVisit[i]);
						 	money -= eatCost[i];
						 	money += VisitCtn[i]*10;
						 		System.out.println(cageSize[0] + CageCtn[i]+"우리");
						 		if(CageCtn[0] > 0) {
						 			System.out.println(Cage.get(i)+"의 관광객은"+VisitCtn[i]+"명 입니다.");
						 			System.out.println("-------금일 수익은 " + VisitCtn[i]*10 + "입니다.--------");
						 			money += VisitCtn[0]* 10;
						 			break;
						 		}
						 	break;
						}
					}
				else if (CoCtn < 9 && CoCtn > 4) {
						 if (Cage.get(i).equals(animalName[i]))
							 VisitCtn[i] += ((Math.floor(Math.random() * 200) +100) + addVisit[i]);
						 	money -= eatCost[i];
						 	money += VisitCtn[i]*10;
						 		System.out.println(cageSize[1] + CageCtn[i]+"우리");
						 		if(CageCtn[1] > 0) {
						 			System.out.println(Cage.get(i)+"의 관광객은"+VisitCtn[i]+"명 입니다.");
						 			System.out.println("-------금일 수익은 " + VisitCtn[i]*10 + "입니다.--------");
						 			money += VisitCtn[1]*10;
						 			break;
						 		}
						 	break;
						} else {
						 if (Cage.get(i).equals(animalName[i]))
							 VisitCtn[i] += ((Math.floor(Math.random() * (CoCtn * 100)) +400) + addVisit[i]);
						 	money -= eatCost[i];
						 	money += VisitCtn[i]*10;
						 		System.out.println(cageSize[2] + CageCtn[i]+"우리");
						 		if(CageCtn[1] > 0) {
						 			System.out.println(Cage.get(i)+"의 관광객은"+VisitCtn[i]+"명 입니다.");
						 			System.out.println("-------금일 수익은 " + VisitCtn[i]*10 + "입니다.--------");
						 			money += VisitCtn[2]*10;
						 			break;
						 		}
						 	break;
					}
				}
			} // 안됌, 아래껄로 다시
//	for (i = 0; i < Cage.size(); i++) {
//	System.out.println(cageSize[i] + CageCtn[i]+"우리의"+Cage.get(i)+"의 관광객은"+VisitCtn[i]+"명 입니다.");
//		System.out.println("-------금일 수익은 " + VisitCtn[i]*10 + "입니다.--------");
//		money += VisitCtn[i]* 10;
//}
//		int gbn = Cage.get(i).indexOf(": ") + 2;
//		String front = Cage.get(i).substring(0, gbn);
//		
//		int visit = Integer.parseInt(Cage.get(i).substring(gbn));
//		
//		System.out.println(Integer.parseInt(Animal.get(i).substring(gbn)));	
//  d += 1 ; //날짜에 하루 추가
	}