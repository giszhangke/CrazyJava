import java.io.StringReader;
import java.io.StringWriter;
import java.io.IOException;

public class StringNodeTest {
	public static void main(String[] args) {
		String src = "从明天起做一个幸福的人\n"
			+ "喂马，劈柴，周游世界\n"
			+ "从明天起关心粮食和蔬菜\n"
			+ "我有一所房子面朝大海春暧花开\n"
			+ "从明天起和第一个新人通信\n"
			+ "告诉他们我的幸福\n";	
		char[] cbuf = new char[1024];
		int hasRead = 0;

		try (StringReader sr = new StringReader(src)) {
			while ((hasRead = sr.read(cbuf)) > 0) {
				System.out.print(new String(cbuf, 0, hasRead));
			}			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		try (StringWriter sw = new StringWriter()) {
			sw.write("有一个美丽的新世界，\n");
			sw.write("她在远方等我，\n");
			sw.write("那里有天真的孩子，\n");
			sw.write("还有姑娘的酒窝\n");
			System.out.println(sw.toString());	
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
