package test.main;

import test.mapac.AndroidPhone;
import test.mapac.Phone;

public class MainClass08 {
	public static void main(String[] args) {
		
		//여기서 아래의 usePhone() 메소드를 호출하는 code를 작성하고 run해서 결과를 확인해 보세요!
		//메소드 호출과 동시에 객체를 생성해서 전달
		MainClass08.usePhone(new Phone());
		
		//미리 생성된 객체의 참조값을
		Phone p1 = new Phone();
		//참조해서 전달
		MainClass08.usePhone(p1);
		
		//클래스명 생략가능!
		usePhone(p1);
		
		usePhone(new AndroidPhone());  //Phone p = new AndroidPhone() //자식객체가 부모타입 받음!!!!
		//AndroidPhone < HandPhone < Phone < Object 상속관계 
	}
	//static 메소드 추가 (이 메소드를 호출하기 위해서는 Phone type의 참조값이 필요하다)
	public static void usePhone(Phone p) {
		//매개변수에 전달된 값을 이용해서 메소드를 호출하는 code
		p.call();
	}
}
