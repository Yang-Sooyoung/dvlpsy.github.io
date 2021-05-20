

public class MethodExample {

	public static void main(String[] args) { // 클래스가 생성됐을 떄 가장 먼저 실행을 맡게되는 실행 메소드
		
//		String a = "hello";
//		String b = "sooyoung";
//		
//		System.out.println(a + b);  주석 : ctrl +/ 
															// rename : alt + shift + R
		MethodExample methodExample = new MethodExample();  // 이 클래스를 안에서 활용하기 위해서 이 시점에서 클래스 생성을 해준 것.
//		methodExample.StrCombine("hello", "sooyoung"); // .누르면 사용가능한 메소드 목록 다 뜸, 메소드 실행 (String 타입을 2개를 넘겨 줌.)
		
		String abc = methodExample.StrSoo("hello", "sooyoung");
		
		System.out.println(abc);
	}

	// 메소드 만든 것
	// 메소드를 만드는 이유
	// 1. 유지보수를 위해서
	// 2. 가독성이 좋아지니까
	// 3. 캡슐화 ( 여러 곳에서 중복된 코드를 작성할 필요가 없어짐 )
	// void는 실행형 메소드.
	public void StrCombine (String a, String b) { // 어디선가 스트링컴바인 메소드 호출할때 같이 넣어줄 친구들 타입과 변수명.
		String result = a + b;
		System.out.println(result);
	}
	
	public String StrSoo (String Him, String naeja) { // return 리턴형 메소드
		String result = Him + naeja; // 메소드 형태 아무거나 사용가능
		return result; //변수타입 지정했을때 변수타입 그대로 되돌려줘야함.
	}
}
