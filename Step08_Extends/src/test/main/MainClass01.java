package test.main;

import test.mapac.HandPhone;

public class MainClass01 {
	public static void main(String[] args) {
		/*
		 * Phone 클래스를 상속받은 HandPhone 클래스로 객체를 생성해서
		 * 그 참조값을 p1이라는 이름의 지역변수에 담기
		 */
		HandPhone p1 = new HandPhone();
		p1.call();
		p1.mobileCall();
		p1.takePicture();
		
		//상속관계 HandPhone < Phone < Object
		//HandPhone는 부모의 메소드를 다 쓸수있음
		
	}
}
