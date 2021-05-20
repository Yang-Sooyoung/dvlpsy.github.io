package PracticeA;

public class Test {
							  // 접근제한자 사용하는 이유 : 보안 떄문에, 사용자가 쉽게 접근, 해킹 X, 미리 소스에서 막아냄
							  // 상황에 따라서 접근제한자 사용, 프로젝트 협업할 때 완성도 높음.
	protected String a = "양수영"; // default : 아무것도 안쓰면 디폴트
							  // public : 다른 패키지에서도 가져다 쓸수 있음.
							  // private : 현재 클래스만 변수를 가져올수 있음.
							  // protected : 일반적으로 다른 패키지에선 접근X, 상속하면 가져다 쓸수 있게 됨.
	public static void main(String[] args) {
		
	}

}
