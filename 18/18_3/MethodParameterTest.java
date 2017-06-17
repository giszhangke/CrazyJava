import java.util.List;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

class Test {
	public void replace(String str, List<String> list) {}
}

public class MethodParameterTest {
	public static void main(String[] args) throws Exception {
		Class clazz = Test.class;
		Method replace = clazz.getMethod("replace", String.class, List.class);
		System.out.println("replace方法的参数个数为：" + replace.getParameterCount());
		Parameter[] paras = replace.getParameters();
		int index = 1;
		for (Parameter para : paras) {
			System.out.println("-----replace方法的第" + index++ + "个参数信息-----");
			System.out.println("参数名：" + para.getName());
			System.out.println("形参类型：" + para.getType());
			System.out.println("泛型类型：" + para.getParameterizedType());
		}
	}
}
