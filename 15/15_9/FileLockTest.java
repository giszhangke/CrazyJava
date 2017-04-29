import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
public class FileLockTest {
	public static void main(String[] args) {
		try (FileChannel fc = new FileOutputStream("a.txt").getChannel()) {
			// 使用非阻塞的方式对指定文件加锁
			FileLock lock = fc.tryLock();
			// 主线程暂停10s
			Thread.sleep(10000);
			// 释放锁
			lock.release();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
