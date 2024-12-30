package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import test.Util.DBConnector;

public class MainClass12 {
	public static void main(String[] args) {
		// 삭제할 회원의 정보라고 가정하자
		int num = 4;
		
		// 미리 준비된 메소드를 이용해서 수정반영하고 성공여부까지 리턴받기
		boolean isSuccess = delete(num);
		if (isSuccess) {
			System.out.println("회원정보삭제");
		} else {
			System.out.println("삭제실패!");
		}
	}

	// 매개변수로 전달되는 회원의 번호를 이용해서 회원한명의 정보를 삭제하고 성공여부를 리턴하는 메소드
	public static boolean delete(int num) {
		// 필요한 객체를 담을 지역변수 미리 만들기
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 변화된 row의 갯수를 저장할 변수를 0을 대입해서 미리 만들어둔다.
		int rowCount = 0;
		try {
			// Connection 객체의 참조값얻어내기
			conn = new DBConnector().getConn();
			// 실행할 미완성의 sql문
			String sql = """
					DELETE FROM member
					WHERE num =?
					""";
			// 미완성의 sql문을 전달하면서 PreparedStatement객체의 참조값얻어내기
			pstmt = conn.prepareStatement(sql);
			// ?에 값 바인딩하기
			pstmt.setInt(1, num);
			// sql문 실행하고 추가(insert)되거나, 변경(update)되거나, 삭제(delete)된 row의 갯수리턴
			rowCount = pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		// rowCount 변수에 들어있는 값을 확인해서 작업의 성공여부를 리턴해준다.
		if (rowCount > 0) {
			return true;
		} else {
			return false;
		}
	}
}