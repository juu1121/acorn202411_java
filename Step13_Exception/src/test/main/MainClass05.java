package test.main;

public class MainClass05 {
	public static void main(String[] args) throws InterruptedException  {
		System.out.println("main 메소드가 시작 되었습니다.");
		
		 
			//스레드를 일정시간 지연시키기( mili second 단위로 숫자를 전달하면 된다. )
			Thread.sleep(1000*5); //런타임 입셉션을 상속받지않는 InterruptedException 입셉션이어서, 컴파일중에 에러남 = 반드시 변경해줘야함
			//메인메소드를 호출한쪽에서 저 입셉션을 처리하도록 미루는것!=메소드에 입셉션을 던지는 문법도 존재
			
		 System.out.println("main 메소드가 종료됩니다.");
	}
}
