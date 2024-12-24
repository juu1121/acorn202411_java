package test.main;

import java.util.ArrayList;
import java.util.function.Consumer;

public class MainClass03 {
	public static void main(String[] args) {
		//인삿말을 담을 ArrayList 객체를 생성해서 참조값을 greets라는 지역변수에 대입하기
		ArrayList<String> greets = new ArrayList<>();
		//greets에 들어있는 참조값을 이용해서 인삿말 3개를 임의로 담아보세요
		greets.add("안녕");
		greets.add("안농");
		greets.add("안눙");
		
		//확장 for문을 이용해서 모든 인삿말을 콘솔창에 순서대로 출력해보세용
		for(String tmp : greets) {
			System.out.println(tmp);
		}
		
		System.out.println("---1---");
		
		//아래의 동작을 분석해보세요
		Consumer<String> con = new Consumer<String>() {
			
			@Override
			public void accept(String t) { //매개변수의 타입은 제네릭타입을 따라감 
				//매개변수에 전달되는 item을 어떤 작업을 할지 여기에 coding을 하면 된다.
				System.out.println(t);
			}
		};  
				
		/*
		 * ArrayList 객체의 forEach() 메소드를 호출하면서 Consumer type객체를 전달하면
		 * 전달된 객체의 accept()메소드를 호출하면서
		 * ArrayList 객체에 저장된 item을 순서대로 매개변수에 전달해준다
		 */
		greets.forEach(con);  //forEach를 호출하면서 동작하나를 전달...(메소드는 단독으로 못있어서->객체의 동작하나를 포장해서 전달)
		//컨슈머타입인con을 전달하면서 forEach에서 accept라는 메소드를 동작함
		
		System.out.println("---ㅎ---");
		//메소드 한개짜리 인터페이스는 함수모양으로 쓸 수있다.
		Consumer<String> con2 = (t)->{
			System.out.println(t);
		};
		
		greets.forEach(con2);
		
		
		System.out.println("------");
		
		//어떤메소드에서 전달해하하는 내용이 인터페이스라면(메소드 한개짜리) 함수형태로 전달할수있다.
		greets.forEach((t)->{
			System.out.println(t);
		});
	}
}
