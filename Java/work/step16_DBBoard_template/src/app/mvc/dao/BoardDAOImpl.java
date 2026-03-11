package app.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.mvc.common.DBManager;
import app.mvc.dto.BoardDTO;
import app.mvc.dto.ReplyDTO;
import app.mvc.exception.DMLException;
import app.mvc.exception.SearchWrongException;

public class BoardDAOImpl implements BoardDAO {
	
	private static BoardDAO instance = new BoardDAOImpl();
	
	private BoardDAOImpl() {}
	
	public static BoardDAO getInstance() {
		return instance;
	}
	

	@Override
	public List<BoardDTO> boardSelectAll() throws SearchWrongException {
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		List<BoardDTO> list = new ArrayList<>();
		String sql="select * from board order by board_no desc";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BoardDTO board = new BoardDTO(
					rs.getInt("board_no"),
					rs.getString("subject"),
					rs.getString("writer"),
					rs.getString("content"),
					rs.getString("board_date")
				);
				
				list.add(board);
			}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new SearchWrongException("DB에 문제가 있어 다시 진행해주세요^^");
			
		}finally {
			DBManager.releaseConnection(con, ps, rs);
		}			
				
		
		return list;
	}

	@Override
	public List<BoardDTO> boardSelectBySubject(String keyWord) throws SearchWrongException {
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		List<BoardDTO> list = new ArrayList<>();
		String sql="select * from board where subject like ?";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, "%"+keyWord+"%");
			
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				int boardNo= rs.getInt("board_no");
				String subject = rs.getString("subject");
				String writer = rs.getString("writer");
				String content = rs.getString("content");
				String boardDate = rs.getString("board_date");
				BoardDTO board = new BoardDTO(boardNo, subject, writer, content, boardDate);
				list.add(board);
			}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new SearchWrongException("DB에 문제가 있어 다시 진행해주세요^^");
			
		}finally {
			DBManager.releaseConnection(con, ps, rs);
		}			
				
		
		return list;
	}

	@Override
	public BoardDTO boardSelectByNo(int boardNo) throws SearchWrongException {
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		BoardDTO boardDTO = null;
		String sql="select * from board where board_no = ?";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, boardNo);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				boardNo= rs.getInt("board_no");
				String subject = rs.getString("subject");
				String writer = rs.getString("writer");
				String content = rs.getString("content");
				String boardDate = rs.getString("board_date");
				boardDTO = new BoardDTO(boardNo, subject, writer, content, boardDate);
			}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new SearchWrongException("DB에 문제가 있어 다시 진행해주세요^^");
			
		}finally {
			DBManager.releaseConnection(con, ps, rs);
		}			
				
		
		return boardDTO;
	}

	@Override
	public int boardInsert(BoardDTO boardDTO) throws DMLException {
		Connection con=null;
		PreparedStatement ps = null;
		int result = 0;
		
		String sql="insert into board (subject, writer, content, board_date) values (?, ?, ?, now())";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, boardDTO.getSubject());
			ps.setString(2, boardDTO.getWriter());
			ps.setString(3, boardDTO.getContent());
			
			result = ps.executeUpdate();
			
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DMLException("DB에 문제가 있어 다시 진행해주세요^^");
			
		}finally {
			DBManager.releaseConnection(con, ps);
		}
		
		return result;			
				
	}

	@Override
	public int boardUpdate(BoardDTO boardDTO) throws DMLException {
		Connection con=null;
		PreparedStatement ps = null;
		int result = 0;
		
		String sql="update board set content = ? where board_no = ?";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, boardDTO.getContent());
			ps.setInt(2, boardDTO.getBoardNo());
			
			result = ps.executeUpdate();
			
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DMLException("정보를 수정하는데 장애가 발생했습니다.");
			
		}finally {
			DBManager.releaseConnection(con, ps);
		}
		
		return result;			
	}

	@Override
	public int boardDelete(int boardNo) throws DMLException {
		Connection con=null;
		PreparedStatement ps = null;
		int result = 0;
		
		String sql="delete from board where board_no = ?";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, boardNo);
			
			result = ps.executeUpdate();
			
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DMLException("DB에 문제가 있어 다시 진행해주세요^^");
			
		}finally {
			DBManager.releaseConnection(con, ps);
		}
		
		return result;			
	}

	@Override
	public int replyInsert(ReplyDTO replyDTO) throws DMLException {
		Connection con=null;
		PreparedStatement ps = null;
		int result = 0;
		
		String sql="insert into reply (reply_content, board_no, reply_regdate) values (?, ?, now())";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, replyDTO.getReplyContent());
			ps.setInt(2, replyDTO.getBoardNo());
			
			result = ps.executeUpdate();
			
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DMLException("DB에 문제가 있어 다시 진행해주세요^^");
			
		}finally {
			DBManager.releaseConnection(con, ps);
		}
		
		return result;			
				
	}

	@Override
	public BoardDTO replySelectByParentNo(int boardNo) throws SearchWrongException {
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs =null;

		BoardDTO boardDTO = null;
		String sql="select * from board where board_no= ?";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, boardNo);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				//열의 정보를 가져와서 BoardDTO에 담는다.
				boardDTO = new BoardDTO(rs.getInt(1), rs.getString(2),rs.getString(3), 
						rs.getString(4), rs.getString(5));
				
				//댓글번호를 검색한다.
				List<ReplyDTO> replyList = this.replySelect(con, boardNo);
				boardDTO.setRepliesList(replyList);
			}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new SearchWrongException("DB에 문제가 있어 다시 진행해주세요^^");
			
		}finally {
			DBManager.releaseConnection(con, ps, rs);
		}			
				
		
		return boardDTO;
	}
	
	
	/***
	 * 부모글에 해당하는 댓글정보 가져오기
	 * */
	private List<ReplyDTO> replySelect(Connection con ,int boardNo)throws SQLException{
		PreparedStatement ps =null;
		 ResultSet rs =null;
		 List<ReplyDTO> repliesList = new ArrayList<>();
		 String sql="select * from reply where board_no=?";
		try {
		    ps = con.prepareStatement(sql);
		    ps.setInt(1, boardNo);
		    
		    rs = ps.executeQuery();
		    while(rs.next()) {
		    	ReplyDTO reply = 
		    		new ReplyDTO(rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getString(4));
		    	repliesList.add(reply);
		    }
		
		}finally {
			DBManager.releaseConnection(null, ps, rs); 
		}
		return repliesList;
	}

}













