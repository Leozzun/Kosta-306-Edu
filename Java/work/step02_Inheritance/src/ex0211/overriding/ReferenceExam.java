package ex0211.overriding;

class ObjectExam{
	String str;
	
	public ObjectExam(){   }
	public ObjectExam(String str){ 
		this.str = str;
	}
	
	public String toString() {
		return str + super.toString();
	}
}

class ReferenceExam{
	public static void main(String[] args){
			char c='a';
			
			String s01="장희정"; 
			String s02="Java";
			String s03=new String("월요일");
			
			ObjectExam oe1=new ObjectExam("진짜 가려고?");
			ObjectExam oe2=new ObjectExam("안녕");
			
			System.out.println(c);//
			System.out.println(s01);//
			System.out.println(s02);//
			System.out.println(s03);//
			System.out.println(oe1);//주소값 
			System.out.println(oe2);//주소값 
			
	}
}

