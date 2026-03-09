package ex0309.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ex0309.util.DbManager;
import ex0309.vo.Student;
import ex0309.vo.Teacher;

public class StudentTeacherDAOImpl implements StudentTeacherDAO {

	@Override
	public List<Student> getGenderByWomen() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		String sql = "select * from student where student_resident_number like '%-2%'";
		List<Student> list = new ArrayList<Student>();
		try {
				//로드 연결 실행 닫기 
				con = DbManager.getConnection();
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
			
				while(rs.next()) {
					int studentNo= rs.getInt("student_code");
					String studentName = rs.getString("student_name");
					String studentJumin = rs.getString("student_resident_number");
					String studentPhone = rs.getString("student_phone");
					String studentAddr = rs.getString("student_address");
					String studentEmail = rs.getString("student_email");
					Student st = new Student(studentNo, studentName, studentJumin,studentPhone, studentAddr, studentEmail);
					list.add(st);
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbManager.dbClose(con, ps, rs);
		}
		
		return list;
	}

	@Override
	public List<Teacher> getTeacherInfoByAddr(String gu) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Teacher getTeacherInfoBySubject(String subject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Teacher getTeacherInfoByNo(int teacherNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
