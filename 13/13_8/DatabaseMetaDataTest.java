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
			System.out.println("-----MySQL֧�ֵı�����-----");
			printResultSet(rs);
			
			rs = databaseMetaData.getTables(null, null, "%", new String[]{"TABLE"});
			System.out.println("-----��ǰ���ݿ�������ݱ�-----");
			printResultSet(rs);
			
			rs = databaseMetaData.getPrimaryKeys(null, null, "student_table");
			System.out.println("-----��student_table���������Ϣ-----");
			printResultSet(rs);
			
			rs = databaseMetaData.getProcedures(null, null, "%");
			System.out.println("-----��ǰ���ݿ�Ĵ洢������Ϣ-----");
			printResultSet(rs);

			rs = databaseMetaData.getCrossReference(null, null, "teacher_table", null, null, "student_table");
			System.out.println("-----teacher_table����student_table��֮������Լ��-----");
			printResultSet(rs);

			rs = databaseMetaData.getColumns(null, null, "student_table", "%");
			System.out.println("-----student_table�������Ϣ-------");
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
