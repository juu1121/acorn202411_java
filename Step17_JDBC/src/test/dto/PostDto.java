package test.dto;
/*
 * 1. id, title, content를 담을 수있는 PostDto클래스를 test.dto패키지에 만들어보세요
 */
public class PostDto {
	private int id;
	private String title;
	private String content;
	
	
	//디폴트생성자 없어도 있다고 간주
	public PostDto() {}
	
	public PostDto(int id, String title, String content) {
		this.id = id;
		this.title = title;
		this.content = content;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	
	
	
	
	
	
}
