import java.util.Scanner;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.channels.Selector;
import java.nio.channels.SelectionKey;
import java.nio.charset.Charset;
import java.io.IOException;

public class NClient {
	private Selector selector = null;
	private Charset charset = Charset.forName("UTF-8");	
	static final int PORT = 30000;
	private SocketChannel sc = null;
	
	public void init() throws IOException {
		selector = Selector.open();	
		InetSocketAddress isa = new InetSocketAddress("127.0.0.1", PORT);
		sc = SocketChannel.open(isa);	
		sc.configureBlocking(false);
		sc.register(selector, SelectionKey.OP_READ);
		new ClientThread().start();
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			sc.write(charset.encode(line));
		}
	}

	class ClientThread extends Thread {
		@Override
		public void run() {
			//System.out.println("CleintThread run()");
			try {
				while (selector.select() > 0) {
					//System.out.println("收到服务器消息");
					for (SelectionKey sk : selector.selectedKeys()) {
						selector.selectedKeys().remove(sk);
						if (sk.isReadable()) {
							SocketChannel sc = (SocketChannel)sk.channel();
							ByteBuffer buff = ByteBuffer.allocate(1024);
							String content = "";
							while (sc.read(buff) > 0) {
								//System.out.println("sc.read(buff) > 0");
								buff.flip();
								content += charset.decode(buff);
							}
							System.out.println("聊天信息：" + content);
							sk.interestOps(SelectionKey.OP_READ);	
						}
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}	
		}
	}

	public static void main(String[] args) throws IOException {
		new NClient().init();	
	}
}
