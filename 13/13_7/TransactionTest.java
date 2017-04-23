import java.util.Properties;
import java.io.FileInputStream;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

public class TransactionTest {
	private String driver;
	private String url;
	private String user;
	private String pass;

	public void initParam(String initFile) throws Exception {
		Properties props = new Properties();
		props.load(new FileInputStream(initFile));
		driver = props.getProperty("driver");
		url = props.getProperty("url");
		user = props.getProperty("user");
		pass = props.getProperty("pass");
	}

	public void insertTransaction(String[] sqlList) throws Exception {
		Class.forName(driver);
		try (Connection conn = DriverManager.getConnection(url, user, pass)) {
			conn.setAutoCommit(false);
			try (Statement stmt = conn.createStatement()) {
				for (String sql : sqlList) {
					stmt.addBatch(sql);
				}
				stmt.executeBatch();
			}
			conn.commit();
		}	
	}

	public static void main(String[] args) throws Exception {
		TransactionTest transactionTest = new TransactionTest();
		transactionTest.initParam("../mysql.ini");
		String[] sqlList = {"insert into student_table values(null, '王二小', 1)",
		"insert into student_table values(null, '李三大', 1)",
		"insert into student_table values(null, '钱无名', 1)",
		//"insert into student_table values(null, '赵大', 5)", // 这里如果是5，则会报错，违反外键约束
		"insert into student_table values(null, '张无忌', 1)"};
		transactionTest.insertTransaction(sqlList);
	}
}
