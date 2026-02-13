package ex0212.board;

public class UploadBoardServiceImpl implements BoardService {

	@Override
	public int insert(Board board) {
		System.out.println("upload = "+board);
		System.out.println(super.getClass().getSimpleName() +"insert call");
		return 1;
	}

	@Override
	public boolean update(Board board) {
		System.out.println("upload = "+board);
		System.out.println(getClass().getSimpleName() +"update call");
		return true;
	}

	@Override
	public Board selectByNo(int no) {
		System.out.println(getClass().getSimpleName() +"select call");
		return new UploadBoard(30, "자료실연습", "하기싫어", "파일첨부", "a.jpg");
	}

}
