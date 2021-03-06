import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.channels.AsynchronousSocketChannel;
import java.net.InetSocketAddress;

public class SimpleAIOClient {
	static final int PORT = 30000;
	public static void main(String[] args) throws Exception {
		ByteBuffer buff = ByteBuffer.allocate(1024);	
		Charset charset = Charset.forName("UTF-8");
		try (AsynchronousSocketChannel socketChannel = AsynchronousSocketChannel.open()) {
			socketChannel.connect(new InetSocketAddress("127.0.0.1", PORT)).get();
			buff.clear();
			socketChannel.read(buff).get();
			buff.flip();
			String content = charset.decode(buff).toString();
			System.out.println("来自服务器的信息：" + content);
		}
	}
}
