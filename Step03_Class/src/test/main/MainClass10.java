package test.main;

import test.mypac.Member;

public class MainClass10 {
	public static void main(String[] args) {
		Member m1 = new Member();
		m1.num(1);
		m1.name("김구라");
		m1.addr("노량진");
		
		
		Member m2=new Member().num(2).name("해골").addr("행신동");
		
		Member m3=new Member().num(3).name("원숭이").addr("분당"); 
		//메소드에서 this를 리턴해주면 똑같은 객체를 .을 찍어서 계속 사용가능
	}
}
