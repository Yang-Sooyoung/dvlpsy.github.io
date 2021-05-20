
public class Test3B {
	public int a = 7;
	
	public Test3B() { //아무것도 없을때 실행
		System.out.println("기본생성자 호출!");
	}
	
	public Test3B(String s) { //문자열 받았을 때 실행
		System.out.println("추가생성자 호출 : " + s);
	}
	
	public void test() {
		System.out.println("첫 메소드");
	}
	
	public int plus(int a, int b) { //void가 아닐때는 return 해서 값을 줘야함
		return a + b;
	}
	// 나머지 사칙연산 메소드 만들기
	
	public int minus(int a, int b) {
		return a - b;
	}
	
	public int multiplied(int a, int b) {
		return a * b;
	}
	
	public int divided(int a, int b) {
		return a / b;
	}
	
	public void b(int a) {
		for(int c = 0 ; c < 10 ; c++) {
			System.out.println(c);
		}
		test(); // 같은 클래스 안에 존재하는 메소드는 객체생성없이 호출 가능
		System.out.println(a);
	}
	
	/*
	 * public void near(int a) { int[] no = {45,17,22,1,98}; int result = 0; int
	 * temp = 0;
	 * 
	 * for(int i=0; i<no.length-1; i++) { if(Math.abs(no[i]-a) >
	 * Math.abs(no[i+1]-a)) { temp = Math.abs(no[i+1]-a); result = no[i+1]; } }
	 * System.out.println(a+ "에 근접한 값 :" + result); }
	 */
	
	//선생님꺼
	public void near(int num) {
		int[] no = {45,17,22,1,98};

		int n = no[0];

		for(int i = 1; i < no.length ; i++) {
			if(Math.abs(num-n) > Math.abs(num-no[i])) {
				n = no[i];
			}
		}
			System.out.println(n);
	}
}	
