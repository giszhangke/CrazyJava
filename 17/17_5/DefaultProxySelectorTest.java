import java.util.Properties;
import java.util.Scanner;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

public class DefaultProxySelectorTest {
	final static String urlStr = "http://www.baidu.com";
	public static void main(String[] args) throws Exception {
		Properties props = System.getProperties();	
		props.setProperty("http.proxyHost", "192.168.10.96");
		props.setProperty("http.proxyPort", "8080");	
		props.setProperty("http.nonProxyHosts", "localhost|192.168.10.*");
		props.setProperty("https.proxyHost", "192.168.10.96");
		props.setProperty("https.proxyPort", "443");
		props.setProperty("ftp.proxyHost", "192.168.10.96");
		props.setProperty("ftp.proxyProt", "2121");
		props.setProperty("ftp.nonProxyHost", "localhost|192.168.10.*");
		props.setProperty("socket.proxyHost", "192.168.10.96");
		props.setProperty("socket.proxyPort", "1080");
		ProxySelector selector = ProxySelector.getDefault();
		System.out.println("系统默认的代理选择器：" + selector);
		// 根据URI动态决定要使用的代理服务器
		System.out.println("系统为ftp://www.crazyit.org选择的代理服务器为："
				+ ProxySelector.getDefault().select(new URI("ftp://www.crazyit.org")));
		
		URL url = new URL(urlStr);
		URLConnection conn = url.openConnection();
		conn.setConnectTimeout(3 * 1000);
		try (
			Scanner scan = new Scanner(conn.getInputStream(), "utf-8");
		) {
			while (scan.hasNextLine()) {
				System.out.println(scan.nextLine());
			}
		}
	}
}
