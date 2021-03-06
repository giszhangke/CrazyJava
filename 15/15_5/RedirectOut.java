import java.io.IOException;
import java.io.FileReader;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class RedirectOut {
	public static void main(String[] args) {
		try (FileReader fr = new FileReader("RedirectOut.java");
		     PrintStream ps = new PrintStream(new FileOutputStream("RedirectOut.txt"))) {
			System.setOut(ps);
			char[] buf = new char[1024];
			int hasRead = 0;
			while ((hasRead = fr.read(buf)) > 0) {
				System.out.println(new String(buf, 0, hasRead));
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}	
	}
}
