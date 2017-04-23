import java.util.Properties;
import java.io.FileInputStream;
import java.sql.DriverManager;
import java.sql.Connection;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;

public class RowSetFactoryTest {
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
		RowSetFactory factory = RowSetProvider.newFactory();
		try(JdbcRowSet jdbcRs = factory.createJdbcRowSet()) {
			jdbcRs.setUrl(url);
			jdbcRs.setUsername(user);
			jdbcRs.setPassword(pass);
			jdbcRs.setCommand(sql);
			jdbcRs.execute();
			jdbcRs.afterLast();
			while (jdbcRs.previous()) {
				System.out.println(jdbcRs.getInt(1) + "\t" + jdbcRs.getString(2) + "\t" + jdbcRs.getString(3));
				if (jdbcRs.getInt("student_id") == 3) {
					jdbcRs.updateString("student_name", "¿œ÷Ì");
					jdbcRs.updateRow();
				}
			}
		}
			
	}
	
	public static void main(String[] args) throws Exception {
		RowSetFactoryTest rsft = new RowSetFactoryTest();
		rsft.initParam();
		rsft.update("select * from student_table");	
	}
}
