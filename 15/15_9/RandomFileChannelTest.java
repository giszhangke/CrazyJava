import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class RandomFileChannelTest {
	public static void main(String[] args) {
		File f = new File("a.txt");
		try (FileChannel fc = new RandomAccessFile(f, "rw").getChannel()) {
			ByteBuffer buffer = fc.map(FileChannel.MapMode.READ_ONLY, 0, f.length());
			fc.position(f.length());
			fc.write(buffer);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
