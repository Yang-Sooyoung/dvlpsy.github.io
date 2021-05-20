
public class Test2 {

	public static void main(String[] args) {
		int a = 5;
		int b = 7;
		int c = 3;
		int temp;
		// 내림차순 정렬
		
		if(a < b){ //false일 경우 조건을 써야함.
			temp=b;
			b=a;
			a=temp;
		}
		if(a < c) {
			temp=c;
			c=a;
			a=temp;
		}
		if(b < c) {
			temp=c;
			c=b;
			b=temp;
		}
		
		System.out.println(a); // 7
		System.out.println(b); // 5
		System.out.println(c); // 3
		
		System.out.println((float)a); // 숫자를 실수로 바꿈 :7.0
		System.out.println(Integer.toString(a) +2); //숫자a를 문자열로 바꿈 : '7'2
		System.out.println(Integer.parseInt("123") +2); //문자열123을 숫자로 바꿈 : 125
		// 구구단 2 ~ 9단 출력
		
		for(int i = 1; i < 10; i++) { //println : 프린트라인의 약자, 끝에 엔터가 있냐 없냐 
			System.out.println(i);
		}
		
		for(int i = 2; i < 10; i++) {
			for(int j = 1; j < 10; j++) {
				
			System.out.println(i + " * " + j +" = " + (i * j));
			}
		}
		char s;
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if((i+j) %  2 == 0) {
					s = '*';
				}else {
					s = ' ';
				}
				System.out.print(s);
			}
			System.out.println();
		}
		
		for(int i = 0; i < 5; i++) { //다섯줄 1 2 3 4 5
			for(int j = 0; j < 5; j++) { //한줄의 한칸 1-1 1-2 1-3 1-4 1-5
				if(i % 2 == j % 2) { // i가 짝수일 때, j도 짝수이다. 나머지 2가 0일때.
					System.out.print("*");
				}else{ //i가 홀수일 떄, j도 홀수이다.
					System.out.print(" ");
				}
			}	
			System.out.println();
		}
		
		int[] arr = {5, 7, 3};
		int temp2;
		
		// 오름차순 정렬
		if(arr[0]>arr[1]){
			temp2=arr[0];
			arr[0]=arr[1];
			arr[1]=temp2;
		}
		if(arr[0]>arr[2]){
			temp2=arr[0];
			arr[0]=arr[2];
			arr[2]=temp2;
		}
		if(arr[1]>arr[2]){
			temp2=arr[1];
			arr[1]=arr[2];
			arr[2]=temp2;
		}
		
		for(int i : arr) {
			System.out.println(i);
		}
		
		for(int i = 0 ; i < 2 ; i++){ 
			for(int j = i+1; j < 3 ; j++){
				if(arr[i] > arr[j]){
					temp2=arr[i];
					arr[i]=arr[j];
					arr[j]=temp2;
				}
			}
		}
		for(int i : arr) {
		System.out.println(i);
		}
		
		int e = 0; //순서가 중요, 이게 젤 좋은거
		int f = 1;
		int g = 0;
		for(int i = 1; i < 11; i++){
			
			g=e+f;
			f=e; 
			e=g; 
			System.out.println(g);
		}
	}
}
