public class MyTest {
	@Testable
	public void info() {
		System.out.println("info");
	}

	public static void main(String[] args) {
		new MyTest().info();	
	}
}
