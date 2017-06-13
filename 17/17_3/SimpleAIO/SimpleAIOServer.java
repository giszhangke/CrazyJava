import java.util.concurrent.Future;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.net.InetSocketAddress;

public class SimpleAIOServer {
	static final int PORT = 30000;
	public static void main(String[] args) throws Exception {
		try (AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel.open()) {
			serverChannel.bind(new InetSocketAddress("127.0.0.1", PORT));
			while (true) {
				Future<AsynchronousSocketChannel> future = serverChannel.accept();
				AsynchronousSocketChannel socketChannel = future.get();
				socketChannel.write(ByteBuffer.wrap("欢迎来到AIO".getBytes("UTF-8"))).get();
			}
		}
	}
}
