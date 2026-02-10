package ex0205;

public class Array_07 {

	public static void main(String[] args) {
		int max = 0;
		int[] array = {1, 5, 3, 8, 2};
		
		// 작성 위치
		int len = array.length;
		for(int i = 0; i < len; i++) {
			if(max < array[i]) {
				max = array[i];
			}
		}
		
		System.out.println("max: " + max);

	}

}
