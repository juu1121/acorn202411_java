package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.Util.DBConnector;
import test.dto.FoodDto;

public class FoodDao {
	//insert
	public boolean insert(FoodDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowCount=0;
		try {
			conn=new DBConnector().getConn();
			
			String sql ="""
				INSERT INTO food
				(num, fname, addr)
				VALUES(food_seq.NEXTVAL, ?, ?)	
					""";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getFname());
			pstmt.setString(2, dto.getAddr());
			rowCount=pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		if(rowCount >0) {
			return true;
		}else {
			return false;
		}
	}
	//delete
	public boolean delete(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			conn = new DBConnector().getConn();
			//실행할 sql 문
			String sql = """
					DELETE FROM food
					WHERE num=?
					""";
			pstmt = conn.prepareStatement(sql);
			// ? 에 값 바인딩
			pstmt.setInt(1, num);
			//sql 문 실행
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
	
	//get list(전체정보)
	public List<FoodDto> getList(){
		List<FoodDto> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = new DBConnector().getConn();
			String sql = """
					SELECT num, fname, addr
					FROM food
					ORDER BY num ASC
					""";
			pstmt = conn.prepareStatement(sql);
			//? 에 값 바인딩 할게 있으면 여기서 한다.

			//select 문 실행하고 결과를 ResultSet 객체로 리턴받기
			rs = pstmt.executeQuery();
			while (rs.next()) {
				FoodDto dto = new FoodDto();
				dto.setNum(rs.getInt("num"));
				dto.setFname(rs.getString("fname"));
				dto.setAddr(rs.getString("addr"));
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

}
