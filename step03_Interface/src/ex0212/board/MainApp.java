package ex0212.board;

public class MainApp {
	//필드를 이용한 다형성 
	BoardService service; //UploadServiceImpl or FreeServiceImpl or QaBoardServiceImpl
	Board board; // FreeBoard or QaBoard or UploadBoardß
	
	public MainApp() {
		service = new FreeBoardServiceImpl();
		board = new FreeBoard(10, "제목", "작성자", "내용");
		test(service, board);
		
		service = new QaBoardServiceImpl();
		board = new QaBoard(200, "qa제목", "qa작성자", "qa내용", false);
		test(service, board);
		
		service = new UploadBoardServiceImpl();
		board = new UploadBoard(300, "up제목", "up작성자", "up내용", "b.txt");
		test(service, board);
		
	}
	
	//매개변수를 이용한 다형성 
	public void test(BoardService service, Board board) {
		service.insert(board);
		service.update(board);
		service.selectByNo(5);
		
		//default 메소드 호출
		service.delete(5);
		
		//static 메소드 호출 
		BoardService.selectAll();
		
		System.out.println("=====================");
	}

	public static void main(String[] args) {
		new MainApp();

	}

}
