import java.io.FileInputStream;
import java.nio.channels.FileChannel;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.CharBuffer;
import java.nio.charset.CharsetDecoder;

public class ReadFile {
	public static void main(String[] args) {
		try (
			// 创建一个FileChannel
			FileChannel fc = new FileInputStream("ReadFile.java").getChannel()) {
			// 创建一个ByteBuffer
			ByteBuffer buffer = ByteBuffer.allocate(256);
			while (fc.read(buffer) != -1) {
				// 锁定buffer的空白区
				buffer.flip();
				// 创建Charset对象
				Charset charset = Charset.forName("UTF-8");
				// 创建解码器
				CharsetDecoder decoder = charset.newDecoder();
				// 将ByteBuffer内容转码为
				CharBuffer charBuffer = decoder.decode(buffer);
				System.out.print(charBuffer);
				// 将buffer初始化，为下一次数据读取做准备
				buffer.clear();	
			}
		} catch (Exception ex) {
			System.out.println("\n");
			ex.printStackTrace();
		}
	}
}
