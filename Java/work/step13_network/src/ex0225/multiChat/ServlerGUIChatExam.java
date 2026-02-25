package ex0225.multiChat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ServlerGUIChatExam {
	Socket sk;
	List<ClientSkThread> list = new ArrayList<>();
	
	public ServlerGUIChatExam() {
		try (ServerSocket server = new ServerSocket(8002)){
			while(true) {
				System.out.println("Client 접속 대기중입니다...");
				sk = server.accept();
				
				System.out.println(sk.getInetAddress()+"님 접속하셨습니다.");
				
				ClientSkThread th = new ClientSkThread();
				th.start();
				list.add(th);
				
				System.out.println("현재 접속 인원 : " + list.size()+"명\n");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//생성자 끝 
	
	/**
	 * 접속한 클라이언트에게 메시지 전송하는 메소드 
	 */
	public void sendMessage(String message) {
		for(ClientSkThread th : list) {
			th.pw.println(message);
		}
	}
	
	class ClientSkThread extends Thread{
		PrintWriter pw;
		BufferedReader br;
		String nickName; //대화명
		
		ClientSkThread() {

			try {
				pw = new PrintWriter(sk.getOutputStream(), true);
				br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
			} catch (Exception e) {
			
				e.printStackTrace();
			}
		}
		
		public void run() {
			//클라이언트가 보내온 내용을 읽어서 접속한 모든 클라이언트에게 전송한다. 
			try {
				while(true) {
					String checkName = br.readLine();
					
					boolean isDuplicate = false;
					
					for(ClientSkThread th : list) {	
						if(checkName.equals(th.nickName)) {
							isDuplicate = true;
							break;
						} 
					}
					
					if(isDuplicate == true) {
						pw.println("닉네임 중복");
					} else {
						this.nickName = checkName; //대화명 저장
						sendMessage("["+nickName+"]님 입장하셨습니다.");
						break;
					}
				}
				
				while(true) {
					String inputData = br.readLine();
					sendMessage("["+nickName+"]" + inputData);
				}
				
			} catch(Exception e) {
				//e.printStackTrace();
				//현재 스레드에 문자가 생겼다
				//현재 스레드 list에서 제거
				list.remove(this);
				
				//남아있는 클라이언트에게 알린다. 
				sendMessage("["+nickName+"]님 퇴장하셨습니다.");
				
				//서버콘솔에 인원수 출력 
				System.out.println("["+nickName+"]님 퇴장 | 현재인원 = "+ list.size() + "명");
			}
		
		}
	}

	public static void main(String[] args) {
		new ServlerGUIChatExam();

	}

}
