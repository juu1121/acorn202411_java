package test.main;

public class MainClass03 {
	//static 메소드 안에서 사용하려면 class에도 static 예약어가 필요!
	public static class Gura{
		public void say() {
			System.out.println("안녕! 나는 구라야~");
		}
	}
	
	
	static int num=10;
	public static void test() {
		
	}
	
	public static void main(String[] args) {
		Gura g = new Gura();
		g.say();
		
		System.out.println(num);
		test();
		//메소드 안에도 클래스를 정의할 수있다.
		//여기 정의한 클래스 메소드 안쪽영역에서만 사용할수있다.
		//메소드 안에 선언한 클래스는 Local Inner Class
		class Cat{
			public void say() {
				System.out.println("야옹!");
			}
		}
		//Local Inner Class를 이용해서 객체생성하고 사용해보기
		Cat c = new Cat();
		c.say();
	}
}
