package PracticeB;

import PracticeA.Test;

public class Test2 extends Test { //Test가 부모, 부모껏 다 가져옴

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test2 test2 = new Test2(); // 자기 자신을 생성시켜도 됨, 그게 부모를 말하는거기도 함.
		System.out.println(test2.a);
	}
}
