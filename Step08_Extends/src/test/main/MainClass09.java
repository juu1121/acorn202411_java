package test.main;

import test.util.MyUtil;

public class MainClass09 {
	public static void main(String[] args) {
		//부모 클래스에 정의 된 기능도 사용가능
		MyUtil.clear();
		MyUtil.send();
		//자식 클래스에 정의된 기능 
		MyUtil.light();
	}
}
