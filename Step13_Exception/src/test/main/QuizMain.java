package test.main;
/* run했을때 콘솔창에
 * 1초
 * 2초
 * 3초
 * .
 * .
 * 경과시간이 출력되다가
 * 10초까지만 출력하고 종료되는 프로그래밍을해보세요
 * hint => Thread.sleep(1000);
 */
public class QuizMain {
	public static void main(String[] args) {

		for (int i=0; i<10; i++) {
			System.out.println(i+1+"초");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("종료");	
		
		
	}
}
