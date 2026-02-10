package ex0205.array;

class MultiArray{
	//정수형 2차원 배열 8*9
//	int [][] arr = new int [][] {
//		{1,3,4},
//		{2,4,6,8,10},
//		{2}
//	};
	
	int [][] arr = new int [8][9];
		
	//메소드이름 :array99
		
		//for loop 를 사용하여 
		//배열에 곱한 (구구단)결과저장
		//배열에 결과를 꺼내출력
	
	public void array99() {
//		for(int i=2; i<10; i++) {  
//			for(int j=1; j<10; j++) {
//				System.out.println(i+" X "+j+" = "+i*j);
//			}
//			System.out.println();	
//		}
		
		for(int row=0; row<arr.length; row++) {
			for(int col=0; col < arr[row].length; col++) {
				//값 변경
				arr[row][col] = (row+2) * (col+1);
				System.out.print(arr[row][col]+" ");
			}
			System.out.println();
		}
		
		System.out.println("---개선된 for문 ----");
		for(int[] row :arr) {
			for(int v :row) {
				System.out.print(v+" ");
			}
			System.out.println();
		}
	}
}

	public class MemoryApart{
	//main메소드에서 
	//MultiArray객체의 array99메소드호출
		public static void main(String[] args) {
			new MultiArray().array99();
		}
		
	}
