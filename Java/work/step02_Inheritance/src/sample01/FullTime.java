package sample01;

public class FullTime {

    private int empNo;
    private String eName;
    private String job;
    private int mgr;
    private String hiredate;
    private String deptName;
    private int salary;
    private int bonus;

    public FullTime() {}

    public FullTime(int empNo, String eName, String job,
                    int mgr, String hiredate,
                    String deptName, int salary, int bonus) {

        this.empNo = empNo;
        this.eName = eName;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.deptName = deptName;
        this.salary = salary;
        this.bonus = bonus;
    }

    public void message() {
        System.out.println(eName + "사원은 정규직입니다.");
    }

    @Override
    public String toString() {
        return empNo + " | " + eName + " | " + job + " | "
                + mgr + " | " + hiredate + " | "
                + deptName + " | " + salary + " | " + bonus;
    }
}
