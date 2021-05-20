
public class Test4 {

	public static void main(String[] args) {
		String s = "Hello World!!";
		
		// length() : 문자열 길이
		System.out.println(s.length());
		
		// indexOf(값) : 값과 일치하는 첫번째 위치를 돌려줌
		// indexOf(값, 숫자) : 숫자 이상부터 값과 일치하는 곳의 위치를 돌려줌
		System.out.println(s.indexOf("l"));
		System.out.println(s.indexOf("l", 4));
	
		// lastIndexOf(값) : 뒤에서부터 값과 일치하는 첫번째 위치를 돌려줌
		// lastIndexOf(값, 숫자) : 뒤에서부터 숫자이하부터 값과 일치하는 곳의 위치를 돌려줌
		System.out.println(s.lastIndexOf("l"));
		System.out.println(s.lastIndexOf("l", 4));
		
		// replace(값1, 값2) : 값1을 값2로 변경
		// replaceAll(값1, 값2) : 값1을 값2로 변경
		System.out.println(s.replace("l", "k"));
		System.out.println(s.replaceAll("l", "k"));
		// replaceFirst(값1, 값2) : 첫번째 값1을 값2로 변경
		System.out.println(s.replaceFirst("l", "k"));
		
		// substring(숫자) : 숫자 이상부터 자른다.
		// substring(숫자1, 숫자2) : 숫자 1이상 숫자 2미만부터 자른다.
		System.out.println(s.substring(3));
		System.out.println(s.substring(3,4));
		
		// toUpperCase() : 전부다 대문자로 바꾼다.
		// toLowerCase() : 전부다 소문자로 바꾼다.
		System.out.println(s.toUpperCase());
		System.out.println(s.toLowerCase());
		
		// trim() : 앞 뒤 공백제거
		System.out.println("      Hi Hello     ".trim());
		
		// charAt(숫자) : 숫자위치의 값을 가져옴
		System.out.println(s.charAt(3));
		
		//split(값) : 값을 기준으로 문자열을 잘라서 배열로 변경
		
		/*
		 * String[] a = "hi,hello,bye".split(","); 
		 * System.out.println(a.length);
		 */
		
		// equals(값) : 문자열의 내용이 같은지 비교
		System.out.println(s.equals("Hi"));	
	
		String[] arr = {"hello","world","java"};
		for(int i=0; i<3; i++) {
			if(i>0) {//1
				arr[i]=arr[i].substring(0,1).toUpperCase()//W + ordl = World
				+arr[i].substring(1);//world -> orld
			}
			System.out.print(arr[i]);
		}

		//선생님꺼
		
		String[] a = {"hello", "world", "java"};
		String camel = a[0].toLowerCase();
		
		for(int i = 1; i < a.length; i++) {
			camel += a[i].substring(0, 1).toUpperCase();
			camel += a[i].substring(1).toLowerCase();
		}
		
		System.out.println(camel);
		// 받아온 숫자와 아래 배열에서 가장 가까운 숫자를 구하는 메소드 만들기
		}
}