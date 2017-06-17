import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.lang.reflect.Method;

interface Person {
	void walk();
	void sayHello(String name);
}

class MyInvocationHandler implements InvocationHandler {
	public Object invoke(Object proxy, Method method, Object[] args) {
		System.out.println("正在执行方法：" + method.getName());
		if (args != null) {
			System.out.println("参数如下：");
			for (Object obj : args) {
				System.out.println(obj);
			}
		} else {
			System.out.println("该方法没有参数");
		}
		return null;
	}	
}

public class ProxyTest {
	public static void main(String[] args) throws Exception {
		MyInvocationHandler mh = new MyInvocationHandler();
		Person p = (Person)Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, mh);
		p.walk();
		p.sayHello("孙大圣");
	}		
}
