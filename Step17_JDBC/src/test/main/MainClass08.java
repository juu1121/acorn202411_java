package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.Util.DBConnector;
import test.dto.DeptDto;
import test.dto.EmpDto;

public class MainClass08 {
	public static void main(String[] args) {
		List<DeptDto> list = getList();
		for (DeptDto tmp : list) {
			System.out.printf("부서번호:%d, 부서명:%s, 부서위치:%s", tmp.getDeptno(), tmp.getDname(), tmp.getLoc());
			System.out.println();
		}
	}

	// 아래의 메소드를 완성해보세요
	public static List<DeptDto> getList() {
		// 리턴해줄 객체를 미리 생성하기
		List<DeptDto> list = new ArrayList<>();

		// 여기에 어떻게 코딩하면 회원목록(List<EmpDto>)를 리턴해줄수있을까? 코딩해보세요
		// 필요한 객체를 담을 지역변수 미리 준비
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 우리가 설계한 클래스로 객체생성후 Connection 객체 얻어내기
			conn = new DBConnector().getConn();
			String sql = """
					SELECT deptno, dname, loc
					FROM dept
					""";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				// 부서정보를 담을 DeptDto객체를 생성해서
				DeptDto dto = new DeptDto();
				//부서하나의 정보를담고
				dto.setDeptno(rs.getInt("deptno"));
				dto.setDname(rs.getString("dname"));
				dto.setLoc(rs.getString("loc"));
				
				// 회원 한명의 정보가 담긴 EmpDto객체를 ArrayList객체에 누적시킨다.
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list; // 누적된 List<MemberDto>가 리턴

	}
}
