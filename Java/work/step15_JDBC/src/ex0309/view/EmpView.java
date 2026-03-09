package ex0309.view;

import ex0309.dao.EmpDAO;

public class EmpView {
	
	public static void main(String[] args) {
		System.out.println("---JDBC---");
		
		EmpDAO dao =  new EmpDAO();
		dao.getSelectNames();
		
	}

}
