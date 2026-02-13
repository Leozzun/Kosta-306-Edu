package ex0213;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		
		ShoppingMall sm = new ShoppingMall();
		
		//난수발생 전용 클래스 
		//Random r = new Random();
		for(int i = 0; i < 10; i++) {
			int age = (int)(Math.random() * 55 + 1); //r.nextInt(55);
			
			try {
				System.out.println(age);
				sm.ageinput(age);
				
			} catch (AException e) {
				System.out.println(e.getMessage());
				AException.count++;
			}
		}
		System.out.println(AException.count);
	}
}
