public class Varargs
{
	public static void test(int a, String... books)	{
		for (String book : books) {
			System.out.println(book);
		}

		System.out.println(a);
	}

	public static void main(String[] args) {
		String[] books = {"��4", "��5", "��6", "��7"};

		Varargs.test(3, "��1", "��2", "��3");
		Varargs.test(books.length, books);		
	}

}