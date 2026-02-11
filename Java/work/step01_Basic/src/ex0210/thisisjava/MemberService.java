package ex0210.thisisjava;

public class MemberService {
	public static void main(String[] args) {
		MemberService memberService = new MemberService();
		boolean result = memberService.login("hong", "12345");
		if(result) {
			System.out.println("로그인 되었습니다.");
			memberService.logout("hong");
		} else {
			System.out.println("id 또는 password가 올바르지 않습니다.");
		}
	}
	
	public boolean login(String id, String password) {
		if(id == "hong" && password == "12345") {
			return true;
		} else {
			return false;
		}
		
//		if("hong".equals(id) && "12345".equals(password)) {
//			
//		}
	}
	
	public void logout(String id) {
		System.out.println(id + "님이 로그아웃 되었습니다");
	}
}
