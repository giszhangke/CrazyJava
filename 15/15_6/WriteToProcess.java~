import java.util.Scanner;
import java.io.IOException;
import java.io.PrintStream;
import java.io.FileOutputStream;

public class WriteToProcess {
	public static void main(String[] args) throws IOException {
		Process p = Runtime.getRuntime().exec("java ReadStandard");	
		// 获取当前程序到目标进程p的输出流
		// 同时也是进程p的输入流
		try (PrintStream ps = new PrintStream(p.getOutputStream())) {
			ps.println("哈哈哈哈！我就是大圣。。");
			ps.println(new WriteToProcess());
		}
	}
}

class ReadStandard {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in);
		     PrintStream ps = new PrintStream(new FileOutputStream("outProcess.txt"))) {
			//sc.useDelimiter("\n");
			while (sc.hasNext()) {
				ps.println(sc.next());
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
