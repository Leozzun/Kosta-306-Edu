package ex0211.constructor;

class Test {
	
	//외부에서 객체를 직접 생성하지 못하도록 막음
	private Test() {}
	
	//현재 객체를 직접 생성해서 리턴해주는 메소드 제공!!
	public Test getInstance() {
		return new Test();
	}
}

public class PrivateConstructorExam {

	public static void main(String[] args) {
		

	}

}
