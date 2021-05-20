import java.util.Scanner;

public class Main {//백준연습
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char a, b, c, d, e, f;
		int abc = (char) sc.nextInt();
		int def = (char) sc.nextInt();
		
		System.out.println(Integer.parseInt("abc")*'f');
		System.out.println(Integer.parseInt("abc")*'e');
		System.out.println(Integer.parseInt("abc")*'d');
		System.out.println(Integer.parseInt("abc")*'f'+(Integer.parseInt("abc")*'e')*10+(Integer.parseInt("abc")*'d')*100);
	}
}