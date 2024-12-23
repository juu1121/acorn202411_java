package test.main;

import java.util.ArrayList;

import test.mypac.Member;
import test.mypac.MemberDto;

public class MainClass06 {
	public static void main(String[] args) {
		//1. MemberDto객체를 담을 수 있는 ArrayList 객체를 생성해서 참조값을 members 라는 지역변수에 담아보세ㅛㅇ
		ArrayList<MemberDto> members = new ArrayList<>();
		//2. 3명의 회원정보를 MemberDto 객체에 각각 담아보세요(MemberDto객체가 3개 생성되어야 함)
		//MemberDto mem1 = new MemberDto(1, "김구라", "노량진" );
		MemberDto mem1 = new MemberDto(); //기본데이터는0 참조데이터타입은null 이 들어가있다!
		mem1.setNum(1);
		mem1.setName("김구라");
		mem1.setAddr("노량진");
		
		MemberDto mem2 = new MemberDto(2, "해골", "행신동" );
		MemberDto mem3 = new MemberDto(3, "원숭이", "상도동" );
		
		//3. 위에서 생성된 MemberDto 객체의 참조값을 ArrayList 객체에 모두 담아보세요
		members.add(mem1);
		members.add(mem2);
		members.add(mem3);
		
		//4. 반복문을 이용해서 members에 들어있는 회원정보를 출력해보세요.
		for (MemberDto tmp : members) {
			String info = String.format("번호 : %d, 이름 : %s, 주소 : %s",
					tmp.getNum(), tmp.getName(), tmp.getAddr()); //String타입의 format메소드 ...개수가 유동적..한개두개세개 전달해도 됨/오브젝트니까 어떤타/입도 됨
			System.out.println(info);
			//System.out.println("번호:"+tmp.getNum()+" 이름:"+tmp.getName()+" 주소:"+tmp.getAddr());
		}
		
		//테스트메소드 호출 (매개 변수에 전달할 String type의 갯수는 유동적이다.)
		test(); //아무것도 전달안하면 빈배열 
		test("kim"); //아이템한개짜리배열
		test("kim", "lee", "park"); //아이템3개짜리배열
	}
	
	//테스트
	public static void test(String... msgs) {
		//String...은 String[] type이다(스트링배열타입)
		String[] a = msgs;
	}
}
