package test.main;

import test.mapac.HandPhone;
import test.mapac.Phone;

/*
 * [ 다형성 ] //타입이 많다.
 * 
 * - java에서 객체는 여러개의 type을 가질수있다.
 */
public class MainClass02 {
	public static void main(String[] args) {
		//HandPhone 객체를 생성해서 나온 참조값을 HandPhone type지역변수 p1에 담기
		HandPhone p1 = new HandPhone();
		//HandPhone 객체를 생성해서 나온 참조값을 HandPhone type지역변수 p2에 담기
		Phone p2 = new HandPhone(); //상속관계때문에 부모타입을 쓴 경우 
		//HandPhone 객체를 생성해서 나온 참조값을 HandPhone type지역변수 p3에 담기
		Object p3 = new HandPhone(); //HandPhone객체에는 여러가지 기능이있지만, Object라는 타입의 설명서만 사용가능.
		
		// HandPhone < Phone < Object 상속관계 
		//**어떤클래스로 객체를 생성했을때, 타입은 여러가지로 받을수있지만, 사용설명서는 명시된 타입+(그 타입의 부모클래스)만 가능.
		//지역변수에.찍으면 명시된 타입의 기능만 쓸수있음//지역변수나 필드앞에 명시된 타입은 사용설명서...
		//변수에 참조값이 담긴거 = 참조값과 변수 따로 생각 
		//변수에는  new HandPhone();의 참조값이 있고, 명시된타입은 => 지역변수나 필드의 사용설명서 
		//명시된타입은 : 지역변수나 필드 안에있는 사용설명서 (해결방법)=> 동일한객체의 사용설명서 변경가능. //타입캐스팅? 
	}
}
