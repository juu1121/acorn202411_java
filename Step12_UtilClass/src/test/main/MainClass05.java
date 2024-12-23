package test.main;


import java.util.ArrayList;
import java.util.List;

import test.mypac.Member;

public class MainClass05 {
	public static void main(String[] args) {
		//1. Member 객체를 담을수있는 ArrayList 객체를 생성해서 참조값을 members라는 List type지역변수에 담아보세요
		List<Member> members = new ArrayList<>();
		
		//2. 3명의 회원정보를 Member 객체에 각각 담아보세요(Member 객체가 3개 생성되어야 함)
		Member m1 = new Member();
		m1.num = 1;
		m1.name = "김구라";
		m1.addr="노량진";
		
		Member m2 = new Member(2, "해골", "행신동");
		
		//3. 위에서 생성된 Member객체의 참조값을 List객체에 모두 담아 보세요
		members.add(m1);
		members.add(m2);
		members.add(new Member(3, "원숭이", "상도동"));
		/*
		 * 4. members List 객체에 담긴 내용을 이용해서 회원 목록을 아래와 같은 형식으로 반복문을 돌면서 출력해보세요
		 * 
		 * 번호: 1, 이름:김구라, 주소:노량진
		 * 
		 * .
		 * .
		 */
		for (Member tmp : members) {
			String info = String.format("번호 : %d, 이름 : %s, 주소 : %s",
					tmp.num, tmp.name, tmp.addr);
			System.out.println(info);
		};
		
		for (Member tmp : members) {
			System.out.println("번호:"+tmp.num+" 이름:"+tmp.name+" 주소:"+tmp.addr);
		};
		
		
	}
}
