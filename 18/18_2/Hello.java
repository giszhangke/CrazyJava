public class Hello {
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("Hello的参数为0个");
			return;
		}

		for (String arg : args) {
			System.out.println(arg);
		}
	}
}
