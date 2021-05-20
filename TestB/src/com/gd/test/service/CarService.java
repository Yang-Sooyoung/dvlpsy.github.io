package com.gd.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarService {
	int i = 0;
	int j = 0;
	int pos = -1; // 목적지에서 내리니까.
	int speed = 0; // 현재 속도
	int driver = 0;
	String[] car = { "운전석", "좌석1", "좌석2", "좌석3" }; // 차
	List<String> sonnim = new ArrayList<String>();
	int addCtn = 0; // 탄 사람 수

	Scanner sc = new Scanner(System.in);

	public void run() { // 탑승, 내리기, 액셀, 브레이크로 -1, 운전자 있을때만 엑셀 가능, 속도 0x 탑 내릴수 X
		boolean r = true;

		while (r) { // 운전석 만들어야겠네
			System.out.println("=================================");
			System.out.println("=====현재 속도는" + speed + "입니다=====");
			System.out.println("메뉴를 선택하세요.");
			System.out.println("1.탑승 2.하차 3.엑셀 4.브레이크 5.상세보기 9.종료");
			System.out.println("=================================");

			switch (sc.nextLine()) {
			case "1":
				add(); // 타기
				break;
			case "2":
				minus(); // 내리기
				break;
			case "3":
				if (speed == 150) {
					System.out.println("더이상 속도를 올릴수 없습니다.");
				} else {
					fast(); // 엑셀
				}
				break;
			case "4":
				slow(); // 브레이크
				break;
			case "5":
				state(); // 상세보기, 현탑승자수, 속도, 차안
				break;
			case "9":
				r = false;
				System.out.println("종료합니다.");
				break;
			default:
				System.out.println("잘못입력하였습니다.");
			}
		}
	}

	public void add() {
		System.out.println("---- 탑승가능 현황 ----");
		System.out.println("어느 좌석에 탑승하시겠습니까?");
		for (i = 0; i < car.length; i++) {
			System.out.println(i + 1 + ". " + car[i]);
		}
		System.out.println();
		String input = sc.nextLine();
		int t = Integer.parseInt(input) - 1;

		if (t == 0) {
			if (driver == 0) {
				driver += 1;
				sonnim.add("손님");
				car[t] += sonnim.get(j);
				addCtn += 1;
				System.out.println("엑셀을 밟아 운전을 시작해주세요.");
			} else {
				System.out.println("운전자가 이미 존재합니다. 다른 자리를 선택해 주세요.");
			}
		} else {
			for (i = 0; i < car.length; i++) {
				if (car[t].contains("손님") == false) {
					sonnim.add("손님");
					car[t] += sonnim.get(j);
					addCtn += 1;
				}
			}
		}
	}

	public void minus() {
		for (i = 0; i < car.length; i++) {
			if (speed == 0 && addCtn > 0) {
				System.out.println("어떤 분이 내리겠습니까?");
				for (i = 0; i < car.length; i++) {
					System.out.println(i + 1 + ". " + car[i]);
				}
				
				System.out.println();
				String input = sc.nextLine();
				int t = Integer.parseInt(input) - 1;
				if (car[t].contains("손님")&& t == 0) {
					driver -= 1;
					car[t] = "운전석";
					addCtn -= 1;
				} else {
					car[t] = "좌석"+t;
					addCtn -= 1;
				}
					System.out.println("하차되었습니다.");
					break;
			} else {
				System.out.println("아직 내릴수 없습니다.");
				break;
			}
		}
	}

	public void fast() {
		if (driver > 0) {
			speed += 10;
			System.out.println("속도가 10 증가하였습니다.");
			System.out.println("현재 속도는" + speed + "입니다.");
		} else {
			System.out.println("운전자가 존재하지 않습니다. 운전석에 탑승해주세요.");
		}
	}

	public void slow() {
		if (speed > 0) {
			speed -= 10;
			System.out.println("속도가 10 감소하였습니다.");
			System.out.println("현재 속도는" + speed + "입니다.");
		} else {
			System.out.println("자동차가 움직이고 있지 않습니다. 엑셀을 밟아주세요.");
		}
	}

	public void state() {
		System.out.println("현재 탑습인원은" + addCtn + "입니다.");
		System.out.println("현재 속도는" + speed + "입니다.");
		System.out.println("----------자동차 내부----------");
		for (i = 0; i < car.length; i++) {
			System.out.println(car[i]);
		}
	}
}
