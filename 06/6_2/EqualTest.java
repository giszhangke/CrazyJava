public class EqualTest
{
	public static void main(String[] args) {
		int i = 65;
		float f = 65.0f;
		char c = 'A';

		System.out.println("i == f : " + (i == f));
		System.out.println("i == c : " + (i == c));

		String h1 = new String("hello");
		String h2 = new String("hello");		

		System.out.println("h1 == h2 : " + (h1 == h2)); 				System.out.println("h1.equals(h2): " + h1.equals(h2));

	}
}
