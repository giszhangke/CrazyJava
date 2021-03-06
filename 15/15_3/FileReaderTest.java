import java.io.FileReader;
import java.io.BufferedReader;

public class FileReaderTest {
	public static void main(String[] args) throws Exception {
		/*
		try (FileReader fileReader = new FileReader("FileReaderTest.java")) {
			char[] cbuf = new char[1024];
			int hasRead = 0;
			while ((hasRead = fileReader.read(cbuf)) > 0) {
				System.out.print(FileReaderTest.convertStringToGBK(new String(cbuf, 0, hasRead)));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		*/
		// 使用BufferedReader输出
		// 测试中文是不是乱码测试中文是不是乱码测试中文是不是乱码测试中文是不是乱码测试中文是不是乱码测试中文是不是乱码测试中文是不是乱码
		// 测试中文是不是乱码测试中文是不是乱码测试中文是不是乱码测试中文是不是乱码测试中文是不是乱码测试中文是不是乱码测试中文是不是乱码
		// 测试中文是不是乱码测试中文是不是乱码测试中文是不是乱码测试中文是不是乱码测试中文是不是乱码测试中文是不是乱码测试中文是不是乱码
		// 测试中文是不是乱码测试中文是不是乱码测试中文是不是乱码测试中文是不是乱码测试中文是不是乱码测试中文是不是乱码测试中文是不是乱码
		// 创建字节输入流
		// 测试中文是不是乱码测试中文是不是乱码测试中文是不是乱码测试中文是不是乱码测试中文是不是乱码测试中文是不是乱码测试中文是不是乱码
			// 取出"竹筒"中的水，即本次循环取到的字节数据 
			// 将字节数组转换成字符串
		// 把字符串str的编码转换成Java默认的编码UTF-8
		// 把字符串strUtf8的编码转换成GBK编码
		// 测试中文是不是乱码测试中文是不是乱码测试中文是不是乱码测试中文是不是乱码测试中文是不是乱码测试中文是不是乱码测试中文是不是乱码
		// 测试中文是不是乱码测试中文是不是乱码测试中文是不是乱码测试中文是不是乱码测试中文是不是乱码测试中文是不是乱码测试中文是不是乱码
		// 测试中文是不是乱码测试中文是不是乱码测试中文是不是乱码测试中文是不是乱码测试中文是不是乱码测试中文是不是乱码测试中文是不是乱码
		try (FileReader fileReader = new FileReader("FileReaderTest.java");
		     BufferedReader br = new BufferedReader(fileReader)) {
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(FileReaderTest.convertStringToGBK(line));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}	
	}

	public static String convertStringToGBK(String str) throws Exception {
		String strUtf8 = new String(str.getBytes(), "UTF-8");
		return new String(strUtf8.getBytes("GBK"));
	}
}
