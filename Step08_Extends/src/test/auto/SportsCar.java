package test.auto;

public class SportsCar extends Car { //Car은 engine이 있어야 객체생성.
	//Engine type을 매개변수에 전달받는 생성자
	
	public SportsCar(Engine engine) {
		/*
		 * super () 는 부모 생성자(Car 클래스의 생성자)를 의미한다.
		 * 부모 생성자에 필요한 값을 자식 생성자에서 받아서 전달해야한다.
		 * super()코드 실행전에 다른 코드가 있으면 안된다.
		 */
		super(engine);  //최우선적으로호출, 중간에 코딩불가
		//super(engine);=부모생성자호출하면서 ()여기에 값을 전달!
		//super. => 부모메소드 //super() => 부모생성자호출
	}
	//메소드
	public void OpenDrive() {
		
		if(this.engine == null) {  
			System.out.println("Engine이 없어서 달릴수가 없어요!");
			return; //메소드를 여기서 리턴시키기
		}
		System.out.println("뚜껑을 열고 달려요!");
	}

}
