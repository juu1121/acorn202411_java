package test.main;

import java.util.Scanner;

public class MainClass03 {
	public static void main(String[] args) {
		//1. String type을 담을 수 있는 방 3개짜리 빈 배열 객체를 만들어서 참조값을 names라는 지역변수에 담아보세요
		String[] names = new String[3];
		//String[] names = {null, null, null};
		
		//2. 콘솔창으로부터 문자열을 입력받을수있는 Scanner 객체를 생성해서 참조값을 scan이라는 지역변수에 담아보세요
		Scanner scan = new Scanner(System.in);
		
		//3. 반복문을 돌면서 Scanner 객체를 이용해서 이름을 입력받고 입력받은 이름을 배열에 순서대로 저장

		for (int i=0; i<names.length; i++) {
			System.out.println("이름입력:");
			//Scanner 객체를 이용해서 입력받은 문자열을 배열에 누적시킨다.
			names[i]=scan.nextLine();
		}
		//4. 반복문 돌면서 배열에 저장된 이름을 순서대로 콘솔에 출력해보세용
		for (int i=0; i<names.length; i++) {
			System.out.println(names[i]);
		}
		
		
		
	}
}
