import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.charset.Charset;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.CompletionHandler;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AIOServer {
	static final String UTF_8 = "utf-8";
	static final int PORT = 30000;
	static List<AsynchronousSocketChannel> channelList = new ArrayList<>();

	public void startListen() throws InterruptedException, Exception {
		ExecutorService executor = Executors.newFixedThreadPool(20);
		AsynchronousChannelGroup channelGroup = AsynchronousChannelGroup.withThreadPool(executor);
		AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel.open(channelGroup)
			.bind(new InetSocketAddress(PORT));
		System.out.println("=========服务启动成功========");
		serverChannel.accept(null, new AcceptHandler(serverChannel));
		Thread.sleep(5000);
	}

	public static void main(String[] args) throws Exception {
		AIOServer server = new AIOServer();
		server.startListen();	
	}

	class AcceptHandler implements CompletionHandler<AsynchronousSocketChannel, Object> {	
		private AsynchronousServerSocketChannel serverChannel = null;
		ByteBuffer buff = ByteBuffer.allocate(1024);

		public AcceptHandler(AsynchronousServerSocketChannel sc) {
			serverChannel = sc;
			System.out.println("AcceptHandler");
		}

		@Override
		public void completed(final AsynchronousSocketChannel socketChannel, Object attachment) {
			System.out.println("connect compledted");
			AIOServer.channelList.add(socketChannel);
			serverChannel.accept(null, this);
			socketChannel.read(buff, null, new CompletionHandler<Integer, Object>() {
				@Override
				public void completed(Integer result, Object attachment) {
					System.out.println("read compledted");
					buff.flip();
					String content = StandardCharsets.UTF_8.decode(buff).toString();	
					for (AsynchronousSocketChannel c : AIOServer.channelList) {
						try {
							c.write(ByteBuffer.wrap(content.getBytes(AIOServer.UTF_8))).get();
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
					buff.clear();
					socketChannel.read(buff, null, this);
				}
				@Override
				public void failed(Throwable ex, Object attachment) {
					System.out.println("读取数据失败：" + ex);	
					AIOServer.channelList.remove(socketChannel);
				}
				
			});
		}

		@Override
		public void failed(Throwable ex, Object attachment) {
			System.out.println("连接失败：" + ex);
		}
	}
}
