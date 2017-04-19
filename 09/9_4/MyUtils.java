import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

interface Iter1<E> {
	void print(E e);
}

interface Iter2<E> extends Iter1<E> {
	void say(E e);
}

class MyC<E> implements Iter2<E> {

	public MyC() {}

	public MyC(E e) {
		System.out.println("MyC: " + e);
	}

	public void print(E e) {
		System.out.println("print: " + e);
	}

	public void say(E e) {
		System.out.println("say: " + e);		
	}
}

public class MyUtils {
	public static <T> T copy(Collection<? super T> dest, Collection<T> from) {
		T last = null;
		for (T t : from) {
			dest.add(t);
			last = t;
		}
		return last;
	}


	public static void main(String[] args) {
		List<Integer> from = new ArrayList();
		List<Number> dest = new ArrayList();
		from.add(888);
		Integer last = copy(dest, from);
		System.out.println(last);

		Iter2<String> iter2String = new MyC();
		iter2String.print("Hahaha");
		Iter1<String> iter1String = iter2String;
		iter1String.print("Woowow");

		Iter1<String> iter3String = new MyC("ooo");
		Iter1<Integer> iter4Integer = new MyC<Integer>(13331);
		Iter1<Integer> iter5Integer = new MyC<>(4654989);
	}
}
