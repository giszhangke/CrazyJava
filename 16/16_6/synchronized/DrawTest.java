public class DrawTest {
	public static void main(String[] args) {
		Account account = new Account("1234567", 0);
		new DrawThread("取钱的甲", account, 800).start();
		new DepositThread("存钱的乙", account, 800).start();
		new DepositThread("存钱的丙", account, 800).start();
		new DepositThread("存钱的丁", account, 800).start();
	}
}
