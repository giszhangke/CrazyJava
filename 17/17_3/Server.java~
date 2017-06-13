import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(3000);
		System.out.println("===========服务器已经启动===========");
		while (true) {
			Socket s = ss.accept();
			PrintStream ps = new PrintStream(s.getOutputStream());
			ps.println("您好！您收到了来自服务器的儿童节祝福！");
			ps.close();
			s.close();
		}
	}
}
