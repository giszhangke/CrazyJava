import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ProxySelector;
import java.net.Proxy;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.SocketAddress;
import java.net.InetSocketAddress;

public class ProxySelectorTest {
	//final String PROXY_ADDR = "139.82.12.188";	
	//final int PROXY_PORT = 3124;
	final String PROXY_ADDR = "45.78.31.216";	
	final int PROXY_PORT = 443;
	String urlStr = "http://www.baidu.com";
	
	public void init() throws IOException, MalformedURLException {
		ProxySelector.setDefault(new ProxySelector() {
			@Override
			public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {	
				System.out.println("无法连接到指定的代理服务器!");
			}

			@Override
			public List<Proxy> select(URI uri) {
				List<Proxy> result = new ArrayList<Proxy>();	
				result.add(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(PROXY_ADDR, PROXY_PORT)));
				return result;
			}
		});

		URL url = new URL(urlStr);
		URLConnection conn = url.openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
	}

	public static void main(String[] args) throws IOException, MalformedURLException {
		new ProxySelectorTest().init();
	}
}
