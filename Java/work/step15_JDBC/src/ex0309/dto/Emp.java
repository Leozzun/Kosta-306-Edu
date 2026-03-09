package ex0309.dto;

public class Emp {
	private int empno;
	private String ename;
	private int sal;
	private String hiredata;
	
	public Emp() {}
	
	
	public Emp(int empno, String ename, int sal, String hiredata) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.sal = sal;
		this.hiredata = hiredata;
	}



	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public String getHiredata() {
		return hiredata;
	}

	public void setHiredata(String hiredata) {
		this.hiredata = hiredata;
	}

	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", sal=" + sal + ", hiredata=" + hiredata + "]";
	}
	
	
}
