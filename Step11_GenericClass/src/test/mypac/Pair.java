package test.mypac;

//Generic 클래스는 복수개 일수도있다. //제너리클래스를 나타내는 이름은 마음대로!
public class Pair<K, V> {
	//필드
	private K key;
	private V value;
	
	//생성자
	public Pair(K key, V value) {
		this.key=key;
		this.value = value;
	}
	
	//메소드
	public K getKey() {
		return key;
	}
	public V getValue() {
		return value;
	}
}
