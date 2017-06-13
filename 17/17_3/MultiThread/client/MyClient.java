import java.net.Socket;
import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MyClient {
        private final static String IP = "127.0.0.1";
	private final static int PORT = 3000;
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket(IP, PORT);
		new Thread(new ClientThread(socket)).start();
		PrintStream ps = new PrintStream(socket.getOutputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		while ((line = br.readLine()) != null) {
			// 把键盘输入的字符输出到socket对应的输出流
			ps.print(line);
			socket.shutdownOutput();
			System.out.println("本客户端输入：" + line);
		}
	}
}
