import java.util.Map;
import java.util.HashMap;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ExtendedObjectPoolFactory {
	private Properties props;
	private Map<String, Object> objectPool = new HashMap<>();
	private Object createObject(String className) 
		throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Class<?> clazz = Class.forName(className);
		return clazz.newInstance();
	}
	public void initPool(String fileName)
		throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		try (
			FileInputStream fileIn = new FileInputStream(fileName);
		) {
			props = new Properties();
			props.load(fileIn);
			for (String name : props.stringPropertyNames()) {
				if (!name.contains("%")) {
					objectPool.put(name, createObject(props.getProperty(name)));
				}
			}
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
	}	       
	public Object getObject(String name) {
		return objectPool.get(name);
	}
	public void initProperty() 
		throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
		for (String name : props.stringPropertyNames()) {
			if (name.contains("%")) {
				String[] objAndProp = name.split("%");
				Object target = objectPool.get(objAndProp[0]);
				String methodName = "set" + objAndProp[1].substring(0, 1).toUpperCase()
					+ objAndProp[1].substring(1);		 
				Class<?> clazz = target.getClass();
				Method mt = clazz.getMethod(methodName, String.class);
				mt.invoke(target, props.getProperty(name));
			}
		}		
	}
	public static void main(String[] args) throws Exception {
		ExtendedObjectPoolFactory epf = new ExtendedObjectPoolFactory();
		epf.initPool("extObj.txt");
		epf.initProperty();
		System.out.println(epf.getObject("a"));
	}
}
