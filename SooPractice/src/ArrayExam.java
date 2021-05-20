

public class ArrayExam {

	public static void main(String[] args) {
		String a = "a";
		int b =1;
		
		int arrayInt[] = new int[10]; //0부터 9까지의 수를 담고 있음.
		for (int i = 0; i < arrayInt.length; i++) {
			System.out.println(i);
		}
		
		int arrayInt2[] = {1,3,5,7,9};
		for (int i = 0; i < arrayInt2.length; i++) {
			System.out.println(arrayInt2[i]);
		}

		String arrayStr[] = {"a","b","c","d","e"};
		for (int i = 0; i < arrayStr.length; i++) {
			System.out.println(arrayStr[i]);
		}
	}
}
