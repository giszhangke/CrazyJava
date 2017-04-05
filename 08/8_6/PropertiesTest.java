import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertiesTest {
	public static void main(String[] args) throws Exception {
		Properties properties = new Properties();
		properties.setProperty("name", "zhangke");
		properties.setProperty("address", "China");
		System.out.println(properties);
		properties.store(new FileOutputStream("info.ini"), "person info");
		Properties properties2 = new Properties();
		properties2.setProperty("school", "HZAU");
		properties2.load(new FileInputStream("info.ini"));
		System.out.println(properties);
		properties2.setProperty("a", "b");
		System.out.println(properties2);
	}
}
