package ex0309.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ex0309.db.util.DbManager;

public class EmpDAO {
	/**
	 * 모든 사원의 이름 검색하기 
	 */
	public void getSelectNames() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
				//로드 연결 실행 닫기 
				con = DbManager.getConnection();
				
				st = con.createStatement();
				rs = st.executeQuery("select ename from emp");
				while(rs.next()) {
					//열을 조회
					String ename = rs.getString(1);
					System.out.println(ename);
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbManager.dbClose(con, st, rs);
		}
	}
}
