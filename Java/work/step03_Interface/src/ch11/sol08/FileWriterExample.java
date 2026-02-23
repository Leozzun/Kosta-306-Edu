package ch11.sol08;

import java.io.IOException;

public class FileWriterExample {

	public static void main(String[] args) {
//		FileWriter fw = null;
//		try {
//			fw = new FileWriter("file.txt");
//			fw.write("Java");
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {fw.close();} catch
//				(IOException e) {}
//		}

		// 리소스 자동 닫기로 수정
		try(FileWriter fw = new FileWriter("file.txt")) {
			fw.write("Java");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
