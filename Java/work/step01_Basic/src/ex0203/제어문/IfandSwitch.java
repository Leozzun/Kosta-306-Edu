package ex0203.제어문;

public class IfandSwitch {
	
	public static void main(String[] args) {
		// 1~ 12사이의 난수를 발생한다.
		double nansu = (Math.random()*12 + 1);
		System.out.println("난수 = "+ nansu);
		
		int convertNo = (int)nansu;
		System.out.println("변환 = " + convertNo);
		
		// 그 난수는 월이라고 생각하고 월에 해당하는 마지막 일수를 출력한다.
		
		//if문
		
		int month = convertNo;
		int day = 30;
		
		/*
		 * if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 ||
		 * month == 10 || month == 12) { day = 31; } else if(month == 2) { day = 28; }
		 */
		
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
		
		day = switch(month) {
			case 2 -> 28;
			case 4,6,9,11 -> {
				System.out.println("안녕");
				yield 30;
			}
			default -> 31;
		};
		
		System.out.println(month+"월은 " + day + "일까지 있습니다.");

	}
}
