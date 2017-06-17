import java.util.Enumeration;
import java.net.URL;
import java.io.IOException;

public class ClassLoaderPropTest {
	public static void main(String[] args) throws IOException {
		ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
		System.out.println("系统类加载器：" + systemClassLoader);	
		Enumeration<URL> em = systemClassLoader.getResources("");
		while (em.hasMoreElements()) {
			System.out.println(em.nextElement());
		}
		ClassLoader extensionLoader = systemClassLoader.getParent();
		System.out.println("扩展类加载器：" + extensionLoader);
		System.out.println("扩展类加载器的加载路径：" + System.getProperty("java.ext.dirs"));
		System.out.println("扩展类加载器的parent: " + extensionLoader.getParent());
	}
}
