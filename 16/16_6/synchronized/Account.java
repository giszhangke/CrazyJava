public class Account {
	private String accountNO;
	private double balance;
	// 标识是否已有存款
	private boolean flag = false;

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

	public synchronized void draw(double drawAmount) {
		try {
			if (!flag) {
				wait();
			} else if (balance >= drawAmount) {
				System.out.println(Thread.currentThread().getName() + " 取钱成功，吐出钞票：" + drawAmount);
				try {
					Thread.sleep(1);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				setBalance(getBalance() - drawAmount);
				System.out.println(Thread.currentThread().getName() + "\t 余额为：" + getBalance());
				// 将存款标识设置为false
				flag = false;
				// 唤醒其他线程
				notifyAll();
			} else {
				System.out.println(Thread.currentThread().getName() + " 取钱失败，余额不足");
			}
		} catch (InterruptedException iex) {
			iex.printStackTrace();
		}
	}

	public synchronized void deposit(double depositAmount) {
		try {
			if (flag) {
				wait();
			} else {
				System.out.println(Thread.currentThread().getName() + "存款：" + depositAmount);
				balance += depositAmount;
				System.out.println(Thread.currentThread().getName() + "余额为：" + balance);
				flag = true;
				notifyAll();
			}
		} catch (InterruptedException iex) {
			iex.printStackTrace();
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
