package test.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;

public class MainClass07 {
	
	
	public static void main(String[] args) {
		System.out.println("main() 메소드가  \"시작\" 되었습니다"); //큰따옴표인식
		System.out.println("main() 메소드가 \\시작\\ 되었습니다."); // \역슬래시 인식
		
		//파일에 저장할 문자열
		String msg = "나는 슬퐁...so sad...";
		
		//memo.txt 파일을 만들기 위한 File객체 생성하기
		//File f = new File("C:\\Users\\acorn\\Desktop\\playground\\myFolder\\memo.txt");//절대경로 적어!
		//슬래시는 하나만써도 인식 = 슬래시 하나로 대체가능
		File f = new File("C:/Users/acorn/Desktop/playground/myFolder/memo.txt");
		try {
			//만일 해당 파일이 존대하지않으면
			if(!f.exists()) {
				//새로 만들어라
				f.createNewFile();
				System.out.println("memo.txt파일을 만들었습니다.");
			}
			//파일에 문자열을 출력하는 객체, 어떤파일에 문자열을 출력할지 대상을 전달해줘야함
			
			//new FrileWriter(File객체, append mode 여부)
			var fw = new FileWriter(f, true);
			//var fw = new FileWriter(f); //append가 디폴트는 false.
			fw.append(msg);
			fw.append("\r\n"); ////개행기호
			fw.flush(); //실제출력
			fw.close(); //마무리
			System.out.println("memo.txt파일에 문자열 기록!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
