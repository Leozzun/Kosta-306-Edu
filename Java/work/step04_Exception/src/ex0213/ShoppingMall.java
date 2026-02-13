package ex0213;

public class ShoppingMall {
	
	public void ageinput(int age) throws AException {
		if(age < 18) {
			//발생할 객체 생성
			//AException e = new AException();
			//thow e; // 둘을 한줄로 바꿔서 밑에 처럼 표현 
			throw new AException("애들은 가라");
		} else {
			System.out.println("입장하신걸 환영합니다.");
		}	
	}
}
