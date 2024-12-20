package test.main;

import test.mypac.MyRemocon;
import test.mypac.Remocon;

public class MainClass02 {
	public static void main(String[] args) {
		//다향성확인
		MyRemocon r1 = new MyRemocon();
		Remocon r2 = r1;
		Object r3 = r1;
		
		useRemocon(r1);
		useRemocon(r2);
		
		
		//casting 해서 전달하면 메소드를 호출할수있다.
		useRemocon((Remocon)r3); //Remocon c = (Remocon)r3; //이걸상상해
		//useRemocon(r3);//r3는 오브젝트타입이어서 안받아줄래! =>타입캐스팅 
		//자식타입은 부모타입을 안 받아줘서 안됨 =>타입캐스팅
	}
	
	public static void useRemocon(Remocon r) {
		r.up();
		r.down();
	}
}
