package test.main;

import test.mypac.Zoo;
import test.mypac.Zoo.Tiger; //내부클래스

public class MainClass02 {
	public static void main(String[] args) {
		Zoo z1 = new Zoo();
		
		Zoo.Monkey m1 = z1.getMonkey();
		m1.say();
		
		z1.getMonkey().say();
		
		Tiger t1 = z1.getTiger(); //tiger를 import하면 Zoo.이 아니어도 된다.
		t1.say();
		
		
		
	}
}
