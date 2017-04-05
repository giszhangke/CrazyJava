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
		c.add("孙");
		c.add(6);// 自动装箱
		System.out.println("c:" + c);		
		System.out.println("c.size():" + c.size());
		c.remove(6);
		System.out.println("c.size():" + c.size());
		System.out.println("c是否包含\"孙\"：" + c.contains("孙"));
		c.add("轻量级Java");
		System.out.println("c:" + c);
		Collection books = new HashSet();
		books.add("轻量级Java");		
		books.add("疯狂Java");
		System.out.println("c包含books? " + c.containsAll(books));
		c.removeAll(books);//c集合减去books集合
		System.out.println("c:" + c);
		c.clear();
		System.out.println("c:" + c);
		books.retainAll(c);
		System.out.println("books:" + books);		

		books.add("轻量级Java");		
		books.add("疯狂Java");
		books.add("悟空");
		books.forEach(obj -> System.out.println(obj));
		System.out.println("");

		// Iterator
		Iterator iterator = books.iterator();
		while (iterator.hasNext()) {
			String book = (String)iterator.next();
			System.out.println(book);
			if (book.equals("悟空")) {
				iterator.remove();// 删除上一次next()方法返回的元素
				// 下一行代码报错错：CME异常
				//books.remove(book);
			}
			book = "哈哈";// 这是实际上是books元素的副本，不会改变books的元素
		}
		System.out.println("books:" + books);
		iterator = books.iterator();// 前面执行完while循环后iterator.hasNext()为false了
		System.out.println("iterator.forEachRemaining:");
		//iterator.forEachRemaining(ele -> System.out.println(ele));
		iterator.forEachRemaining(System.out::println);

		// Predicate
		System.out.println("Predicate");		
		books.add("疯狂iOS讲议");		
		books.add("疯狂iOS讲议-悟空");		
		books.add("疯狂Ajax讲议");
		books.add("疯狂Android讲议-悟空");
		books.add("悟空传");
		books.forEach(System.out::println);
		System.out.println("删除带A或a的书");
		books.removeIf(ele -> ((String)ele).matches(".*[aA].*"));
		books.forEach(System.out::println);
		System.out.println(books.size());
		System.out.println("");

		// Predicate2
		System.out.println(callAll(books, ele -> ((String)ele).contains("悟空")));
		System.out.println(callAll(books, ele -> ((String)ele).length() > 5));

		// Stream
		System.out.println("");
		IntStream intStream = IntStream.builder()
			.add(20)
			.add(13)
			.add(-2)
			.add(18)
			.build();
		// 下面调用聚集方法的代码每次只能执行一行，需要把其它的调用聚集方法的代码注释掉, 否则报错ISE
		//System.out.println("最大值：" + intStream.max().getAsInt());
		//System.out.println("最小值：" + intStream.min().getAsInt());
		//System.out.println("总和：" + intStream.sum());		
		//System.out.println("总的个数：" + intStream.count());
		//System.out.println("平均值：" + intStream.average());
		//System.out.println("intStream是否满足每个元素的平方都大于20：" + intStream.allMatch(ele -> ele * ele > 20));
		//System.out.println("intStream是否满足存在平方大于20的元素：" + intStream.anyMatch(ele -> ele * ele > 20));
		IntStream newIntStream = intStream.map(ele -> ele * 2 + 1);
		newIntStream.forEach(System.out::println);

		System.out.println("");
		books.forEach(System.out::println);
		System.out.println(books.stream().filter(ele -> ((String)ele).contains("悟空")).count());
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
