class Apple {
	@Deprecated
	public void info() {
		System.out.println("Apple��info����");
	}
}

public class DeprecatedTest {
	public static void main(String[] args) {
		new Apple().info();
	}	
}
