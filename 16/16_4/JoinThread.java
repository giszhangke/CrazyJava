public class JoinThread extends Thread {
	public JoinThread(String name) {
		super(name);
	}
	public void run() {
		for (int i = 0; i < 100; i++ ) {
			System.out.println(getName() + " " + i);
		}
	}
	public static void main(String[] args) throws Exception {
		new JoinThread("新线程").start();
		for (int i = 0; i < 100; i++ ) {
			if (i == 20) {
				JoinThread jt = new JoinThread("被Join的线程");
				jt.start();
				// main线程调用了jt线程的join()方法
				// 所以main线程必须等到jt执行结束才会向下执行
				// 但是"新线程"还是可以继续执行
				jt.join();
			}
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}
}