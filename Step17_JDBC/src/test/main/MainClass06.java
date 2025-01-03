package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.Util.DBConnector;
import test.dto.MemberDto;

public class MainClass06 {
	public static void main(String[] args) {
		//회원목록을 아주쉽게 얻어낼수있다.
		List<MemberDto> list = getList();
		for (MemberDto tmp:list) {
			System.out.printf("번호:%d, 이름:%s, 주소:%s, \r\n",
					tmp.getNum(), tmp.getName(), tmp.getAddr());
		}
	}	
	
	
	//미리 준비되메소드가 있다고 가정하면
	public static List<MemberDto> getList(){
		
		//리턴해줄 객체를 미리 생성하기
		List<MemberDto> list = new ArrayList<>();
		
		
		//여기에 어떻게 코딩하면 회원목록(List<MemberDto>)를 리턴해줄수있을까? 코딩해보세요
		//필요한 객체를 담을 지역변수 미리 준비
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//우리가 설계한 클래스로 객체생성후 Connection 객체 얻어내기
			conn = new DBConnector().getConn();
			String sql = """
					SELECT num, name, addr
					FROM member
					ORDER BY num ASC
					""";
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				//select된 row 하나의 정보를 MemberDto 객체에 담는다.
				MemberDto dto = new MemberDto();
				dto.setNum(num);
				dto.setName(name);
				dto.setAddr(addr);
				//회원 한명의 정보가 담긴 MemberDto객체를 ArrayList객체에 누적시킨다.
				list.add(dto);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list; //누적된 List<MemberDto>가 리턴 
		
		
	}
}
