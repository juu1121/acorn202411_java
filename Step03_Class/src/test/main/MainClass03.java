package test.main;

import test.mypac.Car;
import test.mypac.Food;

public class MainClass03 {
	public static void main(String[] args) {
		/*  
		 *  Car 객체를 3개 만들어서
		 *  임의의 자동차이름과 가격을 필드에 각각대입하는 코드를 작성해 보세요
		 */
		Car car1 = new Car ();
		Car car2 = new Car ();
		Car car3 = new Car ();
		
		car1.name = "소나타";
		car1.price= 1000;
		
		car2.name = "모닝";
		car2.price = 2000;
			
		car3.name = "아반떼";
		car3.price = 3000;
		 
		/*
		 * 다 하신분은 자신만의 클래스를 test.mypac 패키지에 만들어놓고 테스트하는 코드를 작성해보세요.
		 */
		Food f1 = new Food();
		f1.name = "cake";
		f1.addr = "망원동";
		f1.price = 9500;
		
		Food f2 = new Food();
		f2.name = "타코";
		f2.addr="아차산역";
		f2.price=25000;
		
		Food f3 = new Food();
		f3.name = "사시미";
		f3.addr = "중곡";
		f3.price = 100000;
		
		Food f4 = new Food();
		f4.name = "매운등갈비";
		f4.addr = "신촌";
		f4.price = 20000;
		
		Food f5 = new Food();
		f5.name = "소곱창";
		f5.addr = "사당";
		f5.price = 30000;
		
	}
}
