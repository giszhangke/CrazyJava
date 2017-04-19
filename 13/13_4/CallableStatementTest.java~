import java.io.FileInputStream;
import java.util.Properties;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.Types;

public class CallableStatementTest {
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
	/**
	 * 调用的存储过程如下：
	 * delimiter //
	 * create procedure add_pro(a int, b int, out sum int)
	 * begin
	 * set sum = a + b;
	 * end;
	 * //
	 **/
	public void callProcedure() throws Exception {
		Class.forName(driver);
		try (Connection connection = DriverManager.getConnection(url, user, pass);
		     CallableStatement callableStatement = connection.prepareCall("{call add_pro(?, ?, ?)}")) {
			callableStatement.setInt(1, 2);
			callableStatement.setInt(2, 3);
			callableStatement.registerOutParameter(3, Types.INTEGER);
			callableStatement.execute();
			System.out.println("调用存储过程add_pro执行2+3的结果是：" + callableStatement.getInt(3));
		} 
	}

	public static void main(String[] args) throws Exception {
		CallableStatementTest callableStatementTest = new CallableStatementTest();
		callableStatementTest.initParam("mysql.ini");
		callableStatementTest.callProcedure();
	}
}
