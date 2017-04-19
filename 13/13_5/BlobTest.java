import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.Properties;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.File;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Blob;

public class BlobTest {
	// �������ڶ���
	JFrame jf = new JFrame("ͼƬ�������");
	// �������ݿ�������صĶ���
	private static Connection conn;
	private static PreparedStatement insert;
	private static PreparedStatement query;
	private static PreparedStatement queryAll;
	// ���������������
	private DefaultListModel<ImageHolder> imageModel = new DefaultListModel<>();
	private JList<ImageHolder> imageList = new JList<>(imageModel);
	private JTextField filePath = new JTextField(26);
	private JButton browserBn = new JButton("...");
	private JButton uploadBn = new JButton("�ϴ�");
	private JLabel imageLabel = new JLabel();
	JFileChooser chooser = new JFileChooser(".");	
	ExtensionFileFilter filter = new ExtensionFileFilter();	
 	
	static {
		try {
			Properties props = new Properties();
			props.load(new FileInputStream("mysql.ini"));
			String driver = props.getProperty("driver");
			String url = props.getProperty("url");
			String user = props.getProperty("user");
			String pass = props.getProperty("pass");
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, pass);
			// �ö���ִ�в������Է����Զ����ɵ�����
			insert = conn.prepareStatement("insert into img_table values(null, ?, ?)", Statement.RETURN_GENERATED_KEYS); 
			query = conn.prepareStatement("select img_data from img_table where img_id=?");
			queryAll = conn.prepareStatement("select img_id, img_name from img_table");
		} catch (Exception e) {
			System.out.println(e.getMessage() + "\n" + e.getStackTrace());
		}
	}

	public void init() throws Exception {
		// ��ʼ���ļ�ѡ����
		filter.addExtension("jpg");
		filter.addExtension("jpeg");
		filter.addExtension("gif");
		filter.addExtension("png");
		filter.setDescription("ͼƬ�ļ�(*.jpg,*jpeg,*.gif,*.png)");	
		chooser.addChoosableFileFilter(filter);
		chooser.setAcceptAllFileFilterUsed(false);
		// ��ʼ���������
		fillListModel();
		filePath.setEditable(false);
		imageList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JPanel jp = new JPanel();
		jp.add(filePath);
		jp.add(browserBn);
		browserBn.addActionListener(event -> {
			int result = chooser.showDialog(jf, "���ͼƬ�ļ��ϴ�");
			if (result == JFileChooser.APPROVE_OPTION) {
				filePath.setText(chooser.getSelectedFile().getPath());
			}
		});
		jp.add(uploadBn);
		uploadBn.addActionListener(avt -> {
			if (filePath.getText().trim().length() > 0) {
				upload(filePath.getText());
				filePath.setText("");
			}
		});
		JPanel left = new JPanel();
		left.setLayout(new BorderLayout());
		left.add(new JScrollPane(imageLabel), BorderLayout.CENTER);
		left.add(jp, BorderLayout.SOUTH);
		jf.add(left);
		imageList.setFixedCellWidth(160);
		jf.add(new JScrollPane(imageList), BorderLayout.EAST);
		imageList.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() >= 2) {
					ImageHolder cur = (ImageHolder)imageList.getSelectedValue();
					try {
						showImage(cur.getId());
					} catch (SQLException sqle) {
						System.out.println(sqle.getMessage() + "\n" + sqle.getStackTrace());
					}				
				}
			}
		});
		jf.setSize(620, 400);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}

	/*
	 * ����img_table���ListModel
	 * */
	public void fillListModel() throws SQLException {
		try (ResultSet rs = queryAll.executeQuery()) {
			imageModel.clear();
			while (rs.next()) {
				imageModel.addElement(new ImageHolder(rs.getInt(1), rs.getString(2)));
			}
		}
	}

	public void upload(String fileName) {
		String imageName = fileName.substring(fileName.lastIndexOf("\\") + 1, fileName.lastIndexOf("."));
		File f = new File(fileName);
		try (InputStream is = new FileInputStream(f)) {
			insert.setString(1, imageName);
			// �ܹ�File�����õ��ļ����ĳ���
		   	insert.setBinaryStream(2, is, (int)f.length());
			int affect = insert.executeUpdate();
			if (affect == 1) {
				fillListModel();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + "\n" + e.getStackTrace());
		}
	}

	public void showImage(int id) throws SQLException {
		query.setInt(1, id);
		try (ResultSet rs = query.executeQuery()) {
			if (rs.next()) {
				Blob imgBlob = rs.getBlob(1);
				ImageIcon icon = new ImageIcon(imgBlob.getBytes(1L, (int)imgBlob.length()));
				imageLabel.setIcon(icon);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		new BlobTest().init();	
	}
}

/*
 * ����һ��ImageHolder�࣬���ڷ�װͼƬ����ͼƬID
 * */
class ImageHolder {
	private int id;
	private String name;

	public ImageHolder() {}

	public ImageHolder(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return name;
	}
}

/*
 * ����FileFilter�����࣬ʵ���ļ����˹���
 * */
class ExtensionFileFilter extends FileFilter {
	private String description = "";
	private ArrayList<String> extensions = new ArrayList<>();
	
	public void addExtension(String extension) {
		if (!extension.startsWith(".")) {
			extension = "." + extension;
		}
		// ����չ��ת��Сд����뵽extensions��
		extensions.add(extension.toLowerCase());
	}
	
	public void setDescription(String aDescription) {
		description = aDescription;
	}

	public String getDescription() {
		return description;
	}

	public boolean accept(File f) {
		if (f.isDirectory()) {
			return true;
		}
		// ��ȡ�ļ���
		String name = f.getName().toLowerCase();
		for (String extension : extensions) {
			if (name.endsWith(extension)) {
				return true;
			}
		}

		return false;
	}
}	

