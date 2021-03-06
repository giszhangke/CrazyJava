import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.MappedByteBuffer;
import java.nio.CharBuffer;

public class FileChannelTest {
	public static void main(String[] args) {
		File f = new File("FileChannelTest.java");
		try (FileChannel inChannel = new FileInputStream(f).getChannel();
		     FileChannel outChannel = new FileOutputStream("a.txt").getChannel()) {
			MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, f.length());
			// 直接输出到outChannel
			outChannel.write(buffer);
			buffer.clear();
			Charset charsetGBK = Charset.forName("GBK");
			CharsetDecoder decoderGBK = charsetGBK.newDecoder();
			CharBuffer charBuffer = decoderGBK.decode(buffer);
			System.out.println(charBuffer);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
