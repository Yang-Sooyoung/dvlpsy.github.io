package com.gd.test.service; // ? 어쩔때 패키지로 묶는지, 지하철, 내꺼, 갖다씀

import java.util.Scanner; // 임폴트 : 저 클래스에서 가져다 쓴다. 경로, 기본 자바도구, 스캐너 사용

public class TestService1 { //클래스 : 사용하는 화면. 스테이션을 트레일에 넣었을때 탔다.
	String[] station = { "금천구청", "독산", "가산디지털단지", "구로", "신도림" };
	int now = 0; // 현재
	int pos = -1; // 위치
	int[][] trail = {{-1, -1, -1, -1},  // 인덱스 기반, 나올수 없다. 늘어날수도 있음을 전제,
					 {-1, -1, -1, -1}, // 아예 불가능 숫자 칸마다 넣어버림.
					 {-1, -1, -1, -1},
					 {-1, -1, -1, -1}};
	Scanner sc = new Scanner(System.in); //서비스에서만 써야함, 서비스에서 이름
										 //입력하는 값 컴퓨터가 받는 것. 새로운 객체인 스캐너 생성
	public void run() { // 이동, 나타남
		boolean r = true; // ?정의.. r...? false..?
		
		while (r) { // ?왜 나우?
			System.out.println("====================");
			System.out.println("현재역은 "+ station[now] + "역 입니다.");
			System.out.println("====================");
			System.out.println("메뉴를 선택하세요.");
			System.out.println("1.탑승 2.상태보기 3.이동 9.종료");
			
			switch(sc.nextLine()) { //sc : 객체변수명. 사용자가 입력하는 값을 다음 라인에 받겠다.
			case "1" : join();
						break; //브레이크 써야 계속 스위치문 돌지 않음.
			case "2" : status();
						break; //브레이크 써야 계속 스위치문 돌지 않음.
			case "3" : move();
						break; //브레이크 써야 계속 스위치문 돌지 않음.
			case "9" : r = false;
					   System.out.println("열차운행을 종료합니다.");
					    break; //브레이크 써야 계속 스위치문 돌지 않음.
			default : System.out.println("잘못입력하였습니다."); // 다른 입력값을 받으러 케이스 1로 다시 돌아감.
			}
		}
	}

	public void join() { //탑승가능 현황 , 스위치 X
		int imp = 0; //불가능변수
			System.out.println("---- 탑승 가능 현황 ----");
			
		for(int i = 0; i < trail.length ; i++) {
			System.out.print((i + 1) +"호차 : "); // print 뒤에 ln 빼야 같은 줄에 나옴. block같은 느낌
			if(checkTrail(i) > 0) {
				System.out.println("가능"); //ln 해야 다음줄에 나옴. inline-block같은 느낌
			} else {
				System.out.println("불가능"); //ln 해야 다음줄에 나옴. inline-block같은 느낌
				imp++; //탈수없는 사람 1추가
			}
		}
		
		if(imp == trail.length) { //만약 탈수 없으면
			System.out.println("탑승가능 열차가 없습니다.");
		} else { //만약 탈수 있으면
			System.out.println("어느 열차에 탑승하시겠습니까?");
			
			for(int i = 0 ; i < trail.length ; i++) { // 3까지, 딱 손님까지 , 반복문
				System.out.print((i + 1) + "." + (i + 1) + "호차 "); // i문 생성, 기본값 1로주고 1+ i호차로 설정 출력.
			}
			System.out.println(); // ? 뭐 인출해주는거지..?
			
			String input = sc.nextLine(); // 문자열 입력. 입력받은 값을 넣어줌.
			int t = Integer.parseInt(input) - 1; // 여기서 숫자 입력받은 값을 넣어주네... 이걸 했어야 되는거 같은데 잘모르겠다.
			if(checkTrail(t) > 0) { //열차칸수 체크, 열차 탄 사람 생길때
				System.out.println("목적지를 선택해 주세요."); 
				for(int i = 0 ; i < station.length ; i++) { //열차길이보다 작음.
					if(now != i) { // 
						System.out.print((i + 1) + "." + station[i] + " ");
					}
				}
				
				System.out.println();
				String input2 = sc.nextLine();
				int s = Integer.parseInt(input2) - 1;
				
				if(s == now) {
					System.out.println("목적지로 현재역은 안됩니다.");
				} else {
					for(int i = 0 ; i < trail[t].length ; i++) {
						if(trail[t][i] == -1) {
							trail[t][i] = s;
							break;
						}
					}
				}
				
			} else {
				System.out.println("탑승이 불가능합니다.");
			}
			
		}
	}
	
	public void status() {
		System.out.println("---- 열차 현황 ----");
		
		for(int i = 0 ; i < trail.length ; i++) {
			System.out.print((i + 1) + "호차 : ");
			for(int j : trail[i]) {
				if(j > -1) {
					System.out.print("[" + station[j] + "]");
				}
			}
			System.out.println();
		}
	}

	public void move() {
		
		if(now == station.length - 1 || now == 0) {
			pos *= -1;
		}
		
		now += pos;
		
		int cnt = 0;
		for(int i = 0 ; i < trail.length ; i++) {
			for(int j = 0 ; j < trail[i].length ; j++) {
				if(trail[i][j] == now) {
					cnt++;
					trail[i][j] = -1;
				}
			}
		}
		
		if(cnt > 0) {
			System.out.println(cnt + "명이 하차하였습니다.");
		}
	}
	
	public int checkTrail(int num) {
		int cnt = 0;
		
		for(int target : trail[num]) {
			if(target == -1) {
				cnt++;
			}
		}
		
		return cnt;
	}
}
