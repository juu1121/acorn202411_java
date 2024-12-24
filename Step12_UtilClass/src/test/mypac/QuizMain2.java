package test.mypac;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class QuizMain2 {
	public static void main(String[] args) {
		//1. 로또 번호를 담을 HashSet 객체를 생성해서 set1 이라는 지역 변수에 담아 보세요
		Set<Integer> set1 = new HashSet<>();
		//2. while문을 이용해서 랜덤한 로또 번호를 set1 에 반복적으로 담아보세요
		//while 문 탈출 조건은 set1.size() 가 6이 되면 탈출되도록 해보세요
		Random ran = new Random();
	    while (true) {
	    	//1~45사이의 랜덤한 숫자를 얻어내서
	    	int RanNum = ran.nextInt(45)+1;
	    	//Set객체에 담는다.
	    	set1.add(RanNum);
	    	//만일 Set의 크기가 6이면
	    	if(set1.size() == 6) {
	    		break; //반복문탈출
	    	}
	    }
			
		//3. set1에 담긴 번호를 오름차순 정렬해서 콘솔창에 모두 출력해보세요.
		List<Integer> nums = new ArrayList<>(set1);
		Collections.sort(nums);
		
		for(Integer tmp:nums) {
			System.out.println(tmp);
		}
	    
	}
}
