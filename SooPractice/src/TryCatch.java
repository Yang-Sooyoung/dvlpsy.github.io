

public class TryCatch {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int intArray [] = new int[5]; // intArray라는 변수에다가 5의 공간만큼을 배열로 선언. 
									  // (0, 1, 2, 3, 4, 5)
		try
		{
			intArray[5] = 10;
			intArray[6] = 1;
		}
		catch (Exception e)
		{
			e.printStackTrace(); // 실제 에러문을 출력.
			System.out.println("배열 범위 초과");
			System.exit(0); // 강제로 프로그램을 종료..
		}
		
		System.out.println("프로그램이 끝났어요");
	
	}
}
