import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.util.Properties;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class LoginFrame {
	private final String PROP_FILE = "mysql.ini";
	private String driver;
	private String url;
	private String user;
	private String pass;
	// 登录界面的GUI组件
	private JFrame jf = new JFrame("登录");
	private JTextField userField = new JTextField(20);
	private JTextField passField = new JTextField(20);
	private JButton loginButton = new JButton("登录");
	
	public void init() throws Exception {
		Properties properties = new Properties();
		properties.load(new FileInputStream(PROP_FILE));
		driver = properties.getProperty("driver");
		url = properties.getProperty("url");
		user = properties.getProperty("user");
		pass = properties.getProperty("pass");	
		// 加载驱动
		Class.forName(driver);
		// 
		loginButton.addActionListener(e -> {
			//if (validateUseStatement(userField.getText(), passField.getText())) {
			if (validateUsePreparedStatement(userField.getText(), passField.getText())) {
				JOptionPane.showMessageDialog(jf, "登录成功");
			} else {
				JOptionPane.showMessageDialog(jf, "登录失败");
			}			
		});
		jf.add(userField, BorderLayout.NORTH);
		jf.add(passField);
		jf.add(loginButton, BorderLayout.SOUTH);
		jf.pack();
		jf.setVisible(true);
	}
	/*
	 * 使用Statement容易被Sql注入
	 * */
	private boolean validateUseStatement(String userName, String userPass) {
		String sql = "select * from jdbc_test "
			+ "where jdbc_name='" + userName + "' "
			+ "and jdbc_desc='" + userPass + "'";
		try (Connection connection = DriverManager.getConnection(url, user, pass);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql)) {
			while (resultSet.next()) {
				return true;
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;		
	}

	private boolean validateUsePreparedStatement(String userName, String userPass) {
		String sql = "select * from jdbc_test "
			+ "where jdbc_name=? and jdbc_desc=? ";
		try (Connection connection = DriverManager.getConnection(url, user, pass);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, userPass);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					return true;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + "\n" + e.getStackTrace());
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		new LoginFrame().init();	
	}
}
