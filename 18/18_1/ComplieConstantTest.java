class MyTest {
	static {
		System.out.println("初始化静态块！");
	}
	static final String complieConstant = "CrazyJava";
}

public class ComplieConstantTest {
	public static void main(String[] args) {
		System.out.println(MyTest.complieConstant);
	}
}
