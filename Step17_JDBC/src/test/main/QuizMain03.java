package test.main;

import test.dao.PostDao;

/*
 * mainClass16
 * PostDao객체를 이용해 1번회원의 정보삭제
 */
public class QuizMain03 {
	public static void main(String[] args) {
		PostDao dao = new PostDao();
		var isSuccess = dao.delete(1);
		
		if(isSuccess) {
			System.out.println("삭제성공");
		}else {
			System.out.println("삭제실패!");
		}
	}
}
