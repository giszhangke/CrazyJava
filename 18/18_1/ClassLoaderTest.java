class Tester {
	static {
		System.out.println("正在初始化Tester实例");
	}
}

public class ClassLoaderTest {
	public static void main(String[] args) throws ClassNotFoundException {
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		cl.loadClass("Tester");	
		System.out.println("loadClass方法执行完成");
		Class.forName("Tester");
	}
}
