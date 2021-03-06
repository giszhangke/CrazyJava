import java.net.InetAddress;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class InetAddressTest {
	public static void main(String[] args) throws Exception {
		InetAddress ip = InetAddress.getByName("www.ifeng.com");
		System.out.println("baidu 是否可达：" + ip.isReachable(3000));
		System.out.println("IP地址为：" + ip.getHostAddress());
		InetAddress local = InetAddress.getByAddress(new byte[]{127, 0, 0, 1});
		System.out.println("local 是否可达：" + local.isReachable(2000));
		System.out.println("local 的全限定域名为：" + local.getCanonicalHostName());
		System.out.println("IP地址为：" + local.getHostAddress());

		String encodedString = "Java%E5%BC%A0%E4%B8%8D%E6%B5%AA";
		System.out.println(URLDecoder.decode(encodedString, "UTF-8"));
		String toBeEncodedString = "Java张不浪";
		System.out.println(URLEncoder.encode(toBeEncodedString, "UTF-8"));
	}
}
