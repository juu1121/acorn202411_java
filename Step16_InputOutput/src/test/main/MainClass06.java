package test.main;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class MainClass06 {
	public static void main(String[] args) {
		//콘솔창에 출력할수있는 객체의 참조값얻어내기
		PrintStream ps = System.out;
		//PrintStream 객체의 참조값을 부모 type변수에 담기
		//OutputStream도 1byte 처리 스트림이다(한글처리불가)
		OutputStream os = ps;
		var osw = new OutputStreamWriter(os);
		//OutputStreamWriter를 BufferedWriter의 생성자에 전달해서 객체생성
		var bw = new BufferedWriter(osw);
		/*
		 * window의 개행기호 : \r\n
		 * linux, mac os 의 개행기호 : \n
		 */
		try {
			bw.write("하나");
			bw.newLine(); //운영체제에 맞는 개행기호를 자동으로 출력해주는 메소드
			bw.write("두울");
			bw.newLine();
			bw.write("세엣");
			bw.flush(); //방출
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		
	}
}
