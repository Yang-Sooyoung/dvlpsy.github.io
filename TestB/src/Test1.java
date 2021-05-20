
public class Test1 { //어디서나 접근가능한 클래스, 클래스명 Test1

	public static void main(String[] args) { 
			//어디서는 접근가능하고 객체생성없이 사용 가능, 반환타입이 존재하지않는 메인이란 메소드가 있는데 , 실행될때는 문자열배열이 넘어와야 되고 그 배열이름을 args라고 쓰겠다. 
		System.out.println("Hello World!!"); 
			// 시스템이라는 클래스 안에 아웃이라는 스테틱 변수가 있는데 객체변수이고,  프린트엘엔(메소드?)을 실행해서 헬로우 월드를 넘겨주겠다.
		int a = 10;
		System.out.println(a); // . : ~ 안에 있는
		long b = 10;
		System.out.println(b);
		float c = 1.5f; // 1에 있는 5, 2가지 방법, 뒤에 f 붙이면 실수형으로 인식, 앞에 (float)붙여도 됨.
		System.out.println(c);
		double d = 2.25;
		System.out.println(d);
		char e = 'A'; // 문자형 ''
		System.out.println(e);
		String f = "ABC"; // 문자열 ""
		System.out.println(f);
		boolean g = true; //true or false
		System.out.println(g);
	}
}
