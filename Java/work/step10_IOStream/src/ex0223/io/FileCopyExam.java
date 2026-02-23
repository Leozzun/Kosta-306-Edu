package ex0223.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

public class FileCopyExam {
	
	public FileCopyExam(String readFile, String writeFile) {
		
		long start = System.nanoTime();
		
		//readFile에 있는 내용을 읽어서 writeFile에 저장한다. Buffered 사용한다.
		try {
			FileInputStream fis = new FileInputStream(readFile);
			FileOutputStream fos = new FileOutputStream(writeFile);
	        BufferedInputStream bis = new BufferedInputStream(fis);
	        BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			int i = 0;
			
			while((i = bis.read()) != -1) {
				bos.write(i); //저장 = 쓰기 
			}
			bos.flush(); // 버퍼를 비워라
			System.out.println("파일 복사 완료!");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		long end  = System.nanoTime();
		
		System.out.println( (end-start) +"ns");
	}

	public static void main(String[] args) {
		String readFile = JOptionPane.showInputDialog("읽을 파일명?");
		String writeFile = JOptionPane.showInputDialog("저장 할 파일명?");
		
		new FileCopyExam(readFile, writeFile);

	}

}
