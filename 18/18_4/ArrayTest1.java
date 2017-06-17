import java.lang.reflect.Array;

public class ArrayTest1 {
	public static void main(String[] args) throws Exception {
		Object obj = Array.newInstance(String.class, 10);	
		Array.set(obj, 5, "夜半钟声到客船");
		Array.set(obj, 8, "暮云春树");
		System.out.println(Array.get(obj, 5));
		System.out.println(Array.get(obj, 8));
	}
}
