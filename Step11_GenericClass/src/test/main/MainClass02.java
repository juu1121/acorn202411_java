package test.main;

import test.mypac.Apple;
import test.mypac.Pair;

public class MainClass02 {
	public static void main(String[] args) {
		/*
		 * key 값을 어떤 type으로 설정할지?
		 * value 값을 어떤 type으로 설정할지?
		 * 를 결정해서 2가지의 generic 클래스를 지정해야한다.
		 */
		//첫번째generic는 string , 두번째는 정수를받고싶다면Integer 
		//int가 안 되는이유 : 기본데이터타입이니까
		Pair<String, Integer> p1 = new Pair<>("one", 100);
		String k1 = p1.getKey();
		Integer v1= p1.getValue();
		
		Pair<String, Apple> p2 = new Pair<>("two", new Apple());
		String k2 = p2.getKey();
		Apple v2 = p2.getValue();
		
	}
}
