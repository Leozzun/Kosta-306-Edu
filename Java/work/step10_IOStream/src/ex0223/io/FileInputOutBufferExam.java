package ex0223.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileInputOutBufferExam {
	public FileInputOutBufferExam() {  //IO는 반드시 사용후 close()해야하다!!
		// byte단위 파일 읽기(inputStream -> FileInputStream)
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			fis = new FileInputStream("src/ex0223/io/test");
			bis = new BufferedInputStream(fis);
			
//			while(true) {
//				int i = fis.read(); // 1byte씩 읽기
//				if(i==-1) break;
//				System.out.println(i + " = " + (char)i);
//			}
			
			//byte배열의 크기만큼 읽기 
			int len = bis.available(); //읽을 수 있는 byte 수 
			System.out.println("len = " + len);
			
			//byte b [] = new byte [len];
			
			byte b [] = new byte [100];
			int re = 0;
			while( (re = bis.read(b) ) != -1 ) {
				System.out.println("re = " + re);
				
				//byte 배열을 -> String으로 변환
				String data = new String(b);
				System.out.println("data = " + data);
			}
			//파일에 저장=출력
			fos = new FileOutputStream("src/ex0223/io/write", true); //없으면 만들고 
			bos = new BufferedOutputStream(fos);
					
			bos.write(65);
			bos.write(66);
			
			bos.write(13);
			bos.write(10);
			
			bos.write(75);
			
			String str = "배고프다 뭐 먹지?";
			
			
			//String -> byte 배열
			bos.write(str.getBytes());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				//닫기 안에 껄 먼저 닫아야함 
				if(bis!=null) bis.close();
				if(bos!=null) bos.close();
				if(fis!=null) fis.close();
				if(fos!=null) fos.close();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new FileInputOutBufferExam();

	}

}
