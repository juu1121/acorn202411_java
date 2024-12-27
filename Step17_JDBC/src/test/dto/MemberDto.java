package test.dto;

public class MemberDto {
	//필드 선언
	private int num;
	private String name;
	private String addr;
	
	//디폴트생성자
	public MemberDto() {}

	//생성자 매개변수에전달
	public MemberDto(int num, String name, String addr) {
		this.num = num;
		this.name = name;
		this.addr = addr;
	}
	
	//getter,setter 메소드
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
}
