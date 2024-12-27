package test.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainClass13 {
	public static void main(String[] args) {
		/*
		 * [ try - with -resources 문법]
		 * 
		 * null체크와 close()호출이 자동화됨!
		 */
		
		try ( 
			//파일로부터 byte알갱이를 읽어들일 객체생성
			var fis = new FileInputStream("C:\\Users\\acorn\\Desktop\\playground\\myFolder\\1.jpg");
			//byte 알갱이를 파일에 출력할 객체생성
			var fos = new FileOutputStream("C:\\Users\\acorn\\Desktop\\playground\\myFolder\\copied.jpg");
					
				) {
			//byte 알갱이 여러개를 한번에 담을 배열 미리 준비
			byte[] buffer = new byte[1024]; //1kb를 읽을수있는 배열의사이즈 준비
			
			//반복문 돌면서
			while(true) {
				//byte[] 배열을 전달해서 byte알갱이를 한번에1024개씩 읽어들인다
				int readedCount = fis.read(buffer); //읽어들인 갯수가 리턴
				System.out.println(readedCount+"byte를 읽었습니다.");
				if (readedCount == -1) break; //더이상 읽을 데이터가 없다면 반복문 탈출
				//byte[] 배열에 저장된 byte 알갱이를 0번 인덱스로부터 읽을 갯수만큼 출력하기
				fos.write(buffer, 0, readedCount); //0번 인덱스로부터 읽은만큼만 출력!
				//0번방에서부터 52개니까 = 51번방까지만 출력하라는것!
			}
			System.out.println("파일copy완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
