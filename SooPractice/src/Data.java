

public class Data {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char var1 = '양'; // 한 글자의 한글 or 영문 가능
		String var2 = "양수영"; // 여러글자의 문자열 가능
		
		byte var3 = -128; // -128 ~ +127까지 숫자가 가능하다.
		short var4 = -32768; // -32768 ~ +32767까지 숫자가 가능하다.
		int var5 = 999999999; // -21억 ~ +21억까지의 숫자가 가능하다.
		long var6 = 999999999; // 여러숫자의 입력가능
		
		float var7 = 0.5f; // 소수점 선언 후 뒤에  f를 까먹지 말고 붙이자!
		double var8 = 0.000005; // 소수점 선언
		
		boolean isStart = false; // true or false를 입력하여 조건식에서 많이 사용합니다.
		
		
		System.out.println(var1);
		System.out.println(var2);

		System.out.println(var3);
		System.out.println(var4);
		System.out.println(var5);
		System.out.println(var6);
		
		System.out.println(var7);
		System.out.println(var8);
		
		System.out.println(isStart);
	}

}
