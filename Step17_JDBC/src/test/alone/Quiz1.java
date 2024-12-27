package test.alone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Quiz1 {
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
		try {
			//실행할 sql문을 미리 준비하기 //java10부터 추가된 새로운 문자열만드는문법(더블따옴표3개 = 백틱이라고 생각 // + 세미콜론붙이면 안됨.)
			String sql = """
					SELECT deptno, dname, loc
					FROM dept
					""";
			//PreparedStatement 객체의 참조값 얻어오기(Connection을 통해 PreparedStatement 참조값얻어내기 )
			//prepareStatement SQL문을 대신실행해줌(insert, delete...)//실행할sql문을 알려줘야해서 ()에 전달!
			pstmt = conn.prepareStatement(sql);
			
			//SELECT문 실행하고 결과값을 ResultSet으로 얻어내기
			//select문 호출할때는 executeQuery()
			rs=pstmt.executeQuery();  //pstmt.executeQuery()의 리턴타입 = ResultSet //select의 실행결과를 rs에 담음
			//반복문 돌면서
			while(rs.next()) { //rs.next() =커서다음에 row가 있는지 확인하고, 있으면 true반환후 커서한칸내림!
				//커서를 내리다가 읽을 row가 없으면 false가 되면서 반복문 빠져나옴!
				
				//커서가 있는곳에서 칼럼의 getInt...를 반환하는 느낌
				int deptno = rs.getInt("deptno"); //칼럼명을 전달하되, 얘가 숫자면 Int를 호출하라는것!//컬럼의 타입을 알아야함..내가 getString로 하면 empno도 문자로 읽어옴
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				System.out.println(deptno+"|"+dname+"|"+loc);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
