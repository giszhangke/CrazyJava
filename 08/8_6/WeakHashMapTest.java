import java.util.WeakHashMap;
import java.util.IdentityHashMap;

public class WeakHashMapTest {
	public static void main(String[] args) {
		WeakHashMap weakHashMap = new WeakHashMap();
		weakHashMap.put(new String("1"), "a");
		weakHashMap.put("-1", "-1");
		weakHashMap.put(new String("2"), "b");
		weakHashMap.put(new String("3"), "c");
		weakHashMap.put("4", "d");
		System.out.println(weakHashMap);
		System.gc();
		System.runFinalization();
		System.out.println(weakHashMap);
		
		// IdentityHashMap
		System.out.println("");
		System.out.println("IdentityHashMap");
		IdentityHashMap identityHashMap = new IdentityHashMap();
		// �������ж������
		identityHashMap.put(new String("1"), 1);
		identityHashMap.put(new String("1"), 1);
		// ��������ֻ�����һ��
		identityHashMap.put("2", 2);
		identityHashMap.put("2", 3);
		System.out.println(identityHashMap);
	}
}

