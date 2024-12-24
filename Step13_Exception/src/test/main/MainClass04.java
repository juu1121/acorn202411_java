package test.main;

public class MainClass04 {
	public static void main(String[] args) {
		System.out.println("main 메소드가 시작 되었습니다.");
		
		 try {
			//스레드를 일정시간 지연시키기( mili second 단위로 숫자를 전달하면 된다. )
			Thread.sleep(1000*5); //런타임 입셉션을 상속받지않는 InterruptedException 입셉션이어서, 컴파일중에 에러남 = 반드시 변경해줘야함
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		 
		 
		 System.out.println("main 메소드가 종료됩니다.");
	}
}
