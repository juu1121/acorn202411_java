package test.mapac;

//가상의 옛날 가정용 전화기 객체를 생성할 설계도라고 가정
public class Phone { //extends 라는 예약어가 없으면 자동으로 extends Object된다.
	//public class Phone extends Object 
	//생성자
	public Phone() {
		System.out.println("Phone 생성자 호출됨");
	}
	//전화 거는 메소드
	public void call() {
		System.out.println("전화를 걸어요!");
	}

}
