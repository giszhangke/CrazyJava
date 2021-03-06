import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
	public static void main(String[] args) {
		try (RandomAccessFile raf = new RandomAccessFile("RandomAccessFileTest.java", "r")) {
			System.out.println("RandomAccessFileTest.java的初始文件指针位置：" + raf.getFilePointer());
			raf.seek(302);
			byte[] buffer = new byte[1024];
			int hasRead = 0;
			while ((hasRead = raf.read(buffer)) > 0) {
				System.out.print(new String(buffer, 0, hasRead));
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
