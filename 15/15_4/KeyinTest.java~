import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class KeyinTest {
	public static void main(String[] args) {
		try (InputStreamReader isr = new InputStreamReader(System.in);
		     BufferedReader br = new BufferedReader(isr)) {
			String line = null;
			while ((line = br.readLine()) != null) {
				if (line.equals("exit")) {
					System.exit(1);
				}
				System.out.println("输入的内容为：" + line);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
