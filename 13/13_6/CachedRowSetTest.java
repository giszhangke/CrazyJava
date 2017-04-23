import java.util.Properties;
import java.io.FileInputStream;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.RowSetFactory;

public class CachedRowSetTest {
	private static String driver;
	private static String url;
	private static String user;
	private static String pass;

	public void initParam(String initFile) throws Exception {
		Properties props = new Properties();
		props.load(new FileInputStream(initFile));
		driver = props.getProperty("driver");
		url = props.getProperty("url");
		user = props.getProperty("user");
		pass = props.getProperty("pass");
	}

	public CachedRowSet query(String sql) throws Exception {
		Class.forName(driver);	
		Connection conn = DriverManager.getConnection(url, user, pass);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		RowSetFactory rowSetFactory = RowSetProvider.newFactory();
		CachedRowSet cachedRowSet = rowSetFactory.createCachedRowSet();
		cachedRowSet.populate(rs);
		// �ر���Դ
		rs.close();
		st.close();
		conn.close();
		return cachedRowSet;
	}

	public static void main(String[] args) throws Exception {
		CachedRowSetTest ct = new CachedRowSetTest();
		ct.initParam("../mysql.ini");
		CachedRowSet rs = ct.query("select * from student_table");
		rs.afterLast();
		while (rs.previous()) {
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
			if (rs.getInt("student_id") == 3) {
				rs.updateString("student_name", "������");
				rs.updateRow();
			}
		}
		Connection conn = DriverManager.getConnection(url, user, pass);
		conn.setAutoCommit(false);
		rs.acceptChanges(conn);
	}
}
