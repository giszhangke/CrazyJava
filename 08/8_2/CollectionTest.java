import java.util.Collection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.stream.IntStream;

public class CollectionTest
{
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("��");
		c.add(6);// �Զ�װ��
		System.out.println("c:" + c);		
		System.out.println("c.size():" + c.size());
		c.remove(6);
		System.out.println("c.size():" + c.size());
		System.out.println("c�Ƿ����\"��\"��" + c.contains("��"));
		c.add("������Java");
		System.out.println("c:" + c);
		Collection books = new HashSet();
		books.add("������Java");		
		books.add("���Java");
		System.out.println("c����books? " + c.containsAll(books));
		c.removeAll(books);//c���ϼ�ȥbooks����
		System.out.println("c:" + c);
		c.clear();
		System.out.println("c:" + c);
		books.retainAll(c);
		System.out.println("books:" + books);		

		books.add("������Java");		
		books.add("���Java");
		books.add("���");
		books.forEach(obj -> System.out.println(obj));
		System.out.println("");

		// Iterator
		Iterator iterator = books.iterator();
		while (iterator.hasNext()) {
			String book = (String)iterator.next();
			System.out.println(book);
			if (book.equals("���")) {
				iterator.remove();// ɾ����һ��next()�������ص�Ԫ��
				// ��һ�д��뱨���CME�쳣
				//books.remove(book);
			}
			book = "����";// ����ʵ������booksԪ�صĸ���������ı�books��Ԫ��
		}
		System.out.println("books:" + books);
		iterator = books.iterator();// ǰ��ִ����whileѭ����iterator.hasNext()Ϊfalse��
		System.out.println("iterator.forEachRemaining:");
		//iterator.forEachRemaining(ele -> System.out.println(ele));
		iterator.forEachRemaining(System.out::println);

		// Predicate
		System.out.println("Predicate");		
		books.add("���iOS����");		
		books.add("���iOS����-���");		
		books.add("���Ajax����");
		books.add("���Android����-���");
		books.add("��մ�");
		books.forEach(System.out::println);
		System.out.println("ɾ����A��a����");
		books.removeIf(ele -> ((String)ele).matches(".*[aA].*"));
		books.forEach(System.out::println);
		System.out.println(books.size());
		System.out.println("");

		// Predicate2
		System.out.println(callAll(books, ele -> ((String)ele).contains("���")));
		System.out.println(callAll(books, ele -> ((String)ele).length() > 5));

		// Stream
		System.out.println("");
		IntStream intStream = IntStream.builder()
			.add(20)
			.add(13)
			.add(-2)
			.add(18)
			.build();
		// ������þۼ������Ĵ���ÿ��ֻ��ִ��һ�У���Ҫ�������ĵ��þۼ������Ĵ���ע�͵�, ���򱨴�ISE
		//System.out.println("���ֵ��" + intStream.max().getAsInt());
		//System.out.println("��Сֵ��" + intStream.min().getAsInt());
		//System.out.println("�ܺͣ�" + intStream.sum());		
		//System.out.println("�ܵĸ�����" + intStream.count());
		//System.out.println("ƽ��ֵ��" + intStream.average());
		//System.out.println("intStream�Ƿ�����ÿ��Ԫ�ص�ƽ��������20��" + intStream.allMatch(ele -> ele * ele > 20));
		//System.out.println("intStream�Ƿ��������ƽ������20��Ԫ�أ�" + intStream.anyMatch(ele -> ele * ele > 20));
		IntStream newIntStream = intStream.map(ele -> ele * 2 + 1);
		newIntStream.forEach(System.out::println);

		System.out.println("");
		books.forEach(System.out::println);
		System.out.println(books.stream().filter(ele -> ((String)ele).contains("���")).count());
		System.out.println(books.stream()
					.filter(ele -> ((String)ele).length() > 5)
					.count());
		books.stream().mapToInt(ele -> ((String)ele).length())
				.forEach(System.out::println);
				
	}
	
	public static int callAll(Collection collection, Predicate predicate) {
		int total = 0;
		
		for (Object element : collection) {
			if (predicate.test(element)) {
				total++;
			}
		}
		
		return total;
	}
}
