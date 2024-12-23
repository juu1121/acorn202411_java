package test.main;

import java.util.ArrayList; //ArrayList는 java.util패키지에서 import함

public class MainClass01 {
	public static void main(String[] args) {
		//java에서 배열은 용도가 한정되어있다. item을 담을 수 있는 공간을 늘리거나 줄일수없다.
		
		//문자열(String) type 을 담을 수 있는 방 5개짜리 배열 객체 새엇ㅇ
		String[] names = new String[5];
		names[0] = "김구라";
		names[1] = "해골";
		names[2] = "원숭이";
		
		//ArrayList<Integer> friendss = new ArrayList<>(); //이거그냥 내가연습 되는거같앵!
		
		ArrayList<String> friends = new ArrayList<>();  //<>얘뭐더라 타입명인가 스트링?그거 생략가능하대서 생략한결과임.참고.
		//김구라, 해골, 원숭이를 순서대로 담아보세요.(3줄코딩)
		friends.add("김구라");
		friends.add("해골");
		friends.add("원숭이");
		//0번방의 아이템을 불러와서 item이라는 변수에 담기
	    String item = friends.get(0); //스트링타입으로 리턴! 그래서 스트링타입
	    //디버깅할때 배열이랑 초큼 느낌이 다름
	    
		//1번방의 아이템을 삭제
		friends.remove(1);
		//0번방에 "에이콘"을 끼워넣기
		friends.add(0, "에이콘");
		//저장된 아이템의 갯수(size)를 size라는 지역변수에 담기
		int size = friends.size();
		//저장된 모든 아이템 전체 삭제
		friends.clear();
	}
}
