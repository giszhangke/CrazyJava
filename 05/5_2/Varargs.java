public class Varargs
{
	public static void test(int a, String... books)	{
		for (String book : books) {
			System.out.println(book);
		}

		System.out.println(a);
	}

	public static void main(String[] args) {
		String[] books = {"书4", "书5", "书6", "书7"};

		Varargs.test(3, "书1", "书2", "书3");
		Varargs.test(books.length, books);		
	}

}
