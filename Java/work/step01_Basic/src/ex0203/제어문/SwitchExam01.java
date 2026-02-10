package ex0203.제어문;

public class SwitchExam01 {

	public static void main(String[] args) {
		int kor = (int) (Math.random()*56 + 45);
		System.out.println("국어 = "+ kor);
		
		int eng = (int) (Math.random()*56 + 45);
		System.out.println("영어 = "+ eng);
		
		int math = (int) (Math.random()*56 + 45);
		System.out.println("수학 = "+ math);
		
		int total = kor + eng + math;
		System.out.println("총점 = "+ total);
		
		double avg = total / 3;
		System.out.println("평균 = "+ avg);
		
		char grade = 'F';
		
		//if문
		if(90 <= avg && 100 >= avg) {
			grade = 'A';
		}
		else if(80 <= avg && 89 >= avg) {
			grade = 'B';
		}
		else if(70 <= avg && 79 >= avg) {
			grade = 'C';
		}
		else if(60 <= avg && 69 >= avg) {
			grade = 'D';
		}
		
		System.out.println("등급 = "+ grade);
		
		
		//switch문
		
//		switch(month) {
//			case 2:
//				day = 28;
//				break;
//			case 4: case 6: case 9: case 11: 
//				day=30; 
//				break;
//			default:
//				day = 31;
//		}
		
		// version 14이후
//		switch(month) {
//			case 2:
//				day = 28;
//				break;
//			case 4,6,9,11: 
//				day=30; 
//				break;
//			default:
//				day = 31;
//		}

	}

}
