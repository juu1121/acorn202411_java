package test.main;

import java.util.HashMap;

public class MainClass07 {
	public static void main(String[] args) {
		/*
		 * HashMap<key type, value type>
		 * 
		 *  key type은 일반적으로 String type을 가장 많이 사용한다. //드문경우로 정수로 하는경우도있다.
		 *  value type은 담고 싶은 데이터의 type을 고려해서 지정하면 된다.
		 *  value type을 Object로 지정하면 어떤 data type이던지 다 담을수가있다.
		 *  순사가 없는 데이터를 다룰때 사용하면 된다.
		 *  dto클래스 대신에 사용하기도 한다.
		 */
		HashMap<String, Object> map = new HashMap<>();
		map.put("num", 1);
		map.put("name", "김구라");
		map.put("isMan", true);
		
		//value 의 generic클래스가 Object 이기 때문에 Object type이 리턴된다.
		int num = (int)map.get("num"); //원래 type으로 casting이 필요!
		String name = (String)map.get("name");
		boolean isMan = (boolean)map.get("isMan");
		
		//동일한 key값으로 다시 담으면 수정
		map.put("name", "이정호");
		//특정 key값으로 담긴 내용삭제
		map.remove("isMan");
		//모두 삭제
		map.clear();

	}
}
