import java.io.IOException;
import java.io.FileReader;
import java.io.PushbackReader;

public class PushbackReaderTest {
	public static void main(String[] args) {
		try (
			// 创建一个PushbackReader对象，指定推回缓冲区的长度
			PushbackReader pr = new PushbackReader(new FileReader("PushbackReaderTest.java"), 64)) {
			char[] buf = new char[32];
			// 用来保存上次读取的内容
			String lastContent = "";
			int hasRead = 0;
			// 循环读取文件内容
			while ((hasRead = pr.read(buf)) > 0) {
				// 将本读取到的内容转换成字符串
				String content = new String(buf, 0, hasRead);
				int textIndex = 0;
				// 将上次读取的内容和本次读取的内容拼接起来，判断是包含字符串"new PushbackReader"
				if ((textIndex = (lastContent + content).indexOf("new PushbackReader")) > 0) {
					// 将上次内容和本次内容推回到缓冲区
					pr.unread((lastContent + content).toCharArray());
					if (textIndex > 32) {
						buf = new char[textIndex];
					}
					// 再次读取指定长度的内容（即目标字符串之前的内容）
					pr.read(buf, 0, textIndex);
					System.out.print(new String(buf, 0, textIndex));
					System.exit(0);
				}
				else {
					// 打印上次读取的内容
					System.out.print(lastContent);
					// 更新上次读取的内容
					lastContent = content;
				}
			}	
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
