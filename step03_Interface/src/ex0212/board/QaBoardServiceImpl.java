package ex0212.board;
/**
 * QA게시판 비지니스 로직 담당 클래스 
 */

public class QaBoardServiceImpl implements BoardService {

	@Override
	public int insert(Board board) {
		System.out.println("qa = "+board);
		System.out.println("QaBoradServiceImpl의 insert call");
		return 1;
	}

	@Override
	public boolean update(Board board) {
		System.out.println("qa = "+board);
		System.out.println("QaBoradServiceImpl의 update call");
		return true;
	}

	@Override
	public Board selectByNo(int no) {
		System.out.println("QaBoradServiceImpl의 select call");
		return new QaBoard(10, "연습중", "ㅅㅂ", "재미없다", false);
	}

}
