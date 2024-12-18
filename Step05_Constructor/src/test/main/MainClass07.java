package test.main;

import test.mypac.Computer;
import test.mypac.Cpu;
import test.mypac.Memory;
import test.mypac.Ssd;

public class MainClass07 {
	public static void main(String[] args) {
		//Computer 객체를 생성해서 참조값을 com1에 담아보세요.
		Computer com1 = new Computer (new Cpu(), new Memory(), new Ssd());
		
		//4줄로 풀기 ~_~
		Cpu c1 = new Cpu();
		Memory m1 = new Memory();
		Ssd s1 = new Ssd();
		Computer com2 = new Computer (c1, m1, s1);
	}
}
