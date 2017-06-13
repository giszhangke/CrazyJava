import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.Timer;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JDialog {
	public JLabel tip;
	public JTextField userField = new JTextField("科长", 20);
	public JComboBox<Integer> iconList = new JComboBox<>(
		new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
	private JButton loginBn = new JButton("登 录");
	private LanTalk lanTalk;
	public static ComUtil comUtil;
	
	public LoginFrame(LanTalk parent, String msg) {
		super(parent, "输入名字后登录", true);
		lanTalk = parent;
		setLayout(new GridLayout(5, 1));
		JPanel jp = new JPanel();
		tip = new JLabel(msg);
		tip.setFont(new Font("Serif", Font.BOLD, 16));
		jp.add(tip);
		add(jp);
		add(getPanel("用户名", userField));
		iconList.setPreferredSize(new Dimension(224, 20));
		add(getPanel("图  标", iconList));
		JPanel bp = new JPanel();
		loginBn.addActionListener(new MyActionListener(this));
		bp.add(loginBn);
		add(bp);
		pack();
		setVisible(true);
	}	

	public JPanel getPanel(String name, JComponent jc) {
		JPanel jp = new JPanel();
		jp.add(new JLabel(name + ":"));
		jp.add(jc);
		return jp;
	}

	public void setTipMsg(String msg) {
		tip.setText(msg);
	}

	class MyActionListener implements ActionListener {
		private LoginFrame loginFrame;

		public MyActionListener(LoginFrame loginFrame) {
			this.loginFrame = loginFrame;
		}

		@Override
		public void actionPerformed(ActionEvent evt) {
			try {
				comUtil = new ComUtil(lanTalk);	
				final String loginMsg = ChatProtocol.PRESENCE + userField.getText() + ChatProtocol.SPLITTER 
					+ iconList.getSelectedObjects()[0] + ChatProtocol.PRESENCE;
				comUtil.broadCast(loginMsg);
				// 定时器，每十秒广播一次在线信息
				Timer timer = new Timer(1000 * 10, event -> comUtil.broadCast(loginMsg));	
				timer.start();
				loginFrame.setVisible(false);
				lanTalk.setVisible(true);
			} catch (Exception ex) {
				loginFrame.setTipMsg("连接异常，请确认30001端口空闲，且网络连接正常");
			}	
		}
	}
}
