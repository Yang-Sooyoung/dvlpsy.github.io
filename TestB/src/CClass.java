
public class CClass extends PClass { //상속받음 : p클래스에서 제공하는 내용이 여기에도 있다.
	public void c() {				 //관리 효율적, 정말 상속해서 써야되는 내용인지 판별 중요.
		System.out.println(msg);	 //Child Class, Parents Class
	}

	@Override //오버라이딩 된 애들은 머릿말 달고감. (언옵테이션..?)
	public void p() {
		System.out.println("오버라이딩했음P"); //새로운 내용으로 갈아엎음
	}
	
	public void c(String s) { // 오버로딩. 이름만 같은 메소드 여러개 생성
		System.out.println(s);
	}
	
	public void pp() {
		//super : 부모
		super.p();
	}
}
