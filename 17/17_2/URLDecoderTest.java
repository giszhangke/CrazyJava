import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLDecoderTest
{
	public static void main(String[] args)
		throws Exception
	{
		String keyWord = URLDecoder.decode("%E7%96%AF%E7%8B%82java", "utf-8");
		System.out.println(keyWord);
		String urlStr = URLEncoder.encode("·è¿ñAndroid½²Òé", "GBK");
		System.out.println(urlStr);
	}
}
