public class SleepThread extends Thread {
	public void run() {
		for (int i = 0; i < 10; i++ ) {
			System.out.println(getName() + " " + i);
			// 调用Thread类的静态sleep方法进行阻塞状态
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		new SleepThread().start();
	}
}
