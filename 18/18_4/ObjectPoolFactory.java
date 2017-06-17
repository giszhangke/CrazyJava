import java.util.Map;
import java.util.HashMap;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;

public class ObjectPoolFactory {
	private Map<String, Object> objectPool = new HashMap<>();
	private Object createObject(String clazzName) throws InstantiationException
		, IllegalAccessException, ClassNotFoundException {
		Class<?> clazz = Class.forName(clazzName);
		return clazz.newInstance();
	}
	public void initPool(String fileName) throws InstantiationException
		, IllegalAccessException, ClassNotFoundException {
		File file = new File(fileName);
		try (
			FileInputStream fileIn = new FileInputStream(file);
		) {
			Properties props = new Properties();
			props.load(fileIn);
			for (String name : props.stringPropertyNames()) {
				objectPool.put(name, createObject(props.getProperty(name)));		
			}
		} catch (IOException ioe) {
			System.out.println(ioe);	
		}
	}
	public Object getObject(String name) {
		return objectPool.get(name);
	}
	public static void main(String[] args) throws Exception {
		ObjectPoolFactory pf = new ObjectPoolFactory();
		pf.initPool("obj.txt");
		System.out.println(pf.getObject("a"));		
		System.out.println(pf.getObject("b"));		
	}
}
