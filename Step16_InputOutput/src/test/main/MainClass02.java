package test.main;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainClass02 {
	public static void main(String[] args) {
		System.out.println("main메소드가 시작되었습니다");
		//1byte 처리 스트림
		InputStream kbd=System.in;
		//2byte 처리 스트림 (65536 가지를 표현할수있다.) 한글 처리 가능한 객체
		var isr = new InputStreamReader(kbd); 
		//InputStreamReader isr = new InputStreamReader(kbd); //같은것! 확실하니까var 붙임
		
		
		System.out.println("입력");
		
		try {
			//InputStreamReader 객체로 입력한 문자의 code값 얻어내기
			int code = isr.read();  //1. 인풋스트림에있는 read()가 int로 리턴해주는값 (=유니코드값으로 리턴하는것)
			System.out.println("code:"+code); //2.그래서 유니코드값
			char ch = (char)code; //3 얘는 그 int를 문자로 캐스팅해서 ch에 넣음
			System.out.println("char:"+ ch); //4.그래서 문자
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
