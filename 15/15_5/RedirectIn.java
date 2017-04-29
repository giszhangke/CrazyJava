import java.io.IOException;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RedirectIn {
	public static void main(String[] args) {
		try (FileInputStream fis = new FileInputStream("RedirectIn.java")) {
			System.setIn(fis);
			try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
				String line = "";
				while ((line = br.readLine()) != null) {
					System.out.println(line);
				}
			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}	
	}
}
