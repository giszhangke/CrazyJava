import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class ExecuteDML {
	private String driver;
	private String url;
	private String user;
	private String pass;

	public ExecuteDML() {}

	public ExecuteDML(String initFile) throws Exception {
		initParam(initFile);
	}

	public void initParam(String initFile) throws Exception {
		Properties properties = new Properties();
		properties.load(new FileInputStream(initFile));
		driver = properties.getProperty("driver");
		url = properties.getProperty("url");
		user = properties.getProperty("user");
		pass = properties.getProperty("pass");
	}

	public int insertData(String sql) throws Exception {
		Class.forName(driver);
		try(Connection connection = DriverManager.getConnection(url, user, pass);
		    Statement statement = connection.createStatement();) {
			return statement.executeUpdate(sql);
		}
	}

	public static void main(String[] args) throws Exception {
		ExecuteDML executeDML = new ExecuteDML("mysql.ini");
		String insertDataSql = "insert into jdbc_test(jdbc_name, jdbc_desc) "
			+ "select s.student_name, t.teacher_name "
			+ "from student_table s, teacher_table t "
			+ "where s.java_teacher = t.teacher_id;";
		int result = executeDML.insertData(insertDataSql);
		System.out.println("插入数据" + result + "条");
	}
}
