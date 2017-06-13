import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.ListCellRenderer;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.DatagramPacket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.text.DateFormat;
import java.util.Date;

public class LanTalk extends JFrame {
	private DefaultListModel<UserInfo> listModel = new DefaultListModel<>();
	private JList<UserInfo> friendsList = new JList<>(listModel);
	private DateFormat formatter = DateFormat.getDateTimeInstance();
	public LanTalk() {
		super("局域网聊天");
		friendsList.setCellRenderer(new ImageCellRenderer());
		listModel.addElement(new UserInfo("all", "所有人", null, -2000));
		friendsList.addMouseListener(new ChangeMusicListener());
		add(new JScrollPane(friendsList));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(2, 2, 160, 600);
	}

	// 根据广播地址查询用户
	public UserInfo getUserBySocketAddress(SocketAddress address) {
		for (int i = 0; i < getUserNum(); i++) {
			UserInfo user = getUser(i);
			if (user.getAddress() != null && user.getAddress().equals(address)) {
				return user;
			}
		}
		return null;
	}

	public void addUser(UserInfo user) {
		listModel.addElement(user);
	}
	
	public void removeUser(int pos) {
		listModel.removeElementAt(pos);
	}

	public int getUserNum() {
		return listModel.size();
	}

	public UserInfo getUser(int pos) {
		return listModel.elementAt(pos);
	}

	class ChangeMusicListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() >= 2) {
				UserInfo selectedUser = (UserInfo)friendsList.getSelectedValue(); 
				if (selectedUser == null) {
					return;
				}
				if (selectedUser.getChatFrame() == null) {
					selectedUser.setChatFrame(new ChatFrame(null, selectedUser));
				}
				if (!selectedUser.getChatFrame().isShowing()) {
					selectedUser.getChatFrame().setVisible(true);
				}
			}
		}
	}

	public void processMsg(DatagramPacket packet, boolean single) {
		InetSocketAddress srcAddress = (InetSocketAddress)packet.getSocketAddress();	
		if (single) {
			srcAddress = new InetSocketAddress(srcAddress.getHostName(), srcAddress.getPort() - 1);
		}
		// 消息来源用户
		UserInfo srcUser = getUserBySocketAddress(srcAddress);
		
		if (srcUser != null) {
			// 聊天用户
			UserInfo chatUser = single ? srcUser : getUser(0);		
			if (chatUser.getChatFrame() == null) {
				chatUser.setChatFrame(new ChatFrame(null, chatUser));
			}
			String tipMsg = single ? "对您说：" : "对大家说：";
			try {
				chatUser.getChatFrame().addString(chatUser.getName() 
					+ tipMsg + " " 
					+ formatter.format(new Date()) + "\n"
					+ "\t" + new String(packet.getData(), 0, packet.getLength(), ComUtil.CHARSET) + "\n");
			} catch (Exception ex) {
				ex.printStackTrace();	
			}
			if (!chatUser.getChatFrame().isShowing()) {
				chatUser.getChatFrame().setVisible(true);
			}
		}
	}

	public static void main(String[] args) {
		LanTalk lanTalk = new LanTalk();
		new LoginFrame(lanTalk, "请输入用户名、头像后登录");
	}
}

class ImageCellRenderer extends JPanel implements ListCellRenderer<UserInfo> {
	private ImageIcon icon;
	private String name;
	private Color background;
	private Color foreground;
	
	@Override
	public Component getListCellRendererComponent(JList list, UserInfo user, int index, boolean isSelected, boolean hasCellFocus) {
		icon = new ImageIcon("ico/" + user.getIcon() + ".gif");	
		name = user.getName();
		background = isSelected ? list.getSelectionBackground() : list.getBackground();
		foreground = isSelected ? list.getSelectionForeground() : list.getForeground();
		return this;
	}

	@Override
	public void paintComponent(Graphics g) {
		int width = icon.getImage().getWidth(null);
		int height = icon.getImage().getHeight(null);
		g.setColor(background);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(foreground);
		g.drawImage(icon.getImage(), getWidth()/2 - width/2, 10, null);
		g.setFont(new Font("SansSerif", Font.BOLD, 18));
		g.drawString(name, getWidth() / 2 - name.length() * 10, height + 30);
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(60, 80);
	}
}
