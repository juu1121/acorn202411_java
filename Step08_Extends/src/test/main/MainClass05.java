package test.main;
//Android<<HandPhone < Phone < Object 상속관계 
import test.mapac.AndroidPhone;
import test.mapac.HandPhone;

public class MainClass05 {
	public static void main(String[] args) {
		//AndroidPhone 객체를 생성해서 참조값을 AndroidPhone Type p1이라는 지역변수에 담기
		AndroidPhone p1 = new AndroidPhone();
		p1.call();
		p1.mobileCall();
		p1.takePicture();
		p1.doInternet();
		
		System.out.println("--------");
		//AndroidPhone 객체를 생성해서 참조값을 HandPhone type p2 이라는 지역변수에 담기
		HandPhone p2 = new AndroidPhone();
		p2.takePicture(); //타입이 HandPhone이어도 Override된 메소드 호출
		
		
		
		System.out.println("--------");
		HandPhone p3 = new HandPhone();
		p3.takePicture(); //원래 핸드폰객체의 메소드 호출
		
	}
}
