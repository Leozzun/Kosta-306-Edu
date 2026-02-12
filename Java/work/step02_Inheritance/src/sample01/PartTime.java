package sample01;

public class PartTime {

    private int empNo;
    private String eName;
    private String job;
    private int mgr;
    private String hiredate;
    private String deptName;
    private int timePay;

    public PartTime() {}

    public PartTime(int empNo, String eName, String job,
                    int mgr, String hiredate,
                    String deptName, int timePay) {

        this.empNo = empNo;
        this.eName = eName;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.deptName = deptName;
        this.timePay = timePay;
    }

    public void message() {
        System.out.println(eName + "사원은 비정규직입니다.");
    }

    @Override
    public String toString() {
        return empNo + " | " + eName + " | "
                + job + " | " + mgr + " | "
                + timePay;
    }
}
