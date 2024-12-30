package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import test.Util.DBConnector;
import test.dto.MemberDto;

public class MainClass13 {
	public static void main(String[] args) {
		int num = 1;

		// 미리 준비된 메소드를 호출하면서 회원정보를 전달하고 해당하는 회원정보를 리턴받는다.
		MemberDto dto = getData(num);
		
		if (dto != null) {
			System.out.printf("번호:%d, 이름:%s, 주소:%s", dto.getNum(), dto.getName(), dto.getAddr());
		} else {
			System.out.printf(" %d 회원의 정보는 존재하지않습니다", num);
		}

	}

	/*
	 * 매개변수로 전달되는 번호에 해당하는 회원정보를 select해서 MemberDto객체에 담아서 리턴해주는 메소드
	 */
	public static MemberDto getData(int num) {
		MemberDto dto = null;

		// 필요한 객체를 담을 지역변수 미리 만들기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// Connection 객체의 참조값얻어내기
			conn = new DBConnector().getConn();
			// 실행할 미완성의 sql문
			String sql = """
					SELECT name, addr
					FROM member
					WHERE num =?
					""";
			// 미완성의 sql문을 전달하면서 PreparedStatement객체의 참조값얻어내기
			pstmt = conn.prepareStatement(sql);
			// ?에 값 바인딩하기
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			// 만일select된 row가 있다면
			while (rs.next()) {
				// MemberDto 객체를 생성해서
				dto = new MemberDto();
				// select된 정보를 담는다.
				dto.setNum(num);
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));

				// num = rs.getInt("num");
				// String name = rs.getString("name");
				// String addr = rs.getString("addr");

			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return dto;
	}
}
