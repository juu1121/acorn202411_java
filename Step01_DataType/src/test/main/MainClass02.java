package test.main;

public class MainClass02 {
	public static void main(String[] args) {
		//1. 콘솔창에 "main 메소드가 시작되었습니다."를 출력해보세요.
		System.out.println("main 메소드가 시작되었습니다.");
		//2. 국어점수 95를 kor이라는 변수에 담아보세요.
		int kor = 95;
		//3. 영어점수 100을 eng라는 변수에 담아보세요
		int eng = 100;
		//4. 국어점수와 영어점수의 평균을 구해서(연산자 활용) avg라는 변수에 담아 보세요.
		double avg = (kor+eng)/2d; //정수끼리 연산하면 결과는 정수만 나오기때문에 2옆에 d를 붙여서 실수로 만들어준다.
		//5. 콘솔창에 avg 변수안에 담긴 내용을 출력해 보세요.
		System.out.println(avg);
	}
}
