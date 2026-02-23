package ex0223.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class BufferedReaderWriterExam {
	
	public BufferedReaderWriterExam() {
		try(BufferedReader br = new BufferedReader(new FileReader("src/ex0223/io/test"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("src/ex0223/io/hhh"))) {
			
			//한 문자 읽기 (문자 코드값으로 나옴)
//			int i = br.read();
//			System.out.println(i);
			
			//한 문자 읽기 (코드값 문자로 변환)
//			int i = 0;
//			while((i = br.read()) != -1) {
//				System.out.println(i +" = " + (char)i);
//			}
			
			//한 줄 읽기 
			String data = null;
			while((data = br.readLine()) != null) {
				System.out.println(data);
				bw.write(data);
				bw.newLine();
				bw.flush();
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new BufferedReaderWriterExam();

	}

}
