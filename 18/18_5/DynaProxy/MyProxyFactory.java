import java.lang.reflect.Proxy;

public class MyProxyFactory {
	public static Object getProxy(Object obj) throws Exception {
		MyInvocationHandler mh = new MyInvocationHandler();
		mh.setTarget(obj);
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), mh);
	}
}
