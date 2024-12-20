package test.main;

import test.mypac.Calc;

public class MainClass05 {
	public static void main(String[] args) {
		Calc c1 = new Calc() {
			
			@Override
			public double execute(double num1, double num2) {
				return 0; //더블타입을 리턴해줘야하므로 없으면 에러남..
			}
		};
		
		//Calc c5 = () -> {}; //매개변수를 전달받지 않아서 에러남+리턴값도없어
		
		Calc c2 = (double a, double b)->{
			return 0;
		}; 
		
		//좀더 간단히
		//매개변수의 type은 생략가능 - 순서대로 
		Calc c3 = (a,b) -> {
			//return 예약어 이전에 coding 된 내용이 없음
			return 0;
		};
		//return 예약어 이전에 coding 된 내용이 없으면 {} 생략가능+return 예약어도 사용하지 않는다
		Calc c4 = (a,b) -> 0; //리턴할 값만 명시하면 되기떄문에 return 예약어도 사용하지 않는다
		
		//한줄짜리 함수 = 람다함수
		//매개변수에 전달된 두 숫자를 더한값을 리턴하는 동작
		Calc plus = (a, b) -> a+b;  //return a+b라는 뜻인데, 값을 명시해서 예약어 쓰지않는다. 
		//매개변수에 전달된 두 숫자를 뺀값을 리턴하는 동작
		Calc minus = (a, b) -> a-b;
		//매개변수에 전달된 두 숫자를 곱한값을 리턴하는 동작
		Calc multiple = (a,b) -> a*b;
		//매개변수에 전달된 두 숫자를 나눈값을 리턴하는 동작
		Calc divide = (a,b) -> a/b;
		
		double result1 = plus.execute(10, 10); //20
		double result2 = minus.execute(10, 10); //0
		double result3 = multiple.execute(10, 10); //100
		double result4 = divide.execute(10, 10); //1
		
	}
}
