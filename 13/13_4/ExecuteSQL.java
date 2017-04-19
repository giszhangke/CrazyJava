import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Properties;

public class ExecuteSQL {
	private String driver;
	private String url;
	private String user;
	private String pass;

	public ExecuteSQL() {}

	public ExecuteSQL(String initFile) throws Exception {
		initParam(initFile);
	}

	public void initParam(String initFile) throws Exception {
		Properties properties = new Properties();
		properties.load(new FileInputStream("mysql.ini"));
		driver = properties.getProperty("driver");
		url = properties.getProperty("url");
		user = properties.getProperty("user");
		pass = properties.getProperty("pass");
	}

	public  void executeSql(String sql) throws Exception {
		Class.forName(driver);
		try (Connection connection = DriverManager.getConnection(url, user, pass);
		    Statement statement = connection.createStatement();){
			boolean hasResultSet = statement.execute(sql);
			if (hasResultSet) {
				try (ResultSet resultSet = statement.getResultSet()) {
					ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
					int columnCount = resultSetMetaData.getColumnCount();
					while (resultSet.next()) {
						for (int i = 0; i < columnCount; i++ ) {
							System.out.print(resultSet.getString(i + 1) + "\t");
						}
						System.out.print("\n");	
					}
				}
			} else {
				System.out.println("����SQLӰ��ļ�¼��" + statement.getUpdateCount() + "��");	
			}
		}
	}

	public static void main(String[] args) throws Exception {
		ExecuteSQL executeSQL = new ExecuteSQL("mysql.ini");
		System.out.println("-------ִ��ɾ�����DDL���-------");
		executeSQL.executeSql("drop table if exists my_test");
		System.out.println("-------ִ�н����DDL���---------");
		executeSQL.executeSql("create table my_test(test_id int auto_increment primary key, test_name varchar(255))");
		System.out.println("-------ִ�в������ݵ�DML���-----");
		executeSQL.executeSql("insert into my_test(test_name) " 
				+ "select student_name from student_table");
		System.out.println("-------ִ�в�ѯ���ݵ�DML���-----");
		executeSQL.executeSql("select * from my_test");
	}

}
