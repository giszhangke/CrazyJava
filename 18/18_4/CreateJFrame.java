import java.lang.reflect.Constructor;

public class CreateJFrame {
	public static void main(String[] args)
	       throws Exception {
		Class<?> clazz = Class.forName("javax.swing.JFrame");		
		Constructor constructor = clazz.getConstructor(String.class);
		Object obj = constructor.newInstance("测试窗口");
		System.out.println(obj);
	}
}
