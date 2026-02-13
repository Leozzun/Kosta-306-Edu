package ex0212.board;
/**
 * 자유게시판 비즈니스로직 담당 
 */

public class FreeBoardServiceImpl implements BoardService {

	@Override
	public int insert(Board board) {
		System.out.println("free = "+board);
		System.out.println(super.getClass().getSimpleName() +"insert call");
		return 1;
	}

	@Override
	public boolean update(Board board) {
		System.out.println("free = "+board);
		System.out.println(getClass().getSimpleName() +"update call");
		return true;
	}

	@Override
	public Board selectByNo(int no) {
		System.out.println(getClass().getSimpleName() +"select call");
		return new FreeBoard(20, "수업중", "그만", "제발");
	}
	
	@Override
	public int delete(int no) {
		System.out.println("free = "+no);
		System.out.println(super.getClass().getSimpleName() +"delete call");
		return 1;
	}

}
