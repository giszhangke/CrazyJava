import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Properties;
import java.util.Vector;
import java.io.FileInputStream;

public class QueryExecutor {
	JFrame jf = new JFrame("查询执行器");
	private JScrollPane scrollPane = new JScrollPane();
	private JButton execBn = new JButton("查询");
	private JTextField sqlField = new JTextField(45);
	private static Connection conn;
	private static Statement stmt;
	
	static {
		try {
			Properties props = new Properties();
			props.load(new FileInputStream("mysql.ini"));
			String driver = props.getProperty("driver");
			String url = props.getProperty("url");
			String user = props.getProperty("user");
			String pass = props.getProperty("pass");
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pass);
			stmt = conn.createStatement();
		} catch (Exception e) {
			System.out.println(e.getMessage() + "\n" + e.getStackTrace());	
		}
	}

	public void init() {
		JPanel top = new JPanel();	
		top.add(new JLabel("输入查询语句："));
		top.add(sqlField);
		top.add(execBn);
		execBn.addActionListener(new ExecListener());
		sqlField.addActionListener(new ExecListener());
		jf.add(top, BorderLayout.NORTH);
		jf.setSize(780, 480);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}

	/*
	 * 定义监听器
	 * */
	class ExecListener implements ActionListener {
		public void actionPerformed(ActionEvent avt) {
			if (scrollPane != null) {
				jf.remove(scrollPane);
			}		
			try (ResultSet rs = stmt.executeQuery(sqlField.getText())) {
				ResultSetMetaData rsmd = rs.getMetaData();
				Vector<String> columnNames = new Vector<>();
				Vector<Vector<String>> data = new Vector<>();
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					columnNames.add(rsmd.getColumnName(i + 1));
				}
				while (rs.next()) {
					Vector<String> singleRowData = new Vector<>();
					for (int i = 0; i < rsmd.getColumnCount(); i++) {
						singleRowData.add(rs.getString(i + 1));
					}
					data.add(singleRowData);
				}
				JTable table = new JTable(data, columnNames);
				scrollPane = new JScrollPane(table);
				jf.add(scrollPane);
				jf.validate();				
			} catch (Exception e) {
				System.out.println(e.getMessage() + "\n" + e.getStackTrace());
			}	
		}
	}

	public static void main(String[] args) {
		new QueryExecutor().init();	
	}

}

