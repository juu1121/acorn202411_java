package main;
/*
 * eclipse에서 진한빨강색으로 표시되는 단어는 예약어이다.
 * 예약어는 아주 특별히 해석되기로 약속된단어이기 때문에 식별자(클래스명, 메소드명, 변수명 등등)으로
 * 사용할 수 없다.
 */
public class MainClass {
	public static void main(String[] args) {
		
		System.out.println("Hello, world!");
		System.out.println("장희주, 세상!");
		//let num=10; 
		int num=10;
		//let name="김구라";
		String name="김구라";
		//let isMan=true;
		boolean isMan=true;
		
		for(int i=0; i<10; i++) {
			System.out.println(i);
		}
	}
}
