package test.main;

import test.dao.MemberDao;

public class MainClass16 {
	public static void main(String[] args) {
		/*
		 * MemberDao객체를 이용해서 1번회원의 정보를 삭제해보세요
		 * 단) 성공여부를 콘솔창에 출력하세요
		 */
		
		//MemberDao dao= new MemberDao();
		//boolean isSuccess = dao.delete(1);
		var dao= new MemberDao();
		var isSuccess = dao.delete(1); //리턴타입을 알고있기때문에 타입추론이 가능 = var
		
		if(isSuccess) {
			System.out.println("삭제성공");
		}else {
			System.out.println("삭제실패!");
		}
	}
}
