import java.net.MulticastSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.Scanner;
import java.io.IOException;

public class MulticastSocketTest implements Runnable {
	private static final String BROADCAST_IP = "230.0.0.1";
	private static final int BROADCAST_PORT = 30000;
	private static final int DATA_LEN = 4096;
	private byte[] inBuff = new byte[DATA_LEN];
	private InetAddress broadcastAddress = null;
	private MulticastSocket socket = null;
	private DatagramPacket inPacket = new DatagramPacket(inBuff, inBuff.length);
	private DatagramPacket outPacket = null;
	
	public void init() throws IOException {
		try (Scanner scan = new Scanner(System.in)) {
			socket = new MulticastSocket(BROADCAST_PORT);
			broadcastAddress = InetAddress.getByName(BROADCAST_IP);
			socket.joinGroup(broadcastAddress);
			socket.setLoopbackMode(false);
			outPacket = new DatagramPacket(new byte[0], 0, broadcastAddress, BROADCAST_PORT);
			new Thread(this).start();
			while (scan.hasNextLine()) {
				byte[] outBuff = scan.nextLine().getBytes();
				outPacket.setData(outBuff);
				socket.send(outPacket);
			}
		} finally {
			socket.close();
		}		
	}

	@Override
	public void run() {
		try {
			socket.receive(inPacket);
			System.out.println("收到消息: " + new String(inBuff, 0, inBuff.length));
		} catch (IOException ex) {
			ex.printStackTrace();
			try {
				if (socket != null) {
					socket.leaveGroup(broadcastAddress);
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws IOException {
		new MulticastSocketTest().init();	
	}
}
