package test.frame02;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
	//생성자
	public MyFrame(String title) {
		super(title);
		
		//this.setBounds(100, 100, 300, 300); 
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		/*
		 *  - type 추론이 가능하다면 지역변수의 type 선언 대신에 var 로 선언 할수 있다.
		 *  - java 10  에서 추가된 문법,  아직도 실무에서는 1.8 버전을 쓰는 곳이 많기 때문에 주의!
		 *  - 지역변수에만 사용가능, 필드는 안됨
		 *  - 인터페이스 type 추론 불가 
		 *  - null 로 초기화 불가 
		 */
		var num =10;
		var name= "kim";
		var isRun = true;
		
		var startBtn = new JButton("작업시작");
		add(startBtn); 
		
		var startBtn2 = new JButton("작업시작2");
		add(startBtn2);
		
		startBtn.addActionListener((e)->{
			System.out.println("10초 걸리는 작업시작");
			try {
				Thread.sleep(1000*10);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			System.out.println("작업종료");
		});
		
		startBtn2.addActionListener((e)->{
			Thread t = new Thread(new WorkRunnable());
			t.start();
		});
	}
	// run했을때 실행의흐름이 시작되는 메인메소드
	public static void main(String[] args) {
		var frame = new MyFrame("나의 프레임");
		//Myframe 객체 안에서 this.으로 호출했던 메소드를
		//객체 외부에서는 참조값에 . 찍어서 호출할수있다.
		frame.setBounds(100, 100, 300, 300);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
