import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.Channel;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.io.IOException;

public class NServer {
	private Selector selector = null;
	static final int PORT = 30000;
	private Charset charset = Charset.forName("UTF-8");
	
	public void init() throws IOException {
		selector = Selector.open();	
		ServerSocketChannel server = ServerSocketChannel.open();
		InetSocketAddress isa = new InetSocketAddress("127.0.0.1", PORT);
		server.bind(isa);
		server.configureBlocking(false);
		server.register(selector, SelectionKey.OP_ACCEPT);
		System.out.println("===========服务启动成功==========");
		while (selector.select() > 0) {
			//System.out.println("while section");
			for (SelectionKey sk : selector.selectedKeys()) {
				//System.out.println("for section");
				selector.selectedKeys().remove(sk);
				if (sk.isAcceptable()) {
					//System.out.println("isAcceptable");
					SocketChannel sc = server.accept();
					sc.configureBlocking(false);
					sc.register(selector, SelectionKey.OP_READ);
					sk.interestOps(SelectionKey.OP_ACCEPT);
				} 	
				if (sk.isReadable()) {
					//System.out.println("isReadable");
					SocketChannel sc = (SocketChannel)sk.channel();
					ByteBuffer buff = ByteBuffer.allocate(1024);
					String content = "";
					try {
						while (sc.read(buff) > 0) {
							buff.flip();
							content += charset.decode(buff);
						}
						System.out.println("接收到客户端的数据：" + content);
						sk.interestOps(SelectionKey.OP_READ);
					} catch (IOException iex) {
						// 删除指定的SelectKey
						sk.cancel();
						if (sk.channel() != null) {
							sk.channel().close();
						}
					}
					if (content.length() > 0) {
						for (SelectionKey key : selector.keys()) {
							Channel s = key.channel();
							if (s instanceof SocketChannel) {
								SocketChannel dest = (SocketChannel)s;
								dest.write(charset.encode(content));
							}
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		new NServer().init();
	}
}
