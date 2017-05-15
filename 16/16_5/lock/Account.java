import java.util.concurrent.locks.ReentrantLock;

public class Account {
	// 定义锁对象
	private final ReentrantLock lock = new ReentrantLock();
	private String accountNO;
	private double balance;
	
	public Account() {}

	public Account(String accountNO, double balance) {
		this.accountNO = accountNO;
		this.balance = balance;
	}

	public void setAccountNO(String accountNO) {
		this.accountNO = accountNO;
	}

	public String getAccountNO() {
		return this.accountNO;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return this.balance;
	}

	public void draw(double drawAmount) {
		// 加锁
		lock.lock();
		try {
			if (balance >= drawAmount) {
				System.out.println(Thread.currentThread().getName() + " 取钱成功，吐出钞票：" + drawAmount);
				try {
					Thread.sleep(1);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				setBalance(getBalance() - drawAmount);
				System.out.println(Thread.currentThread().getName() + "\t 余额为：" + getBalance());
			} else {
				System.out.println(Thread.currentThread().getName() + " 取钱失败，余额不足");
			}
		} finally {
			// 释放锁
			lock.unlock();
		}
		
	}

	@Override
	public int hashCode() {
		return accountNO.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if ( obj != null && obj.getClass() == Account.class) {
			Account target = (Account)obj;
			return target.getAccountNO().equals(accountNO);
		}

		return false;
	}
}
