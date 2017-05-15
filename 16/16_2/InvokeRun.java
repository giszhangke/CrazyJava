public class InvokeRun extends Thread {
	private int i;

	public void run() {
		for ( ; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}	
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			if (i == 20) {
				// 直接调用run()方法不会启动一个新线程
				// 所有程序中是有主线程
				new InvokeRun().run();
				new InvokeRun().run();
			}
		}
	}
}
