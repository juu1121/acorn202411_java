package test.auto;

/*
 *  - 접근 지정자 접근범위
 *  
 *  public : 어디에서나 접근 가능 
 *  protected : 동일한 package 혹은 패키지가 달라도 상속관계에서 자식에서 접근 가능 
 *  default(작성 안한 경우) : 동일한 package 안에서만 접근 가능
 *  private : 동일한 클래스 혹은 동일한 객체 안에서만 접근가능 
 *  
 *  - 접근 지정자를 붙이는 위치
 *  
 *  1. 클래스를 선언 할때 (import 가능여부를 결정한다)
 *  2. 생성자 (객체 생성 가능여부를 결정한다)
 *  3. 필드 (필드 참조 가능 여부를 결정한다)
 *  4. 메소드 (메소드 호출 가능 여부를 결정한다)
 *  
 *  클래스는 default 와 public 두가지의 접근 지정자만 지정 가능하다
 *  접근 지정자를 생략한것이 default 접근 지정자다 
 */
public class Car { //public안 붙이면 패키지가 같아야해(default가 되니까...)
	//필드(protected는 패키지가 달라도 상속관계 자식이면 참조가능)
	protected Engine engine;
	//private Engine engine; //자식에게도 접근 안됨
	
	//Engine 객체를 생성자의 인자로 전달받는 생성자 (이 생성자를 정의하면 default 생성자는 사라진다.)
	public Car(Engine engine) {
		this.engine = engine;
	}
	
	//메소드
	public void drive() {
		if (this.engine == null) {
			System.out.println("Engine이 없어서 달릴수가 없어요!");
			return; //메소드를 여기서 리턴시키기 (종료시키기)
		}
		System.out.println("달려요~");
	}
}
