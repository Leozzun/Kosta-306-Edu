package ex0205;

public class Array_08 {

	public static void main(String[] args) {
		int[][] array = {
				{95, 86},
				{83, 92, 96},
				{78, 83, 93, 87, 88}
		};
		
		int sum = 0;
		double avg = 0.0;
		
		//작성 위치
		int len = array.length;
		
		for(int i = 0; i<len; i++) {
			for(int j = 0; j<array[i].length; j++) {
				sum += array[i][j];
			}
			avg = sum / (double) (array[0].length + array[1].length + array[2].length);	
		}
		
		System.out.println("sum: " + sum);
		System.out.println("avg: " + avg);
	}

}
