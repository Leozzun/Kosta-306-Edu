package ex0213;

public class ExceptionReturnExam {
     public void aa(int i) {
    	 System.out.println("----aa------");
    	 try {
	    	 if(i==0) {
	    		 //throw new RuntimeException("예외발생해요~~"); //unchecked 예외
	    		 //throw new Exception("예외발생해요~~"); //checked
	    		 return ; //함수를 빠져나가라!!
	    		 //System.exit(0);//프로램종료!!
	    	 }
	    	 System.out.println(i+"입니다.");
    	 }finally {
    	   System.out.println("----aa end------");
    	 }
     }
	public static void main(String[] args) {
		System.out.println("**메인 시작 **");
		
		//new ExceptionReturnExam().aa(5);
		new ExceptionReturnExam().aa(0);
		
		System.out.println("***메인 끝 ***");

	}

}











