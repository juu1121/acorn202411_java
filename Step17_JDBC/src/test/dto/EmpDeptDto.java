package test.dto;

public class EmpDeptDto {
	private int empno;
	private String ename;
	private int deptno;
	private String dname;
	
	//디폴트생성자 없어도 있다고간주~
	//public EmpDeptDto() {} 

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

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}
	

}
