package test.mapac;
//AndroidPhone=Ios < HandPhone < Phone < Object 상속관계 
public class IosPhone extends HandPhone {
	//생성자
	public IosPhone() {
		System.out.println("Ios 생성자 호출");
	}
	
	public void IosSystem() {
		System.out.println("Ios운영체제");
	}
}
