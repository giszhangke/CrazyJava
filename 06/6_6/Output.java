package zhang;

public interface Output
{
	int MAX_CACHE_LINE = 50;
	void out();// 抽象类和接口中定义的抽象方法都是不带方法体的，即不需要花括号
	void getData(String msg);
	
	default void print(String... msgs) {
		for (String msg : msgs) {
			System.out.println(msg);	
		}
	}
	
	default void test() {
		System.out.println("实例.test");
	}

	static String staticTest() {
		return "接口里的类方法";
	}

}
