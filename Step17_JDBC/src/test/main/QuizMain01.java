package test.main;

import java.util.Scanner;

import test.dao.PostDao;
import test.dto.PostDto;
/*
 * insert
 * 입력한 제목과내용을 DB에 저장하는 프로그래밍
 */
//mainClass14
public class QuizMain01 {
	public static void main(String[] args) {
		// title과 content를 Scanner 객체로 입력받아서 DB에 저장하는 프로그래밍하기
		Scanner scan = new Scanner(System.in);
		System.out.println("제목 입력: ");
		String title = scan.nextLine();
		System.out.println("내용 입력:");
		String content = scan.nextLine();
		
		// 입력한 제목과 내용를 PostDto객체에 담기
		PostDto dto = new PostDto();
		dto.setTitle(title);;
		dto.setContent(content);

		PostDao dao = new PostDao();
		boolean isSuccess = dao.insert(dto);
		if (isSuccess) {
			System.out.printf("%s 제목이 저장되었습니다.", title);
		} else {
			System.out.println("저장실패!");
		}
	}
}
