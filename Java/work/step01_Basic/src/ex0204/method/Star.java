package ex0204.method;

public class Star {

	public static void main(String[] args) {
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		
		for(int i=1; i<=25; i++) {
			System.out.print("*");
		}
		System.out.println();
		
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=6-i; j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		
		for(int i=1; i<=25; i++) {
			System.out.print("*");
		}
		System.out.println();
		
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=5-i; j++) {
				System.out.print(" ");
			}
			for(int j=1; j<=i; j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		
		for(int i=1; i<=25; i++) {
			System.out.print("*");
		}
		System.out.println();
		
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=i-1; j++) {
				System.out.print(" ");
			}
			for(int j=1; j<=i+5; j++) {
				System.out.print("★");
			}
			System.out.println();
		}
	}
}
