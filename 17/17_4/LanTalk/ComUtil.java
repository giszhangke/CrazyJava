import javax.swing.JOptionPane;
import java.net.InetSocketAddress;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.MulticastSocket;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.io.IOException;
import java.util.ArrayList;

public class ComUtil {
	public static final String CHARSET = "utf-8";
	private static final String BROADCAST_IP = "230.0.0.1";
	// 定义广播端口
	// 约定私聊端口 = 广播端口 + 1
	private static final int BROADCAST_PORT = 30000;
	private static final int DATA_LEN = 4096;
	private byte[] inBuff = new byte[DATA_LEN];
        private DatagramPacket inPacket = new DatagramPacket(inBuff, inBuff.length);	
	private DatagramPacket outPacket = null;
	private MulticastSocket socket;
	private DatagramSocket singleSocket;
	private InetAddress broadcastAddress;
	private LanTalk lanTalk;

	public ComUtil(LanTalk lanTalk) throws Exception {
		this.lanTalk = lanTalk;
		socket = new MulticastSocket(BROADCAST_PORT);	
		socket.setLoopbackMode(false);
		broadcastAddress = InetAddress.getByName(BROADCAST_IP);
		socket.joinGroup(broadcastAddress);
		singleSocket = new DatagramSocket(BROADCAST_PORT + 1);
		outPacket = new DatagramPacket(new byte[0], 0, broadcastAddress, BROADCAST_PORT);
		new ReadSingle().start();
		Thread.sleep(1);
		new ReadBroad().start();
	}

	public void broadCast(String msg) {
		try {
			byte[] msgData = msg.getBytes(CHARSET);	
			outPacket.setData(msgData);
			socket.send(outPacket);
		} catch (IOException ioe) {
			ioe.printStackTrace();
			if (socket != null) {
				socket.close();
			}	
			JOptionPane.showMessageDialog(null, "发送消息异常，请确认30000端口空闲，且网络连接正常", "网络异常", 
					JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}	
	}

	public void sendSingle(String msg, SocketAddress dest) {
		try {
			byte[] msgData = msg.getBytes(CHARSET);	
			DatagramPacket packet = new DatagramPacket(msgData, msgData.length, dest);
			singleSocket.send(packet);
		} catch (IOException ioe) {
			ioe.printStackTrace();
			if (singleSocket != null) {
				singleSocket.close();
			}
			JOptionPane.showMessageDialog(null, "发送消息异常，请确认30001端口空闲，且网络连接正常", "网络异常",
				       JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
	}

	class ReadSingle extends Thread {
		@Override
		public void run() {
			byte[] singleInBuff = new byte[DATA_LEN];
			DatagramPacket singleInPacket = new DatagramPacket(singleInBuff, singleInBuff.length);
			while (true) {
				try {
					singleSocket.receive(singleInPacket);
					lanTalk.processMsg(singleInPacket, true);
				} catch (IOException ioe) {
					ioe.printStackTrace();
					if (singleSocket != null) {
						singleSocket.close();
					}
					JOptionPane.showMessageDialog(null, "发送消息异常，请确认30001端口空闲，且网络连接正常", 
							"网络异常", JOptionPane.ERROR_MESSAGE);
					System.exit(1);
				}
			}	
		}
	}

	class ReadBroad extends Thread {
		@Override
		public void run() {
			while (true) {
				try {
					socket.receive(inPacket);
					String msg = new String(inPacket.getData(), 0 , inPacket.getLength(), CHARSET);
					if (msg.startsWith(ChatProtocol.PRESENCE) && msg.endsWith(ChatProtocol.PRESENCE)) {
						String[] inMsgInfo = msg.substring(2, msg.length() - 2).split(ChatProtocol.SPLITTER);
						UserInfo user = new UserInfo(inMsgInfo[1], inMsgInfo[0], inPacket.getSocketAddress(), 0);
						// 控制是否需要添加该用户
						boolean addFlag = true;
						ArrayList<Integer> delList = new ArrayList<Integer>();
						for (int i = 1; i < lanTalk.getUserNum(); i++) {
							UserInfo currentUser = lanTalk.getUser(i);
							currentUser.setLost(currentUser.getLost() + 1);
							if (currentUser.equals(user)) {
								currentUser.setLost(0);
								addFlag = false;
							}
							if (currentUser.getLost() > 2) {
								delList.add(i);
							}
						}
						for (int i : delList) {
							lanTalk.removeUser(i);
						}
						if (addFlag) {
							lanTalk.addUser(user);
						}
					} else {
						lanTalk.processMsg(inPacket, false);
					}

				} catch (IOException ioe) {
					ioe.printStackTrace();
					if (singleSocket != null) {
						singleSocket.close();
					}
					JOptionPane.showMessageDialog(null, "发送消息异常，请确认30000端口空闲，且网络连接正常", 
							"网络异常", JOptionPane.ERROR_MESSAGE);
					System.exit(1);
				}
			}	
		}
	}
}
