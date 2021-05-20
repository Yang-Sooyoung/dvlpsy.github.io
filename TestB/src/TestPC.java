// *** 자바의 최상위 클래스 : java.lang.Object(객체),이미 상속받는 중.
public class TestPC { // <- 클래스명 뒤에 object 있어야 하지만 기본적으로 생략 가능

	public static void main(String[] args) { // 자식쪽이 덩어리가 큼, 객체는 완성형이어야 함.
		PClass p = new PClass(); // 부모쪽꺼 다 가지고 있으면 가능, 왼쪽거가 오른쪽꺼 채울수 있으면 가능
		
		p.p(); 
		
		CClass c = new CClass();
		
		c.p(); // c가 p물려받았기 때문에 잘 호출됨, c에 p메소드 생성한 적X
		c.c();
		c.c("abc");
		c.pp();
		
		PClass p2 = new CClass(); // 새 객체 주소를 p2 넣어줌 , C로 만들어진 애
 		
		p2.p();
		// 다운캐스팅 : 부모를 자식의 형태로 형변환 - 부모에 없는 내용을 호출 시 예외 발생, 자제 요구.
		// 업캐스팅 : 자식을 부모의 형태로 형변환 -문제사항 없음,  권장 O.
		CClass c3 = (CClass)p2; // p2 주소 c3 넣어줌, 캐스팅..?
		
		c3.c();
		
		// 업캐스팅 : PClass -> Object
		Object o = (Object)p;
		System.out.println(o.toString());

		// 다운캐스팅 : PClass(CClass의 객체를 가진 부모) -> CClass
		//			 인터페이스는 클래스로 다운캐스팅 가능 (Spring 가서 확인)
		CClass c4 = (CClass)p2; //알맹이가 CClass면 다운캐스팅 가능
		// c4.c(); -> 객체에 없기에 호출불가
		System.out.println(c4.toString());
		
		/*
		 * List<Integer> list = new ArrayList<Integer>(); List<Integer> list2 = new
		 * LinkedList<Integer>();
		 * 
		 * LinkedList<Integer> lista = (LinkedList<Integer>) list;
		 */
	}          
}

// P p1 = new P(); 왼쪽게 봉지, 오른쪽게 내용물 , 꼬깔콘 // 보이기는 봉지처럼 보이지만 동작은 내용물로 동작
// C c1 = new C(); 선언부는 메뉴얼. 아이폰12 = 아이폰 11기능 담음 , 아이폰 11기능만 이용가능
// P p2 = new C(); 아이폰11 = 아이폰 12기능 담음, 아이폰 12기능 이용X
// C c1 = new P(); 4번째는 부족해서 애초에 실행 안됌.
//
// 오버라이딩 - 부모클래스에 선언된 메소드를 재정의 하는것 (update)
// **조건 : 반환타입, 메소드명, 인자타입, 인자개수 동일 (절대 바뀌면 안됨)
// 		     접근권한은 넓은 범위로 가능
//		     예외처리는 좁은 범위로 가능
// 오버로딩 - 이름만 동일한 메소드를 여러개 생성 (new)
// **조건 : 이름만 같다. 그 외에는 다른 부분이 존재해야 함.