import java.net.URL;
import java.net.Proxy;
import java.net.InetSocketAddress;
import java.net.URLConnection;
import java.net.MalformedURLException;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintStream;

public class ProxyTest
{
	//�����Ǵ���������ĵ�ַ�Ͷ˿�
	//����ʵ����Ч�Ĵ���������ĵ�ַ�Ͷ˿�
	final String PROXY_ADDR = "192.168.0.10";
	final int PROXY_PORT = 80;
	//������Ҫ���ʵ���վ��ַ
	//String urlStr = "http://www.crazyit.org";
	String urlStr = "http://127.0.0.1/kunshan";

	public void init()
		throws IOException, MalformedURLException
	{
		URL url = new URL(urlStr);
		//����һ���������������
		Proxy proxy = new Proxy(Proxy.Type.HTTP
			,new InetSocketAddress(PROXY_ADDR, PROXY_PORT));
		//ʹ��ָ���Ĵ��������������
		URLConnection conn = url.openConnection(proxy);
		//���ó�ʱʱ��
		conn.setConnectTimeout(3000);
		try(
			//ͨ�������������ȡ���ݵ�Scanner
			Scanner scan = new Scanner(conn.getInputStream());
			//PrintStream ps = new PrintStream("index.htm")
			PrintStream ps = new PrintStream("login.aspx")
			)
		{
			while(scan.hasNextLine())
			{
				String line = scan.nextLine();
				//�ڿ���̨�����ҳ��Դ����
				System.out.println(line);
				//����ҳ��Դ���������ָ�������
				ps.println(line);
			}
		}
	}

	public static void main(String[] args)
		throws IOException, MalformedURLException
	{
		new ProxyTest().init();
	}

}

