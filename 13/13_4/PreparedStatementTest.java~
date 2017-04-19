import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.PreparedStatement;
import java.util.Properties;

public class PreparedStatementTest {
	private String driver;
	private String url;
	private String user;
	private String pass;

	public PreparedStatementTest() {}

	public PreparedStatementTest(String initFile) throws Exception {
		initParam(initFile);
	}

	public void initParam(String initFile) throws Exception {
		Properties properties = new Properties();
		properties.load(new FileInputStream("mysql.ini"));
		driver = properties.getProperty("driver");
		url = properties.getProperty("url");
		user = properties.getProperty("user");
		pass = properties.getProperty("pass");
		//加载驱动
		Class.forName(driver);
	}

	public  void insertUseStatement() throws Exception {
		long startTime = System.currentTimeMillis();
		try (Connection connection = DriverManager.getConnection(url, user, pass);
		    Statement statement = connection.createStatement();){
			for (int i = 0; i < 100; i++) {
				statement.executeUpdate("insert into student_table values(null, '姓名" + i + "', 1)");
			}
			System.out.println("使用Statement用时：" + (System.currentTimeMillis() - startTime));
		}
	}

	public void insertUsePreparedStatement() throws Exception {
		long startTime = System.currentTimeMillis();
		try (Connection connection = DriverManager.getConnection(url, user, pass);
		     PreparedStatement preparedStatement = connection.prepareStatement(
			     "insert into student_table values(null, ?, 1)");) {
			for (int i = 0; i < 100; i++) {
				preparedStatement.setString(1, "p姓名" + i);
				preparedStatement.executeUpdate();
			}
			System.out.println("使用PrepareStatement用时：" + (System.currentTimeMillis() - startTime));
		}
	}

	public static void main(String[] args) throws Exception {
		PreparedStatementTest preparedStatementTest = new PreparedStatementTest("mysql.ini");
		preparedStatementTest.insertUseStatement();
		preparedStatementTest.insertUsePreparedStatement();
	}

}

