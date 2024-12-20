package test.main;

import test.mypac.MyRemocon;
import test.mypac.Remocon;

public class MainClass01 {
	public static void main(String[] args) {
		/*
		 * Remocon 인터페이스는 data type의 역할을 할 수 있는데
		 * 해당 type의 참조값을 얻어내기 위해서는 인터페이스를 구현한 클래스로
		 * 객체생성을 하면 된다.
		 */
		Remocon r1 = new MyRemocon(); //
		r1.up();
		r1.down();
	}
}
