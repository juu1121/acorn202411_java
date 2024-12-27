package test.alone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Quizsum2 {
	public static void main(String[] args) {
		/*
		 * java로 oracle에 scott/TIGER 계정으로 접속해서
		 * 모든 사원의 사원번호, 사원이름, 직업, 급여를 사원이름으로 내림차순 정렬해서 SELECT한 다음
		 * 콘솔창에 출력하기
		 * 
		 * ->런했을때 모든사원정보가 콘솔창에 출력하게하겠다는거.
		 * 일괄임폴트: ctrl+shift+O
		 */
		//DB 연결객체를 담을 지역 변수 만들기
		Connection conn=null; //DB연결하려고준비
		//Connection객체를 이용해서 필요한객체를파생(InputStream..그들처럼)
		
		//Connection객체를 얻어오기위한 코딩
		try {
			//오라클 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver"); //쓸라고
			//접속할 DB 의 정보 @아이피주소:port번호:db이름
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			//계정 비밀번호를 이용해서 Connection 객체의 참조값 얻어오기
			conn=DriverManager.getConnection(url, "scott", "TIGER");
			//예외가 발생하지 않고 여기까지 실행순서가 내려오면 접속 성공이다.
			System.out.println("Oracle DB 접속 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
		//SELECT 작업을 위해서 필요한 객체의 참조값을 담을 지역변수 미리 만들기
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs2 = null;
		try {
			String sql = """
					SELECT deptno, dname, loc
					FROM dept
					""";
			String sql2 = """
					SELECT empno, ename, emp.deptno, dname
					FROM emp, dept
					WHERE emp.deptno = dept.deptno	
					ORDER BY empno DESC
					""";
			
			pstmt = conn.prepareStatement(sql);
			pstmt2 = conn.prepareStatement(sql2);
			
			rs=pstmt.executeQuery(); 
			rs2=pstmt2.executeQuery(); 
			
			while(rs.next()) { 
				int deptno = rs.getInt("deptno"); 
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				System.out.println("Q1 "+deptno+"|"+dname+"|"+loc);
			}
			while(rs2.next()) { 
				int empno2 = rs2.getInt("empno"); 
				String ename2 = rs2.getString("ename");
				int deptno2 = rs2.getInt("deptno"); 
				String dname2 = rs2.getString("dname");
				System.out.println("Q2 "+empno2+"|"+ename2+"|"+deptno2+"|"+dname2);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
