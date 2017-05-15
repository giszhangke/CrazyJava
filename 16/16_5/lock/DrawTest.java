public class DrawTest {
	public static void main(String[] args) {
		Account acc = new Account("1234678", 1000);
		new DrawThread("甲", acc, 800).start();
		new DrawThread("乙", acc, 800).start();
	}
}
