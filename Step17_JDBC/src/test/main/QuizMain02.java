package test.main;

import test.dao.PostDao;
import test.dto.PostDto;
//MainClass15
/*
 * update
 * PostDao객체 이용해서 , 1번회원의 제목,내용 변경하기!
 */
public class QuizMain02 {
	public static void main(String[] args) {
		PostDto dto = new PostDto();
		dto.setId(1);
		dto.setTitle("수정1");
		dto.setContent("제목1");
		
		PostDao dao = new PostDao();
		boolean isSuccess = dao.update(dto);
		
		if(isSuccess) {
			System.out.println("수정성공");
		}else {
			System.out.println("수정실패!");
		}
	}
}
