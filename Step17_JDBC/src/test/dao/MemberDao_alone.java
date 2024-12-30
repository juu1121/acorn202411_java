package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.Util.DBConnector;
import test.dto.EmpDto;
import test.dto.MemberDto;

/*
 * 회원정보를 insert, update, delete, select 할 수 있는 기능을 가진 객체를 생성할 클래스 설계하기
 * - 이런 기능을 가진 객체를 Data Access Object(DAO)라고 한다 
 */
public class MemberDao_alone {
	// 매개변수에 전달된 MemberDto객체에 담긴 회원한명의 정보를 DB에 저장하는 메소드
	public boolean insert(MemberDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			conn = new DBConnector().getConn();
			//실행할  sql문
			String sql = """
					INSERT INTO member
					(num, name, addr)
					VALUES(member_seq.NEXTVAL, ?, ?)
					""";
			pstmt = conn.prepareStatement(sql);
			//?에 값 바인딩
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			//sql문 실행
			rowCount = pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) { }
		}
		if (rowCount > 0) {
			return true;
		} else {
			return false;
		}
	}

	// 매개변수에 전달된 번호에 해당하는 회원한명의 정보를 삭제하는 메소드
	public boolean delete(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			conn = new DBConnector().getConn();
			String sql = """
					DELETE FROM member
					WHERE num =?
					""";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rowCount = pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
			}
		}
		if (rowCount > 0) {
			return true;
		} else {
			return false;
		}
	}

	// 매개변수에 전달된 MemberDto 객체에 담긴 회원 한명의 정보를 수정하는 메소드
	public boolean update(MemberDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			conn = new DBConnector().getConn();
			String sql = """
					UPDATE member
					set name =?, addr=?
					WHERE num =?
					""";
			pstmt = conn.prepareStatement(sql);
			// ?에 값 바인딩하기
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			pstmt.setInt(3, dto.getNum());
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
		if (rowCount > 0) {
			return true;
		} else {
			return false;
		}
	}

	// 전체 회원 목록을 리턴하는 메소드
	public List<MemberDto> getList() {
		// 리턴해줄 객체를 미리 생성하기
		List<MemberDto> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 우리가 설계한 클래스로 객체생성후 Connection 객체 얻어내기
			conn = new DBConnector().getConn();
			String sql = """
					SELECT num, name, addr
					FROM member
					""";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				// ResultSet 객체로부터 사원한명의 정보를 추출했다.
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String addr = rs.getString("addr");

				// select된 row 하나의 정보를 EmpDto 객체에 담는다.
				MemberDto dto = new MemberDto();
				dto.setNum(num);
				dto.setName(name);
				dto.setAddr(addr);
				// 회원 한명의 정보가 담긴 EmpDto객체를 ArrayList객체에 누적시킨다.
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list; // 누적된 List<MemberDto>가 리턴
	}

	// 매개변수에 전달된 번호에 해당하는 회원 한명의 정보를 리턴하는 메소드
	public MemberDto getData(int num) {
		MemberDto dto = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = new DBConnector().getConn();
			String sql = """
					SELECT name, addr
					FROM member
					WHERE num =?
					""";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto = new MemberDto();
				dto.setNum(num);
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
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
