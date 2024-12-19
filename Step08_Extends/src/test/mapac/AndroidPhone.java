package test.mapac;
//AndroidPhone < HandPhone < Phone < Object 상속관계 
public class AndroidPhone extends HandPhone {
	//생성자
	public AndroidPhone() {
		System.out.println("AndroidPhone 생성자 호출됨");
	}
	
	//메소드
	public void doInternet() {
		System.out.println("인터넷을 해요");
	}
	@Override
	public void takePicture() {
		// TODO Auto-generated method stub
		//super.takePicture(); //필요없으면 호출 안 해도 됨
		System.out.println("1000만 화소의 사진을 찍어요");
	}
	
}
