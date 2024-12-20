package test.main;

import test.mypac.Drill;

public class MainClass04 {
	public static void main(String[] args) {
		
		Drill d1 = new Drill() {
			
			@Override
			public void hole() {
				System.out.println("책상에 구멍을 뚫어요!");
			}
		};
		
		useDrill(d1);
		
		Drill d2 = ()->{
			System.out.println("의자에 구멍을 뚫어요!");
		};
		
		useDrill(d1);
		
		useDrill(()->{
			System.out.println("아무데나 뚫으시오");
		}); //즉석에서 드릴타입의 객체생성해서 하기..모양은 이렇지만 얘는 드릴타임의 객체인거야
	}
	
	
	
	public static void useDrill(Drill d) {
		d.hole();
		d.hole();
	}
}
