import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class FileOutputStreamTest {
	public static void main(String[] args) {
		try (   // 创建输入流
			FileInputStream fileInputStream = new FileInputStream("FileOutputStreamTest.java");
			// 创建输出流
			FileOutputStream fileOutputStream = new FileOutputStream("CopyFileOutputStreamTest.txt")) {
			byte[] bbuf = new byte[32];
			int hasRead = 0;
			// 循环取出输入流中数据
			// 多写一点中文看看乱码不乱码, 多写一点中文看看乱码不乱码, 多写一点中文看看乱码不乱码
			while ((hasRead = fileInputStream.read(bbuf)) > 0) {
				// 每读取一次，即写入到输出流，读取多少就写入多少
				fileOutputStream.write(bbuf, 0, hasRead);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
