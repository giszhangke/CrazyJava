import javax.swing.JDialog;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Action;
import javax.swing.AbstractAction;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.net.InetSocketAddress;

public class ChatFrame extends JDialog{
	private JTextArea msgArea = new JTextArea(12, 45);
	private JTextField chatField = new JTextField(30);
	private JButton sendBn = new JButton("发送");	
	UserInfo user;
	
	public ChatFrame(LanTalk parent, final UserInfo user) {
		super(parent, "和" + user.getName() + "聊天中...", false);	
		this.user = user;
		msgArea.setEditable(false);
		add(new JScrollPane(msgArea));
		
		JPanel bottom = new JPanel();
		bottom.add(new JLabel("发送消息："));
		bottom.add(chatField);
		bottom.add(sendBn);
		add(bottom, BorderLayout.SOUTH);
		
		Action sendAction = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				InetSocketAddress dest = (InetSocketAddress)user.getAddress();
				if (dest == null) {
					LoginFrame.comUtil.broadCast(chatField.getText());
					msgArea.setText("您对大家说：" + chatField.getText() + "\n" + msgArea.getText());
				} else {
					dest = new InetSocketAddress(dest.getHostName(), dest.getPort() + 1);	
					LoginFrame.comUtil.sendSingle(chatField.getText(), dest);
					msgArea.setText("您对" + user.getName() + "说：" + chatField.getText() + "\n" + msgArea.getText());
				}
				chatField.setText("");
			}	
		};
		sendBn.addActionListener(sendAction);
		chatField.getInputMap().put(KeyStroke.getKeyStroke('\n', java.awt.event.InputEvent.CTRL_MASK), "send");
		chatField.getActionMap().put("send", sendAction);		
		pack();
	}

	public void addString(String msg) {
		msgArea.setText(msg + "\n" + msgArea.getText());
	}
}
