import java.util.concurrent.FutureTask;
import java.util.concurrent.Callable;

public class ThirdThread {
	public static void main(String[] args) throws Exception {
		FutureTask<Integer> ft = new FutureTask<Integer>((Callable<Integer>) () -> {
			int i = 0;
			for ( ; i < 100; i++) {
				System.out.println(Thread.currentThread().getName() + " " + i);
			}
			return i;
		});
		for (int i=0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			if (i == 20) {
				new Thread(ft, "有返回值的线程").start();
				Thread.sleep(1);
				/*
				try {
					// FutureTask类实例的get()方法会阻塞
					System.out.println("子线程的返回值: " + ft.get());
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				*/
			}
			
		}
		/*
		try {
			System.out.println("子线程的返回值: " + ft.get());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		*/
	}
}
