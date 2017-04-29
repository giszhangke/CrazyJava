import java.io.IOException;
import java.io.FileInputStream;

public class FileInputStreamTest {
	public static void main(String[] args) throws Exception {
		// 创建字节输入流
		FileInputStream fileInputStream = new FileInputStream("FileInputStreamTest.java");
		// 创建一个长度为1024的"竹筒"
		byte[] bbuf = new byte[1024];
		// 每次实际读取的字节数，即每次"取水"的长度
		int hasRead = 0;
		// 使用循环来重复"取水"
		while ((hasRead = fileInputStream.read(bbuf)) > 0) {
			// 取出"竹筒"中的水，即本次循环取到的字节数据 
			// 将字节数组转换成字符串
			System.out.print(FileInputStreamTest.convertStringToGBK(new String(bbuf, 0, hasRead)));
		}
		// 关闭文件输入流，放在finally块里更安全
		fileInputStream.close();
	}
	
	public static String convertStringToGBK(String str) throws Exception {
		String strUtf8;
		// 把字符串str的编码转换成Java默认的编码UTF-8
		// 把字符串strUtf8的编码转换成GBK编码
		strUtf8 = new String(str.getBytes(), "UTF-8");
		return new String(strUtf8.getBytes("GBK"));

	}
}
