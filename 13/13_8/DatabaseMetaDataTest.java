import java.util.Properties;
import java.io.FileInputStream;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class DatabaseMetaDataTest {
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
	
	public void info() throws Exception {
		Class.forName(driver);
		try (Connection conn = DriverManager.getConnection(url, user, pass)) {
			DatabaseMetaData databaseMetaData = conn.getMetaData();
			
			ResultSet rs = databaseMetaData.getTableTypes();
			System.out.println("-----MySQL支持的表类型-----");
			printResultSet(rs);
			
			rs = databaseMetaData.getTables(null, null, "%", new String[]{"TABLE"});
			System.out.println("-----当前数据库里的数据表-----");
			printResultSet(rs);
			
			rs = databaseMetaData.getPrimaryKeys(null, null, "student_table");
			System.out.println("-----表student_table里的主键信息-----");
			printResultSet(rs);
			
			rs = databaseMetaData.getProcedures(null, null, "%");
			System.out.println("-----当前数据库的存储过程信息-----");
			printResultSet(rs);

			rs = databaseMetaData.getCrossReference(null, null, "teacher_table", null, null, "student_table");
			System.out.println("-----teacher_table表与student_table表之间的外键约束-----");
			printResultSet(rs);

			rs = databaseMetaData.getColumns(null, null, "student_table", "%");
			System.out.println("-----student_table表的列信息-------");
			printResultSet(rs);
			
		}
	}

	public void printResultSet(ResultSet rs) throws Exception {
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();
		
		for (int i = 0; i < columnCount; i++) {
			System.out.print(rsmd.getColumnName(i + 1));
		}
		System.out.println("");
		while (rs.next()) {
			for (int i = 0; i < columnCount; i++) {
				System.out.print(rs.getString(i + 1) + "\t");
			}
			System.out.println("");
		}

		rs.close();	
	}

	public static void main(String[] args) throws Exception {
		DatabaseMetaDataTest dmt = new DatabaseMetaDataTest();
		dmt.initParam("../mysql.ini");
		dmt.info();
	}
}
