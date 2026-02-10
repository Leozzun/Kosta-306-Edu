package ex0210.thisisjava;

public class Printer {
	
//	public static void main(String[] args) {
//		Printer printer = new Printer();
//		printer.println(10);
//		printer.println(true);
//		printer.println(5.7);
//		printer.println("홍길동");
//	}
//	
//	public void println(int value) {
//		System.out.println(value);
//	}
//	
//	public void println(boolean value) {
//		System.out.println(value);
//	}
//	
//	public void println(double value) {
//		System.out.println(value);
//	}
//	
//	public void println(String value) {
//		System.out.println(value);
//	}
	
// Printer 객체 생성 X	
	
	public static void main(String[] args) {
		Printer.println(10);
		Printer.println(true);
		Printer.println(5.7);
		Printer.println("홍길동");
	}
	
	static void println(int value) {
		System.out.println(value);
	}
	
	static void println(boolean value) {
		System.out.println(value);
	}
	
	static void println(double value) {
		System.out.println(value);
	}
	
	static void println(String value) {
		System.out.println(value);
	}
}
