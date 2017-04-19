import java.io.FileInputStream;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ExecuteDDL {
	private String driver;
	private String url;
	private String user;
	private String pass;

	public ExecuteDDL () {}

	public ExecuteDDL (String initFile) throws Exception {
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

	public void createTable(String sql) throws Exception {
		Class.forName(driver);
		try(Connection connection = DriverManager.getConnection(url, user, pass);
		Statement statement = connection.createStatement();) {
			//statement.execute(sql);//也可以用来执行DDL
			statement.executeUpdate(sql);
		}
	}

	public static void main(String[] args) throws Exception {
		ExecuteDDL executeDDL = new ExecuteDDL("mysql.ini");
		String createTableSql = "create table jdbc_test"
		       + " (jdbc_id int primary key auto_increment,"
		       + "  jdbc_name varchar(100),"
		       + "  jdbc_desc text);";
		executeDDL.createTable(createTableSql);
		System.out.println("建表成功！");
	}
}
