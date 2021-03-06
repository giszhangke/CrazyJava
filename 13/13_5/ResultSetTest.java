import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.FileInputStream;
import java.util.Properties;

public class ResultSetTest {
	private String driver;
	private String url;
	private String user;
	private String pass;

	public void initParam(String initFile) throws Exception {
		Properties properties = new Properties();
		properties.load(new FileInputStream(initFile));
		driver = properties.getProperty("driver");
		url = properties.getProperty("url");
		user = properties.getProperty("user");
		pass = properties.getProperty("pass");
	}

	public void query(String sql) throws Exception {
		Class.forName(driver);
		try (Connection connection = DriverManager.getConnection(url, user, pass);
			PreparedStatement preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, 
				ResultSet.CONCUR_UPDATABLE);
			ResultSet resultSet = preparedStatement.executeQuery()) {
			resultSet.last();
			int rowCount = resultSet.getRow();
			for (int i = rowCount; i > 0; i--) {
				resultSet.absolute(i);
				System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3));
				// 修改指针所在记录的第2列值
				resultSet.updateString(2, "学生姓名" + i);
				// 提交修改
				resultSet.updateRow();
			}

		}	
	}

	public static void main(String[] args) throws Exception {
		String sql = "select * from student_table";
		ResultSetTest resultSetTest = new ResultSetTest();
		resultSetTest.initParam("mysql.ini");
		resultSetTest.query(sql);	
	}
}
