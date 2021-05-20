

import java.util.Scanner;

public class SS { //Subway Service
	String[] station = {"장승백이","연신내","강남","양재","평택"};
	int now = 0;
	int pos = -1;
	Scanner sc = new Scanner(System.in);
	
	public void run() {
		boolean r = true;
		
		while (r) {
			System.out.println("=================================");
			System.out.println("현재역은 " + station[now] + "입니다.");
			System.out.println("=================================");
			System.out.println("메뉴를 선택하세요.");
			System.out.println("1.탑승 2.상세보기 3.이동 9.종료");
			
			switch(sc.nextLine()) {
			case "1" : break;
			case "2" : break;
			case "3" : move();
			break;
			case "9" : r = false;
					   System.out.println("열차운행을 종료합니다.");
					   break;
			default : System.out.println("잘못입력하였습니다.");
			}
		}
	}

	public void move() {
		if(now == station.length - 1 || now == 0) {
			pos *= -1;
		}
		
		now += pos;
	}
}
