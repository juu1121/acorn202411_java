package test.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainClass12 {
	public static void main(String[] args) {
		//필요한 객체의 참조값을 담을 변수를 미리 만들어둔다.
		FileInputStream fis = null; //밖에서 선언한이유  :fis.close에서 참조못해서!
		FileOutputStream fos = null;
		
		try {
			//파일로부터 byte알갱이를 읽어들일 객체생성
			fis = new FileInputStream("C:\\Users\\acorn\\Desktop\\playground\\myFolder\\1.jpg");
			//byte 알갱이를 파일에 출력할 객체생성
			fos = new FileOutputStream("C:\\Users\\acorn\\Desktop\\playground\\myFolder\\copied.jpg");
			
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
		}finally {
			try {
				//마무리작업
				if(fos!=null)fos.close(); //Exception 발생을 막기위해...null을 체크하는것!//null이면 참조값이 안 담기니까 닫고 뭐 할게없음
				if(fos!=null)fis.close();
			}  catch (Exception e) { }
			
		}
	}
}
