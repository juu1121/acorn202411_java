package test.main;

import test.mypac.Car;

public class MainClass05 {
	public static void main(String[] args) {
		
		Car car1 = new Car();
		car1.drive();
		//Car 객체를 생성해서 메소드 호출하고 참조값은 더이상 사용할수없다.
		new Car().drive();  //객체를생성해서 바로쓰고 버림(1회용으로)
		
		car1.drive();
		car1.drive();
		//Car[] c1 = {new Car(), new Car()}; //다른거에서 연습용으로한거~
	}
}
