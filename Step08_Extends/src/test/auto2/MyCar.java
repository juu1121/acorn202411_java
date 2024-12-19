package test.auto2;

import test.auto.Car;
import test.auto.Engine;

public class MyCar extends Car {
	
	public MyCar(Engine engine) {
		super(engine);
	}
	
	public void myDrive() {
		//Car클래스에 정의된 engine이라는 필드는 접근지정자가 protected이기 때문에
		//패키지가 달라도 접근이 가능하다 
		if(this.engine == null) {
			System.out.println("Engine이 없어서 달릴수가 없어요!");
			return; //메소드를 여기서 리턴시키기(종료시키기)
		}
		System.out.println("나만의 방식으로 달려요!");
	}

}
