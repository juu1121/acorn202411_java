package test.main;

import java.util.Scanner;

public class MainClass02 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("나눌수 입력");
		String inputNum1 = scan.nextLine();
		
		System.out.println("나누어 지는수입력");
		String inputNum2 = scan.nextLine();
		
		try {
			//문자열 형태의 숫자를 실제 정수로 변경하기
			int num1 = Integer.parseInt(inputNum1);
			int num2 = Integer.parseInt(inputNum2);
			//계산하기
			int result = num2/num1; //몫
			int result2 = num2%num1;//나머지
			System.out.println(num2+" 를"+num1+"으로 나눈 몫 :"+result);
			System.out.println(num2+" 를"+num1+"으로 나눈 나머지 : "+result2);
			
		}catch(NumberFormatException nfe) {
			//예외객체에 담긴 메시지
			System.out.println(nfe.getMessage());
			System.out.println("숫자형식으로 입력해");
		}catch(ArithmeticException ae) {
			//예외 객체에 담긴 메세지 
			System.out.println(ae.getMessage());
			System.out.println("어떤수를 0으로 나눌수없다.");
		}
		System.out.println("main 메소드가 정상적으로 종료됩니다.");
	}
}
