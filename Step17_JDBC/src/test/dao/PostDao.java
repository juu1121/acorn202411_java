package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.Util.DBConnector;
import test.dto.MemberDto;
import test.dto.PostDto;

/*
 * 2. PostDto를 활용한 PostDao 클래스를 test.dao패키지에 만들어보세요
 * insert(), update(), delete(). getData(), getList()메소드 존재해야함
 */
public class PostDao {
	//insert(매개 변수에 전달된 PostDto 객체에 담긴 회원 한명의 정보를 DB 에 저장하는 메소드)
	public boolean insert(PostDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			conn = new DBConnector().getConn();
			//실행할 sql 문
			String sql = """
					INSERT INTO posts
					(id, title, content)
					VALUES(posts_seq.NEXTVAL, ?, ?)
					""";
			pstmt = conn.prepareStatement(sql);
			// ? 에 값 바인딩
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			//sql 문 실행
			rowCount = pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (pstmt != null) 	pstmt.close();
				if (conn != null) 	conn.close();
			} catch (Exception e) { }
		}
		if (rowCount > 0) {
			return true;
		} else {
			return false;
		}
	}
	//delete(매개변수에 전달된 번호에 해당하는 회원 한명의 정보를 삭제하는 메소드)
	public boolean delete(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			conn = new DBConnector().getConn();
			//실행할 sql 문
			String sql = """
					DELETE FROM posts
					WHERE id = ?
					""";
			pstmt = conn.prepareStatement(sql);
			// ? 에 값 바인딩
			pstmt.setInt(1, id);
			//sql 문 실행
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
	//update(매개 변수에 전달된 PostDto 객체에 담긴 회원 한명의 정보를 수정하는 메소드)
	public boolean update(PostDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			conn = new DBConnector().getConn();
			//실행할 sql 문
			String sql = """
					UPDATE posts
					SET title =?, content=?
					WHERE id = ?
					""";
			pstmt = conn.prepareStatement(sql);
			// ? 에 값 바인딩
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setInt(3, dto.getId());
			//sql 문 실행
			rowCount = pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (pstmt != null)	pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) { 	}
		}
		if (rowCount > 0) {
			return true;
		} else {
			return false;
		}
	}
	//getList(전체 회원 목록을 리턴하는 메소드)
	public List<PostDto> getList(){
		List<PostDto> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = new DBConnector().getConn();
			String sql = """
					SELECT id, title, content
					FROM posts
					""";
			pstmt = conn.prepareStatement(sql);
			//? 에 값 바인딩 할게 있으면 여기서 한다.

			//select 문 실행하고 결과를 ResultSet 객체로 리턴받기
			rs = pstmt.executeQuery();
			while (rs.next()) {
				PostDto dto = new PostDto();
				dto.setId(rs.getInt("id"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				list.add(dto);
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
		return list;
	}
	//getdata(매개변수에 전달된 번호에 해당하는 회원 한명의 정보를 리턴하는 메소드)
	public PostDto getData(int id) {
		PostDto dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = new DBConnector().getConn();
			String sql = """
					SELECT title, content
					FROM posts
					WHERE id = ?
					""";
			pstmt = conn.prepareStatement(sql);
			//? 에 값 바인딩 할게 있으면 여기서 한다.
			pstmt.setInt(1, id);
			//select 문 실행하고 결과를 ResultSet 객체로 리턴받기
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto=new PostDto();
				dto.setId(id);
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null)	pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) { }
		}
		return dto;
	}
	
}
