package test.main;

import java.io.InputStream;
import java.util.Scanner;

public class MainClass03 {
	public static void main(String[] args) {
		/*
		 * System 클래스의 in 이라는 필드에는 콘솔창으로부터 입력 받을 수 있는
		 * 객체의 참조값이 들어있다.
		 * in의 type은 InputStream이다.// InputStream = 데이터를 읽어드리는객체라고 생각
		 * Scanner 클래스의 생성자는 아래와 같은 모양의 생성자가 있다.
		 * Scanner(InputStream is)
		 * 따라서 아래의 코드는 콘솔창으로부터 입력받을수있는 Scanner 객체가 생성된것이다.
		 */
		System.out.println("문자열 입력:");
		
		//int code=System.in.read();//이렇게 읽을수있는데, 너무 복잡하니까 scanner사용 //system.in에 inputStream객체
		
		Scanner scan = new Scanner(System.in); 
		//콘솔로부터 입력받는이유..scanner에 system.in을 전달해서-> 다른걸전달하면, 파일로부터 입력받을수도있다.
		
		
		String line=scan.nextLine(); //읽어들인 문자열이 리턴되는 scan의 메소드
		
		System.out.println("입력한 문자열:" +line);
	}
}
