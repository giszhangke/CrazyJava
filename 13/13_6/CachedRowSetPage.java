import java.util.Properties;
import java.io.FileInputStream;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.CachedRowSet;

public class CachedRowSetPage {
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

	public CachedRowSet query(String sql, int pageSize, int pageIndex) throws Exception {
		Class.forName(driver);
		try (Connection conn = DriverManager.getConnection(url, user, pass);
		     Statement stmt = conn.createStatement();
		     ResultSet rs = stmt.executeQuery(sql)) {
			RowSetFactory rowSetFactory = RowSetProvider.newFactory();
			CachedRowSet cs = rowSetFactory.createCachedRowSet();
			cs.setPageSize(pageSize);
			cs.populate(rs, (pageIndex - 1) * pageSize + 1);
			return cs;
		}
	}

	public static void main(String[] args) throws Exception {
		CachedRowSetPage crp = new CachedRowSetPage();
		crp.initParam("../mysql.ini");
		CachedRowSet cs = crp.query("select * from student_table", 5, 3);
		while (cs.next()) {
			System.out.println(cs.getString(1) + "\t" + cs.getString(2) + "\t" + cs.getString(3));
		}
	}
}
