package test.main;

import test.mypac.Member;

public class MainClass09 {
	public static void main(String[] args) {
		/*
		 * Member 객체를 3개 생성해서 각각의 객체에 3명의 정보를 담아보세요
		 */
		//기본 생성자를 이용해서 객체생성
		Member M1 = new Member();
		Member M2 = new Member();
		//매개변수에 값을 3개 전달받는 생성자를 이용해서 객체생성
		Member M3 = new Member(3, "원숭이", "분당");
		
		M1.num=1;
		M1.name="모니";
		M1.addr="건대";
		
		M2.num=2;
		M2.name="해골";
		M2.addr="행신동";
		
		M1.showInfo();
		M2.showInfo();
		M3.showInfo();
		
		
	}
}
