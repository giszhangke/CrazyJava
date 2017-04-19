public class Apple<T> {
	private T info;

	public Apple() {
	
	}

	public <E> Apple(T info) {
		this.info = info;
	}

	public <E> void setInfo(T info) {
		this.info = info;
		System.out.println((E)info);
	}

	public T getInfo() {
		return info;
	}

	public static void main(String[] args) {
		Apple<String> a1 = new Apple<String>("apple");
		System.out.println(a1.getInfo());
		Apple<Integer> a2 = new Apple<Integer>(18);
		System.out.println(a2.getInfo());
		a2.<String>setInfo(99);
	}
}
