package test.main;

import test.auto.Car;
import test.auto.Engine;

public class MainClass06 {
	public static void main(String[] args) {
		//Car 객체를 생성해서 참조값을 car1이라는 지역변수에 담아보세요.
		Car car1 = new Car(new Engine());
		
//		Car car2 = new Car(null); //문법적으로만 허용 이렇게 사용하지마 
//		Engine e1 = new Engine();
//		Car car2 = new Car(e1);
		//car1 에 들어있는 참조값을 이용해서 .drive() 메소드를 호출해보세요
		car1.drive();
		
	}
}
