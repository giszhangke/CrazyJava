import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
	public static List<Socket> socketList = Collections.synchronizedList(new ArrayList<>());	
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(3000);
		System.out.println("===========服务器已经启============");
		while (true) {
			Socket s = ss.accept();
			socketList.add(s);
			new Thread(new ServerThread(s)).start();
		}
	}
}
