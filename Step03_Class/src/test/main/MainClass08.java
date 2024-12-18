package test.main;

import java.io.PrintStream;

public class MainClass08 {
	
	//static 필드
	public static String myName="김구라";
	//non static 필드
	public String yourName = "에이콘";
	
	public static void main(String[] args) {
		//System 클래스의 out 이라는 static 필드에는 콘솔창에 출력하는 기능을 가지고있는 
		//PrintStream type의 참조값이 들어있다.
		
		PrintStream a = System.out;
		a.println("오잉?");
		
		System.out.println(MainClass08.myName);
		System.out.println(myName);
		
		//yourName은 static필드가 아니라 참조가 안 된다.
		//System.out.println(MainClass08.yourName); //static영역에 아니라 heap영역에있어서 못 씀.
		//여기는 static 메소드 안쪽이기 떄문에 this를 사용할수없다.
		//System.out.println(this.yourName); //this는 객체안에서 내가 객체가 되었을때 가능//스태틱영역에서 this 말도안돼유
		
		long time = System.currentTimeMillis(); //long type을 리턴해주는 static메소드//
		//1970년 1월1일0시를 기준으로 현재까지 경과한 시간을 1/1000초 단위로 계산해서 리턴해주는 메소드
		
		System.out.println("경과시간:"+time);
	}
}
