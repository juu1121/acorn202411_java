package test.main;

import test.mypac.AirPlane;
import test.mypac.Test;

public class MainClass01 {
	public static void main(String[] args) {
		Test t = new Test();
		//return type이 void인 메소드 호출
		 t.walk();
		 //return type이 int 인 메소드 호출하고 리턴되는 값을 a 라는 int type 지역변수에 담기
		 int a = t.getNumber();
		 //return type이 String인 메소드 호출하고 리턴되는 값을 b라는 String type 지역변수에 담기
		 String b = t.getGreeting();
		 
		 AirPlane c = t.getPlane();
		 //메소드 호출하면서 적절한 type 전달하는 연습
		 t.setPlane(new AirPlane());
		 t.dosomething(10, "문자", new AirPlane());
	}
}
