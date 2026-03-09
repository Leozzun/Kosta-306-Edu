package ex0309.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ex0309.util.DbManager;
import ex0309.vo.Room;
import ex0309.vo.Student;
import ex0309.vo.Subject;
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
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		String sql = "select * from teacher where teacher_address like ?";
		List<Teacher> teacherList = new ArrayList<Teacher>();
		try {
				//로드 연결 실행 닫기 
				con = DbManager.getConnection();
				ps = con.prepareStatement(sql);
				
				ps.setString(1, "%"+gu+"%");
				
				rs = ps.executeQuery();
			
				while(rs.next()) {
					int teacherNo= rs.getInt("teacher_code");
					String teacherName = rs.getString("teacher_name");
					String teacherJumin = rs.getString("teacher_resident_number");
					String teacherPhone = rs.getString("teacher_phone");
					String teacherAddr = rs.getString("teacher_address");
					String teacherEmail = rs.getString("teacher_email");
					String sugangCode = rs.getString("subject_code");
					Teacher te = new Teacher(teacherNo, teacherName, teacherJumin, teacherPhone, teacherAddr, teacherEmail, sugangCode);
					teacherList.add(te);
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbManager.dbClose(con, ps, rs);
		}
		
		return teacherList;
	}

	@Override
	public Teacher getTeacherInfoBySubject(String subject) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		String sql = "select * from teacher where subject_code in (select subject_code from subject where subject_name = ?)";
		Teacher teacher = null;
		try {
				//로드 연결 실행 닫기 
				con = DbManager.getConnection();
				ps = con.prepareStatement(sql);
				
				ps.setString(1, subject);
				
				rs = ps.executeQuery();
			
				// 조건식 쿼리는 if문을 사용한다. while 써도됨 
				if(rs.next()) {
					int teacherNo= rs.getInt("teacher_code");
					String teacherName = rs.getString("teacher_name");
					String teacherJumin = rs.getString("teacher_resident_number");
					String teacherPhone = rs.getString("teacher_phone");
					String teacherAddr = rs.getString("teacher_address");
					String teacherEmail = rs.getString("teacher_email");
					String sugangCode = rs.getString("subject_code");
					
					teacher = new Teacher(teacherNo, teacherName, teacherJumin, teacherPhone, teacherAddr, teacherEmail, sugangCode);
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbManager.dbClose(con, ps, rs);
		}
		
		return teacher;
	}

	@Override
	public Teacher getTeacherInfoByNo(int teacherNo) {
		Connection con = null;
		PreparedStatement ps = null;
		int vw = 0;
		ResultSet rs = null;
	
		String sql = "create or replace view v_tear"
				+ "	as select t.teacher_code, t.teacher_name, "
				+ "		s.subject_code, s.subject_name, r.room_code, r.room_max_count"
				+ "		from sugangtb sg join teacher t using(teacher_code) "
				+ "						join subject s on s.subject_code = sg.subject_code"
				+ "						join room r using(room_code)";
		
		String sql2 = "select * from v_tear where teacher_code = ?"; 
		
		Subject subject = null;
		Room room = null;
		Teacher teacher = null;
		try {
				//로드 연결 실행 닫기 
				con = DbManager.getConnection();
				ps = con.prepareStatement(sql);
				
				vw = ps.executeUpdate();
				
				ps = con.prepareStatement(sql2);
				
				ps.setInt(1, teacherNo);
				
				rs = ps.executeQuery();
			
				// 조건식 쿼리는 if문을 사용한다. while 써도됨 
				if(rs.next()) {
					teacherNo= rs.getInt("teacher_code");
					String teacherName = rs.getString("teacher_name");
					String sugangCode = rs.getString("subject_code");
					String subjectName = rs.getString("subject_name");
					int roomNo = rs.getInt("room_code");
					int roomCount = rs.getInt("room_max_count");
					
					subject = new Subject(sugangCode, subjectName);
					room = new Room(roomNo, roomCount);
					teacher = new Teacher();
					
					teacher.setTeacherNo(teacherNo);
					teacher.setTeacherName(teacherName);
					teacher.setSubject(subject);
					teacher.setRoom(room);
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbManager.dbClose(con, ps, rs);
		}
		
		return teacher;
	}

}
