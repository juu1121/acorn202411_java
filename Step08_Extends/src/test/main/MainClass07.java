package test.main;

import java.util.Scanner;

import test.auto.Car;
import test.auto.Engine;
import test.mapac.Phone;

public class MainClass07 {
	public static void main(String[] args) {
		Object a =10; //자바의 모든 데이터타입은 Object타입으로 담을 수 있다. Object는 기본데이터타입도 레퍼객체로 변경해서 담음
		Object b = true;
		Object c ='a';
		Object d = "abcd";
		Object e = new Phone();
		Object f = new Scanner(System.in);
		Object g = new Car(new Engine());
		
		//Object 배열은 어떤 type 이던지 다 담을수있다
		Object[] objs = new Object[5];
		objs[0]=10;
		objs[1]=true;
		objs[2]="kim";
		objs[3]=new Phone();
		objs[4]=new Scanner(System.in);
		
		//지역변수 e에 저장된 참조값을 이용해서 전화를 걸어보세요
		Phone p1 = (Phone)e;
		p1.call();
		//new Phone().call();
		//objs 배열의 3번방에 있는 참조값을 이용해서 전화를 걸어보세요
		Phone p2 = (Phone)objs[3];
		p2.call();
		
		//변수안에 넣지 않고 바로호출 -> 괄호로 묶기
		//변수에 담지 않고 casting 후에 바로 메소드를 호출
		((Phone)objs[3]).call();
		
	}
}
