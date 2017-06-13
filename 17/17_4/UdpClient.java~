import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpClient {
	private static final int PORT = 30000;
	private static final String DEST_IP = "127.0.0.1";
	private static final int DATA_LEN = 4096;
	private byte[] buff = new byte[DATA_LEN];
	private DatagramPacket inPacket = new DatagramPacket(buff, buff.length);
	private DatagramPacket outPacket;
	
	public void init() throws Exception {
		try (DatagramSocket socket = new DatagramSocket()) {
			outPacket = new DatagramPacket(new byte[0], 0, InetAddress.getByName(DEST_IP), PORT);
			Scanner scanner = new Scanner(System.in);
			while (scanner.hasNextLine()) {
				byte[] outData = scanner.nextLine().getBytes();
				outPacket.setData(outData);
				socket.send(outPacket);
				socket.receive(inPacket);
				System.out.println("收到消息：" + new String(inPacket.getData(), 0, inPacket.getLength()));
			}
		}
	}

	public static void main(String[] args) throws Exception {
		new UdpClient().init();
	}
}
