package test.main;

import java.util.List;

import test.dao.PostDao;
import test.dto.PostDto;

/*
 * PostDao객체 이용해서 post를 얻어온다음
 * 반복문돌면서 출력
 * getlist
 */
public class QuizMain05 {
	public static void main(String[] args) {
		List<PostDto> list = new PostDao().getList();
		
		for (PostDto tmp:list) {
			System.out.printf("id:%d, 제목:%s, 내용:%s, \r\n", tmp.getId(), tmp.getTitle(), tmp.getContent());
		}
	}
}
