package ex0211_Inheritance;

class CarCenter{
	public void engineer(Car cd){ //cd = c;
		System.out.print(cd.carname+" 수리완료!\t");
		System.out.println("청구비용"+cd.cost+" 원");
		
	}
}

public class PolymorphismExam{
	public static void main(String[] args) {
		
		CarCenter cc=new CarCenter();
		
		EfSonata ef=new EfSonata();
		Carnival ca=new Carnival();
		Excel ex=new Excel();
		Car c= new Car();
		
		cc.engineer(c);//c 주소 값이 전달
		
		cc.engineer(ef);//
		cc.engineer(ca);//
		cc.engineer(ex);//
		
		
	
	}
}
