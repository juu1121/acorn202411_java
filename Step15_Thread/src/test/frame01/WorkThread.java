package test.frame01;
/*
 * 새로운 스레드 만드는 방법
 * 
 * 1. Thread 클래스를 상속받은 클래스를 정의한다.
 * 2. run()메소드를 오버라이드한다.
 * 3. run()메소드 안에서 새로운 스레드에서 해야할 작업을 코딩한다
 * 4. 만든 클래스로 객체를 생성하고, 해당 객체의 start()메소드를 호출하면 새로운스레드가 시작된다. 
 * => new WorkThread().start();
 */
public class WorkThread extends Thread { //1.
	@Override //스레드의 run이라는 메소드
	public void run() { //시간이 오래걸리거나 불확실한작업을 여기 안에서 하게 함
		//새로운 스레드에서 해야할 작업을 run()메소드 안에서 한다.
		System.out.println("10초 걸리는작업시작");
		try {
			Thread.sleep(1000*10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
