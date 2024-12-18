package test.main;

public class MainClass01 {
	public static void main(String[] args) {
		//int type 5개를 저장하고 있는 배열 객체 생성해서 참조값을 nums라는 지역변수에 담기
		int[] nums = {10, 20, 30, 40, 50}; //int배열 //들어있는 타입에 따라 배열의 선언이 달라짐
		//double type 5개를 저장하고 있는 배열 객체 생성해서 참조값을 nums2라는 지역변수에 담기
		double[] nums2 = {10.1, 10.2, 10.3, 10.4, 10.5}; //double배열
		//boolean type 5개를 저장하고 있는 배열
		boolean[] truth = {true, true, false, false, true};
		//String type (참조데이터 type) 5개를 저장하고 있는 배열
		String[] names = {"김구라", "해골", "원숭이", "주뎅이", "덩어리"};	//String 배열
		// Car[] c1 = {new Car()};
		
		//배열 객체의 복제본 얻어내기
		int[] result =nums.clone(); //내용이같은 배열을 하나 더 만들어서 새로운참조값생김
		//복제본이 아닌 참조값만 복사하기
		int[] result2 = nums; //참조값만 복사
		
		//배열의 크기 얻어내기
		int size = nums.length;
		//배열은 순서가 있는 데이터이다. 특정index의 item참조하는 방법
		//자바에서의 배열은 사이즈를 늘리거나 줄일수없다 = 고정사이즈, 타입이 바뀌지않는다.
		int first = nums[0];
		int second=nums[2];
		int third = nums[2];
	}
}
