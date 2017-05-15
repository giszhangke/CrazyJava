public class Account {
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

	public synchronized void draw(double drawAmount) {
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
