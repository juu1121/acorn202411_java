package test.main;

import test.mypac.MyWeapon;
import test.mypac.Weapon;
/*
 *  [ 추상클래스 (Abstract Class) ]
 *  
 *  - class 예약어 앞에 abstract 를 명시해서 클래스를 정의한다.
 *  - 형태만 정의되고 실제 구현은 되지 않은 메소드가 존재할수 
 *    있다.
 *  - 형태만 정의된 메소드를 만들때는 abstract 예약어를 
 *    붙어서 메소드를 정의한다.
 *  - 생성자는 존재하지만 단독으로 객체 생성은 불가하다
 *  - 추상클래스 Type 의 참조값이 필요하다면 추상클래스를 상속받은 
 *    자식클래스를 정의해서 객체 생성한다.
 *  - 추상클래스를 상속받은 자식클래스는 부모의 추상메소드를 
 *    모두 오버라이드(재정의) 해야한다. 
 */
public class MainClass01 {
	public static void main(String[] args) {
		//추상(abstract)클래스로 객체를 생성할수있을까?
		//Weapon wl = new Weapon(); //당연히 에러남..추상클래스 단독으로 객체생성불가!
		
		//단지 data type의 역할은 할 수있을까?
		Weapon wl = null; //data type의 역할은 할 수있다.//추상메소드지만, 형태는 갖추고있어서 에러가 안 남
		// wl.prepare(); /NullPointerException발생(w1에 참조값이없어서)
		
		//Weapon 추상클래스를 상속받은 MyWeapon 클래스로 객체를 생성해서 Weapon type의 참조값 얻어내기
		Weapon w2 = new MyWeapon(); //하위클래스를 이용해서 Weapon의 참조값을 얻음
		wl.prepare();
		wl.attack();
	}
	
}
