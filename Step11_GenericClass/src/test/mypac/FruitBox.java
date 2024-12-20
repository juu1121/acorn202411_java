package test.mypac;

//클래스 정의시에 특정 type은 전달받아서 사용하는 구조로 정의할수있다.
//그러한 클래스를 Generic 클래스라고 한다.
public class FruitBox<T> {
	//필드
	private T item;
	
	//포장하는 메소드
	public void pack(T item) {
		this.item = item;
	}
	
	//꺼내는 메소드
	public T unPack() {
		return item;
	}

}
