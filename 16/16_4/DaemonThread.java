public class DaemonThread extends Thread {
	public void run() {
		for (int i = 0; i < 100; i++ ) {
			System.out.println(getName() + " " + i);
		}
	}
	public static void main(String[] args) {
		DaemonThread dt = new DaemonThread();
		// 设置为后台线程
		dt.setDaemon(true);
		dt.start();
		for (int i = 0; i < 10; i++ ) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}
}
