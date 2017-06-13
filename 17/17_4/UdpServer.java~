import java.net.DatagramSocket;
import java.net.DatagramPacket;

public class UdpServer {
	public static final int PORT = 30000;
	private static final int DATA_LEN = 4096;
	byte[] inBuff = new byte[DATA_LEN];
	private DatagramPacket inPacket = new DatagramPacket(inBuff, inBuff.length);
	private DatagramPacket outPacket;
	private String[] books = new String[] {
		"德国",
		"英国",
		"美国",
		"中国"
	};
	
	public void init() throws Exception {
		try (DatagramSocket socket = new DatagramSocket(PORT)) {
			for (int i = 0; i < 1000; i++) {
				socket.receive(inPacket);
				System.out.println(inBuff == inPacket.getData());
				System.out.println("收到信息：" + new String(inBuff, 0, inBuff.length));
				byte[] sendData = books[i % 4].getBytes();
				outPacket = new DatagramPacket(sendData, sendData.length, inPacket.getSocketAddress());
				socket.send(outPacket);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		new UdpServer().init();	
	}
}
