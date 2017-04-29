import java.io.IOException; 
import java.io.BufferedReader; 
import java.io.InputStreamReader;

public class ReadFromProcess {
	public static void main(String[] args) throws IOException {
		Process p = Runtime.getRuntime().exec("javac");
		try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getErrorStream()))) {
			String line = "";
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}
	}
}
