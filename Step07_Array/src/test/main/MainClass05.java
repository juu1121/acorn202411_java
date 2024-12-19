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
		Bike[] bikes = new Bike[3]; //bike타입,얘는 null로 초기화 된 참조값이 담기지않은 방3개짜리 빈배열객체가 생김
		
		for (int i=0; i<bikes.length; i++ ) {
			bikes[i]=new Bike();
		}
		
//		bikes[0]=new Bike();
//		bikes[1]=new Bike();
//		bikes[2]=new Bike();

		for (int i=0; i<bikes.length; i++ ) {
			//bikes[i].ride();   //한줄로하기 
			//i번째 방에 있는 Bike 객체의 참조값얻어오기
			Bike tmp = bikes[i];
			//tmp에 있는 Bike 객체의 .ride() 메소드 호출하기
			tmp.ride();		
		}
		
		System.out.println();
		//확장for문 ..for문에우측에는 배열을 참조, 좌측에는 타입변수명
		for(Bike tmp:bikes) {
			tmp.ride();
		}
		
	}
}
