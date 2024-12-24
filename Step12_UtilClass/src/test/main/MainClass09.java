package test.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainClass09 {
	public static void main(String[] args) {
		
		//1. 세명의 회원정보(번호, 이름, 주소)를 HashMap 객체를 생성해서 담아보세요
		//HashMap 객체 하나당 한명의 회원정보를 담으니까, 총3개의 HashMap객체가 생성이 되어야합니다.
		Map<String, Object> map1 = new HashMap<>();
		Map<String, Object> map2 = new HashMap<>();
		Map<String, Object> map3 = new HashMap<>();
		
		map1.put("num", 1);
		map1.put("name", "김구라");
		map1.put("addr", "노량진");
		
		map2.put("num", 2);
		map2.put("name", "해골");
		map2.put("addr", "행신동");
		
		map3.put("num", 2);
		map3.put("name", "원숭이");
		map3.put("addr", "상도동");
		
		//2. 위에서 생성한 HashMap 객체를 담을 ArrayList객체를 생성해보세요
		List<Map<String, Object>> list = new ArrayList<>();
		//ArrayList<Map> members = new ArrayList<>(); 완전틀렸어....ㅠㅠㅠ 위가맞어
		
		//3. ArrayList객체에 HashMap객체 3개를 담아 보세요 
		list.add(map1);
		list.add(map2);
		list.add(map3);
		
		//4. 반복문 돌면서 ArrayList에 담긴 회워정보를 콘솔창에 이쁘게 출력해 보세요
		for(Map<String, Object> tmp : list) { // list의 제너릭 : Map<String, Object>
			String info = String.format("번호: %d, 이름: %s, 주소: %s", 
					tmp.get("num"), tmp.get("name"), tmp.get("addr"));
			System.out.println(info);
		}
	}
}