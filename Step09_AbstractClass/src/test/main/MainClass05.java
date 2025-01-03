package test.main;

import test.mypac.Weapon;

public class MainClass05 {
	public static void main(String[] args) {
		//익명의 inner class를 이용해서 Weapon type의 참족밧을 얻어내서 변수에 담은 다음
		Weapon w1 = new Weapon() {//익명의클래스
			
			@Override
			public void attack() {
				System.out.println("몰라 아무데나 공격해~");
				
			}
		};//클래스를 만들지않고Weapon타입의 참조값얻어내기
		//메소드를 호출하면서 전달하기
		useWeapon(w1);
		
		//변수에 넣지 않고 바로 생성해서 호출 
		//단독객체생성이 안 되서 익명의로컬이너클래스를 이용해서 추상클래스타입의 참조값을 얻어내기!
		//메소드 호출하면서 즉석에서 Weapon type의 참조값을 얻어내서 전달하기
		useWeapon(new Weapon() {
			
			@Override
			public void attack() {
				System.out.println("김구라를 공격하자~!");
			}
		});
	}
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}
}
