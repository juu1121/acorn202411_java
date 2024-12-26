package test.frame02;
/*
 * 새로운 스레드 만드는 방법2 
 * 
 * 1. Runnable 인터페이스를 구현한 클래스를 정의한다.
 * 2. run() 메소드를 강제 오버라이드한다.
 * 3. Thread 클래스로 객체를 생성하면서 해당 클래스로 만든 객체의 생성자의 인자로 전달한다.
 * 4. Thread 클래스로 만든 객체의 start() 메소드를 호출해서 스레드를 시작시킨다.
 * Thread t = new Thread(new WorkRunnable());
 * t.start();
 */
public class WorkRunnable implements Runnable { //WorkRunnable는 추상메소드 하나기때문에 start()가 없다!

	@Override
	public void run() {
		//새로운 스레드에서 해야할 작업을 run()메소드 안에서 한다.
		System.out.println("10초 걸리는작업시작");
		try {
			Thread.sleep(1000*10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("작업이 종료 되었습니다.");
	}

}
