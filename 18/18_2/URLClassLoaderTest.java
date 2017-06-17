import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Driver;
import java.sql.Connection;
import java.util.Properties;

public class URLClassLoaderTest {
	static Connection conn = null;
	
	static Connection getConnection(String url, String user, String pass) throws Exception {
		if (conn == null) { 
			URL[] urls = {new URL("file:mysql-connector-java-5.1.30-bin.jar")};
			URLClassLoader myClassLoader = new URLClassLoader(urls);
			Driver driver = (Driver)myClassLoader.loadClass("com.mysql.jdbc.Driver").newInstance();
			Properties props = new Properties();
			props.setProperty("user", user);
			props.setProperty("password", pass);
			conn = driver.connect(url, props);
		} 
		return conn;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(getConnection("jdbc:mysql://127.0.0.1:3306/select_test", "root", "mysql"));	
	}		
}
