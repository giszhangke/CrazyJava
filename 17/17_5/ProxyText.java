import java.net.URLConnection;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.InetSocketAddress;
import java.net.URL;
import java.util.Scanner;
import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.io.IOException;
import java.io.InputStream;

public class ProxyText {
	private final static String IP_ADDRESS = "129.82.12.188";
	private final static int PORT = 3124;	
	private final static String urlStr = "http://www.baidu.com";

	public void init() throws IOException, MalformedURLException {
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(IP_ADDRESS, PORT));
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection(proxy);	
		/*
		conn.setConnectTimeout(5 * 1000);	
		conn.setRequestMethod("POST");
		*/
		//conn.setRequestProperty("Accept", "*/*");
		/*
		conn.setRequestProperty("Connection", "Keep-Alive");
		conn.setDoOutput(true);
		conn.setDoInput(true);
		*/
		InputStream in = conn.getInputStream();
		try (
			BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
			PrintStream printer = new PrintStream("index.htm");
		) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				printer.println(line);
			}
		}
		conn.disconnect();
	}

	public static void main(String[] args) throws IOException, MalformedURLException {
		ProxyText pt = new ProxyText();
		pt.init();	
	}
}
