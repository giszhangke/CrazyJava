import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintStream;

public class ServerThread implements Runnable {
	private Socket socket = null;
	private BufferedReader bufferedReader = null;	

	public ServerThread(Socket socket) throws IOException {
		this.socket = socket;
		System.out.println("有一个新客户登录了");
		bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}

	@Override
	public void run() {
		try {
			System.out.println("进入到run() 20行");
			String content = null;
			System.out.println("进入到run() 23行");
			while ((content = readFromClient()) != null) {
				System.out.println("来自客户端的消息：" + content);
				// 向服务器的其他客户端发送消息
				for (Socket s : MyServer.socketList) {
					/*
					if (s == socket) {
						continue;
					}
					*/
					PrintStream ps = new PrintStream(s.getOutputStream());
					ps.println(content);
				}
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}	
	}

	private String readFromClient() {
		System.out.println("进入到readFromClient() 42行");
		try {
			System.out.println("进入到readFromClient() 44行");
			String tmp = bufferedReader.readLine();
			System.out.println("来自客户端的消息：" + tmp);
			return tmp;
		} catch (IOException ioe) {
			MyServer.socketList.remove(socket);
			System.out.println("一个客户退出了");
		}
		System.out.println("进入到readFromClient() 53行");
		return null;
	}
}
