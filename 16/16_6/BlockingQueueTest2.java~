import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;

class Producer extends Thread {
	private BlockingQueue<String> bq;

	public Producer(String name, BlockingQueue<String> bq) {
		super(name);
		this.bq = bq;
	}

	@Override
	public void run() {
		String[] stringArr = new String[] {
			"Java",
			"Struts",
			"Spring"
		};
		for (int i = 0; i < 99999; i++ ) {
			System.out.println(getName() + " 生产者准备生产集合元素！");
			try {
				Thread.sleep(200);
				bq.put(stringArr[i % 3]);
			} catch (InterruptedException iex) {
				iex.printStackTrace();
			}
			System.out.println(getName() + " 生产完成：" + bq);
		}
	}
}

class Customer extends Thread {
	private BlockingQueue<String> bq;

	public Customer(String name, BlockingQueue<String> bq) {
		super(name);
		this.bq = bq;
	}

	@Override
	public void run() {
		while (true) {
			System.out.println(getName() + " 消费者准备消费消费集合！");
			try {
				Thread.sleep(200);
				bq.take();
			} catch (InterruptedException iex) {
				iex.printStackTrace();
			}
			System.out.println(getName() + " 消费完成：" + bq);
		}
	}
}

public class BlockingQueueTest2 {
	public static void main(String[] args) {
		BlockingQueue<String> bq = new ArrayBlockingQueue<String>(1);
		new Producer("A", bq).start();
		new Producer("B", bq).start();
		new Producer("C", bq).start();
		new Customer("KING", bq).start();
	}
}
