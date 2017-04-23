import java.util.Properties;
import java.io.FileInputStream;
import java.sql.DriverManager;
import java.sql.Connection;
import javax.sql.rowset.JdbcRowSet;
import com.sun.rowset.JdbcRowSetImpl;

public class JdbcRowSetTest {
	private String driver;
	private String url;
	private String user;
	private String pass;
	
	public void initParam() throws Exception {
		Properties props = new Properties();
		props.load(new FileInputStream("mysql.ini"));
		driver = props.getProperty("driver");
		url = props.getProperty("url");
		user = props.getProperty("user");
		pass = props.getProperty("pass");
	}

	public void update(String sql) throws Exception {	
		Class.forName(driver);
		try (Connection conn = DriverManager.getConnection(url, user, pass);
		     JdbcRowSet jdbcRs = new JdbcRowSetImpl(conn)) {
			jdbcRs.setCommand(sql);
			jdbcRs.execute();
			jdbcRs.afterLast();
			while (jdbcRs.previous()) {
				System.out.println(jdbcRs.getInt(1) + "\t" + jdbcRs.getString(2) + "\t" + jdbcRs.getString(3));
				if (jdbcRs.getInt("student_id") == 3) {
					jdbcRs.updateString("student_name", "ÀÔ¥Û •");
					jdbcRs.updateRow();
				}
			}
		}
			
	}
	
	public static void main(String[] args) throws Exception {
		JdbcRowSetTest jrst = new JdbcRowSetTest();
		jrst.initParam();
		jrst.update("select * from student_table");	
	}
}
