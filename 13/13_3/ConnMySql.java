import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class ConnMySql {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://127.0.0.1:3306/select_test";
	private static String name = "root";
	private static String pass = "mysql";
	private static String sql = "select s.*, teacher_name"
		+ " from student_table s, teacher_table t"
		+ " where t.teacher_id = s.java_teacher";

	public static void main(String[] args) throws Exception {
		Class.forName(driver);
		//Class.forName("com.mysql.jdbc.Driver");
		try (
			Connection connection = DriverManager.getConnection(url, name, pass);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);) {
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + "\t" + 
						   resultSet.getString(2) + "\t" + 
						   resultSet.getString(3) + "\t" +
						   resultSet.getString(4));
			}
			
		};
	}		
}
