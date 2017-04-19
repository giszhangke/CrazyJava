import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

public class RightTest {
	public <T> RightTest(T t) {
		System.out.println(t);
	}

	public static <T> void test(Collection<? extends T> from, Collection<T> to) {
		for (T ele : from) {
			to.add(ele);
		}
	}	

	public boolean containsAll(Collection<?> c) {
		return true;
	}

	public static void main(String[] args) {
		List<Object> ao = new ArrayList();
		List<String> as = new ArrayList<>();
		test(as, ao);

		new RightTest(23);
		new RightTest("afsda");
		new <Float> RightTest(23.98F);
		// 下一行代码编译错误
		//new <String> RightTest(23);
	}

}
