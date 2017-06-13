import java.net.InetSocketAddress;
import java.nio.channels.CompletionHandler;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.Action;
import javax.swing.AbstractAction;
import javax.swing.KeyStroke;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import static java.awt.event.ActionEvent.CTRL_MASK;

public class AIOClient {
	static final String UTF_8 = "utf-8";
	static final int PORT = 30000;
	private AsynchronousSocketChannel clientChannel;
	JFrame mainWin = new JFrame("多人聊天");
	JTextArea jta = new JTextArea(16, 48);
	JTextField jtf = new JTextField(40);
	JButton sendBn = new JButton("发送");
	
	public void init() {
		mainWin.setLayout(new BorderLayout());
		jta.setEditable(false);
		mainWin.add(new JScrollPane(jta), BorderLayout.CENTER);
		JPanel jp = new JPanel();
		jp.add(jtf);
		jp.add(sendBn);
		Action sendAction = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				String content = jtf.getText();
				try {
					clientChannel.write(ByteBuffer.wrap(content.trim().getBytes(AIOClient.UTF_8))).get();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				jtf.setText("");
			}
		};	
		sendBn.addActionListener(sendAction);
		// 将"Ctrl + Enter"与"send"关联
		jtf.getInputMap().put(KeyStroke.getKeyStroke('\n', CTRL_MASK), "send");
		jtf.getActionMap().put("put", sendAction);
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.add(jp, BorderLayout.SOUTH);
		mainWin.pack();
		mainWin.setVisible(true);
	}

	public void connect() throws Exception {
		ByteBuffer buff = ByteBuffer.allocate(1024);
		ExecutorService executor = Executors.newFixedThreadPool(80);
		AsynchronousChannelGroup channelGroup = AsynchronousChannelGroup.withThreadPool(executor);	
		clientChannel = AsynchronousSocketChannel.open(channelGroup);
		clientChannel.connect(new InetSocketAddress("127.0.0.1", PORT)).get();
		jta.append("---与服务器连接成功--\n");
		buff.clear();
		clientChannel.read(buff, null, new CompletionHandler<Integer, Object>() {
			@Override
			public void completed(Integer result, Object attachment) {
				buff.flip();
				String content = StandardCharsets.UTF_8.decode(buff).toString();
				jta.append("神秘人说：" + content + "\n");
				buff.clear();
				clientChannel.read(buff, null, this);
			}

			@Override
			public void failed(Throwable ex, Object attachment) {
				ex.printStackTrace();
			}
		});
	}
		
	public static void main(String[] args) throws Exception {
		AIOClient client = new AIOClient();
		client.init();
		client.connect();	
	}
}
