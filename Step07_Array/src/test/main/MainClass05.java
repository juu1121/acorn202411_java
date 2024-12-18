package test.main;

import test.mypac.Bike;

public class MainClass05 {
	public static void main(String[] args) {
		/*
		 * 1. Bike 객체를 담을수있는 방 3개짜리 배열객체를 생성해서 참조값을 
		 * 	  bikes라는 지역변수에 담아보세요.
		 * 2. 배열의 각각의 방 (0,1,2번)에 Bike 객체를 생성해서 담아보세요.
		 * 3. 반복문 for를 이용해서 순서대로 배열의 각각의 방에 있는 Bike 객체의
		 * 	  ride() 메소드를 호출해보세요.
		 */
		
		// Bike[] bikes = {new Bike(), new Bike(), new Bike()}; //bike타입, 배열을 선언할때 방마다 Bike라는 객체가 생성.
		Bike[] bikes = new Bike[3]; //bike타입,얘는 null로 초기화 된...배열을 선언할때,,방3개짜리 빈배열객체
		
		for (int i=0; i<bikes.length; i++ ) {
			bikes[i]=new Bike();
		}
		for (int i=0; i<bikes.length; i++ ) {
			bikes[i].ride();  
		}
		
		
	}
}
