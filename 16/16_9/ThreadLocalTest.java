class Account {
	ThreadLocal<String> name = new ThreadLocal<>();
	
	public Account(String str) {
		name.set(str);
		System.out.println("----" + name.get());
	}

	public void setName(String str) {
		name.set(str);
	}

	public String getName() {
		return name.get();
	}
}

class MyThread extends Thread {
	private Account account;

	public MyThread(Account account, String name) {
		super(name);
		this.account = account;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++ ) {
			if (i == 6) {
				account.setName(Thread.currentThread().getName());
			}
			System.out.println(Thread.currentThread().getName() + " " + account.getName() + " 账户的i值为：" + i);
		}	
	}
}

public class ThreadLocalTest {
	public static void main(String[] args) {
		Account account = new Account("初始名称");	
		new MyThread(account, "甲").start();
		new MyThread(account, "乙").start();
	}
}
