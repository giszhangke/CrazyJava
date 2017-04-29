import java.nio.charset.Charset;
import java.util.SortedMap;

public class CharsetTest {
	public static void main(String[] args) {
		SortedMap<String, Charset> charsetMap = Charset.availableCharsets();
		for (String key : charsetMap.keySet()) {
			System.out.println(key + " ------> " + charsetMap.get(key));
		}
	}
}
