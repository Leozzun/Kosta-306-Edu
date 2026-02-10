package ex0210.constructor;
class Puppy3{
	/*String 타입 전역 변수 선언
	  int 타입 전역 변수 선언*/
	String name; //null
	int age; //0
	
	
	/*인수가 없는 생성자작성
		String 타입 전역변수에 "메리" 할당
		"puplic Puppy3()호출되었습니다"출력
		전역변수 출력
	*/		
	public Puppy3() {
		this.name = "메리";
		System.out.println("public Puppy3()호출되었습니다");
		System.out.println("이름: " + this.name);
        System.out.println("나이: " + this.age);
	}
	
	
	/*String 타입의 인수 1개를 받는 생성자작성
		String 타입 전역변수에 인수 할당
		"puplic Puppy3()호출되었습니다"출력
		전역변수 출력
	*/		
	public Puppy3(String name) {
		this.name = name;
		System.out.println("public Puppy3(name)호출되었습니다");
		System.out.println("이름: " + this.name);
        System.out.println("나이: " + this.age);
	}
		
	
	/*String 타입의 인수 2개를 받는 생성자작성
		인수2개를 하나의 String으로 만들어
		String 타입의 인수 1개를 받는 생성자에게 인수로 주며 호출
		"puplic Puppy3()호출되었습니다"출력
	*/		
	public Puppy3(String s1, String s2) {
		//String s3 = s1+s2;
		//this(s3); 생성자는 첫번째줄에서만 호출할 수 있기 때문에 위로 올려서 하나로 합친다
		this(s1 + s2);
		System.out.println("public Puppy3(String)호출되었습니다");
	}
	
	
	/*boolean 타입의 인수 1개를 받는 생성자작성
		인수를 "쫑"과 붙여 하나의 String으로 만들어
		String 타입의 인수 1개를 받는 생성자에게 인수로 주며 호출
		"puplic Puppy3()호출되었습니다"  출력
	*/					
	public Puppy3(boolean b) {
		this(b + "쫑");
		System.out.println("public Puppy3(boolean)호출되었습니다");
	}
	
	
	
	/*char 타입의 인수 1개를 받는 생성자작성
			인수가 없는 생성자를 호출하고
			인수로 받은 data를 int타입 전역변수에 할당	
			"puplic Puppy3()호출되었습니다"출력
			int형 전역변수출력
	*/			
	public Puppy3(char c) {
		this();
		this.age = c;
		System.out.println("public Puppy3(char)호출되었습니다");
		System.out.println("나이: " + this.age);
	}
	
	
	
	/*메소드 printMemberVariable
	리턴 없슴
	전역변수를 출력
	*/	
	public void printMemberVariable() {
		System.out.println("이름: " + name);
        System.out.println("나이: " + age);
	}
}

public class ConstructorOverloadingExam{
		//메인메소드에서
		public static void main(String [] args){
			//Puppy3 클래스의 각 생성자를 한번씩 이용해 객체 5개 생성
			Puppy3 p1 = new Puppy3();
	        Puppy3 p2 = new Puppy3("초코");
	        Puppy3 p3 = new Puppy3("뽀", "삐");
	        Puppy3 p4 = new Puppy3(true);
	        Puppy3 p5 = new Puppy3('A');
			

	
			
		//각 객체의 printMemberVariable메소드를 한번씩 호출
			p1.printMemberVariable();
			p2.printMemberVariable();
			p3.printMemberVariable();
			p4.printMemberVariable();
			p5.printMemberVariable();
			
	}
}