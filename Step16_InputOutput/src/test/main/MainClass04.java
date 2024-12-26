package test.main;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class MainClass04 {
	public static void main(String[] args) {
		//콘솔창에 출력할수있는 객체의 참조값얻어내기
		PrintStream ps = System.out;
		//PrintStream 객체의 참조값을 부모 type변수에 담기
		//OutputStream도 1byte 처리 스트림이다(한글처리불가)
		
		OutputStream os = ps;
		//ps는 printStream타입도 OutputStream타입도 되지만
		//os에는 printStream의 참조값이 담겨있다.(디버깅결과)
		//os.write =>아웃풋스트림의기능 //os.flush();//방출
		
		try {
			os.write(97);
			os.write(98);
			os.write(99);
			//os.write(44032); //한글처리불가
			os.flush();//방출  //이게있어야 콘솔창에 출력-
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
