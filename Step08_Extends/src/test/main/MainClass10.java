package test.main;

//test.util.MyUtil 클래스 안에 있는 모든 static 자원을 import하기
import static test.util.MyUtil.*;
//상속받은 MyUtil의 스태틱자원 : light/send/clear
public class MainClass10 {
	public static void main(String[] args) {
		//static메소드가 없지만!
		//static import 를 하면 마치 자신(MainClass10)의 멤버 static 메소드처럼 사용할수있다.
		clear();
		light();
		send();
		
	}
}
