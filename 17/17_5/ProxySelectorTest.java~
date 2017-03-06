import java.net.URL;
import java.net.URI;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.InetSocketAddress;
import java.net.URLConnection;
import java.net.MalformedURLException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintStream;

public class ProxySelectorTest
{
	final String PROXY_ADDR = "112.22.33.33";
	final int PROXY_PORT = 3124;
	String urlStr = "http://127.0.0.1/kunshan";

	public void init()
		throws IOException, MalformedURLException
	{
		ProxySelector.setDefault(new ProxySelector()
		{
			@Override
			public void connectFailed(URI uri, SocketAddress sa, IOException ioe)
			{
				System.out.println("SB, 这样是无法连接到指定的代理服务器的！");
			}

			@Override
			public List<Proxy> select(URI uri)
			{
				List<Proxy> result = new ArrayList<>();
				result.add(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(PROXY_ADDR, PROXY_PORT)));
				return result;
			}
		});
		
		URL url = new URL(urlStr);
		URLConnection conn = url.openConnection();
		conn.setConnectTimeout(1000);
		
		try(
			Scanner scan = new Scanner(conn.getInputStream());
			PrintStream ps = new PrintStream("Login.aspx"))
		{
			while(scan.hasNextLine())
			{
				String line = scan.nextLine();
				System.out.println(line);
				ps.println(line);
			}
		}
		

	}

	public static void main(String[] args)
		throws IOException, MalformedURLException
	{
		new ProxySelectorTest().init();
	}
}
