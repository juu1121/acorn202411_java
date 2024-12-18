package test.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainClass04 {
	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("src/test/mypac/memo.txt");  //파일객체..()안에있는 파일을 제어할수있는 파일객체
		
		Scanner scan = new Scanner(f);
		
		String line = scan.nextLine();
		System.out.println("memo.txt 파일의 첫번째줄:"+line);
		
	}
}
