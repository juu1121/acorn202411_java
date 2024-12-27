package test.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainClass11 {
	public static void main(String[] args) {
		try {
			//파일로부터 byte알갱이를 읽어들일 객체생성
			var fis = new FileInputStream("C:\\Users\\acorn\\Desktop\\playground\\myFolder\\1.jpg");
			//byte 알갱이를 파일에 출력할 객체생성
			var fos = new FileOutputStream("C:\\Users\\acorn\\Desktop\\playground\\myFolder\\copied.jpg");
			//반복문 돌면서
			while(true) {
				//1byte 읽어들여서
				int readedByte = fis.read();
				System.out.println(readedByte);
				//만일 더이상 읽을 byte가 없다면 반복문 탈출
				if(readedByte == -1) break; // if문다음에 실행할 코드가 한줄이면 {}로 안 묶어도 된다.
				//읽어들인 1byte 출력
				fos.write(readedByte); //(읽어들인1byte)를 write로 출력...fos할때 출력할 파일 객체생성(=연결)
				fos.flush(); //방출
			}
			System.out.println("파일copy완료");
			//마무리작업
			fos.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
