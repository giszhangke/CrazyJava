public class StartDead extends Thread {
	private int i;
	public void run() {
		for ( ; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}
	public static void main(String[] args) {
		StartDead sd = new StartDead();
		for (int i = 0; i < 300; i++ ) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			if (i == 20) {
				sd.start();
				System.out.println("sd线程的存活状态: " + sd.isAlive());
			}
			if (i > 20 && !sd.isAlive()) {
				System.out.println("sd线程的存活状态: " + sd.isAlive());
				sd.start();
			}
		}
	}
}
