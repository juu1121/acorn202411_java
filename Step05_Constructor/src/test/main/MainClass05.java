package test.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainClass05 {
	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("src/test/mypac/memo.txt");
		Scanner scan = new Scanner(f);
		while(true) {
			String line = scan.nextLine();
			System.out.println(line);
		} //File객체와 Scanner 객체의 도움을 받으면, 파일로부터 물자열을 읽어들일수있다.
		//System.out에 있는 PrintStream객체의 도움을 받으면 콘솔창에 문자열을 출력할수있다.
	}
}
