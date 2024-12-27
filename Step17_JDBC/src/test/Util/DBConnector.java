package test.Util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {
	//Connection 객체를 리턴해주는 메소드
	public Connection getConn() {
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
			conn=DriverManager.getConnection(url, "scott", "TIGER"); //1.getConnection:커넥션의참조값을 뭐얻는 뭐 그늒낌
			//예외가 발생하지 않고 여기까지 실행순서가 내려오면 접속 성공이다.
			System.out.println("Oracle DB 접속 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;//2.1에서 conn의 커넥션객체의 참조값이 얻어짐.so, 그걸 리턴!!
	}
}