package test.main;

import java.util.Scanner;

import test.dao.PostDao;
import test.dto.PostDto;

/*
 * MainClass17
 * 
 * Scanner 객체를 이용해서 불러올 id를 입력받은 다음
 * 입력한 번호에 해당하는 id의 posts를 PostDao 객체를 이용해서 얻어온다음
 * 해당 id가  존재하면 해당posts를 콘솔에 출력하고
 * 존재하지 않으면 "해당 x의 posts는 존재하지 않습니다"를 콘솔창에 출력하는 프로그래밍을 해보세요.
 * .getData()
 * 
 */
public class QuizMain04 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("id입력: ");
		int id = scan.nextInt();
		
		PostDao dao = new PostDao();
		PostDto dto = dao.getData(id);
		
		if(dto != null) {
			System.out.printf("id: %d, 제목:%s, 내용:%s", dto.getId(), dto.getTitle(), dto.getContent());
		}else {
			System.out.printf("해당 %d의 posts는 존재하지않습니다.", id);
		}
	
	}
}
