import java.util.Collection;
import java.util.ArrayList;

public class Apple<T extends Number & java.io.Serializable> {
	T col;
	
	public static <S> void fromArrayToCollection(S[] a, Collection<S> c) {
		for (S o : a) {
			c.add(o);
		}
	}

	public static void main(String[] args) {
		Apple<Integer> ai = new Apple<>();
		Apple<Double> ad = new Apple<>();
		// String类不是Number的子类，所有下一行代码编译出错
		//Apple<String> as = new Apple<>();
		
		Object[] oa = new Object[100];
		Collection<Object> co = new ArrayList<Object>();
		fromArrayToCollection(oa, co);
		String[] sa = new String[100];
		Collection<String> cs = new ArrayList();
		fromArrayToCollection(sa, cs);
		Integer[] ia = new Integer[100];
		Float[] fa = new Float[100];
		Number[] na = new Number[100];
		Collection<Number> cn = new ArrayList();
		fromArrayToCollection(ia, cn);
		fromArrayToCollection(fa, cn);
		fromArrayToCollection(na, cn);
		fromArrayToCollection(na, co);
		// 下一行代码编译报错
		// String类不是Number的子类，而cn是Number数组
		//fromArrayToCollection(sa, cn);
	}
}
