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

public class ProxySelectorTest2 extends ProxySelector
{
	final String PROXY_ADDR = "192.168.0.10";
	final int PROXY_PORT = 88;
	String urlStr = "http://127.0.0.1/kunshan";

	
	@Override
	public void connectFailed(URI uri,
                                   SocketAddress sa,
                                   IOException ioe)
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

	public static void main(String[] args)
		throws IOException, MalformedURLException
	{
		ProxySelectorTest2 pst = new ProxySelectorTest2();
	}
}
