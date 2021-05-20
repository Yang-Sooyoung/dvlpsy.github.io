
public class Test3A {

	public static void main(String[] args) {
		Test3B b = new Test3B("Hi"); // 객체생성 , 뉴 뒤에 생성자 이미 있어서 여기서 실행, 1회성.
		Test3B b2 = b;
		System.out.println(b.a);
		
		b.a = 3;
		
		System.out.println(b.a);

		System.out.println(b2.a);
		
		b = new Test3B();
		
		System.out.println(b.a);
		
		b2 = new Test3B();

		System.out.println(b2.a);
		
		b.test();
		
		System.out.println(b.plus(3, 7));

		System.out.println(b.minus(3, 7));
		
		System.out.println(b.multiplied(3, 7));

		System.out.println(b.divided(3, 7));
		
		b.near(7);
	}

}
