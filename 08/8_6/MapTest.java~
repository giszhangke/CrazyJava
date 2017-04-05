import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;

class A {
	int count;
	
	public A(int count) {
		this.count = count;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj != null && obj.getClass() == A.class) {
			A a = (A)obj;
			return a.count == count;
		}
		
		return false;
	}

	@Override
	public int hashCode() {
		return count;
	}
}

class B {
	@Override
	public boolean equals(Object obj) {
		return true;
	}
}

public class MapTest {
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put(1, "ËïÎò¿Õ");
		map.put(2, "Öí°Ë½ä");
		map.put(3, "ÌÆÉ®");
		map.put(4, "É³É®");
		System.out.println(map);
		System.out.println(map.put(4, "°×ÁúÂí"));
		System.out.println(map);
		System.out.println(map.containsValue("É³É®"));
		System.out.println(map.containsKey(4));
		for (Object i : map.keySet()) {
			System.out.println((Integer)i + " -> " + map.get(i));
		}
		System.out.println(map.remove(1));
		System.out.println(map);
		
		// Java 8
		map.replace(4, "É³É®");
		System.out.println(map);
		map.computeIfAbsent(5, (key) -> "Ð¡ºï×Ó");
		System.out.println(map);
		map.computeIfPresent(5, (key, value) -> (Integer)key * (Integer)key + (String)value);
		//map.computeIfPresent(6, (key, value) -> (Integer)key * (Integer)key + (String)value);
		System.out.println(map);
		map.put(null, null);
		System.out.println(map);
		map.put(7, new String[]{"ÊÏ","ÈÔÎ´","ÈÔ","¶«×ßÎ÷¹Ë"});
		System.out.println(map);	
		
		// Hashtable
		Hashtable hashtable = new Hashtable();
		hashtable.put(new A(156), "¶ÎÓþ");
		hashtable.put(new A(234), "ÇÇ·å");
		hashtable.put(new A(283), "ÐéÖñ");
		hashtable.put(new A(23), new B());
		hashtable.put(new B(), "B");
		System.out.println(hashtable);
		System.out.println(hashtable.containsValue(new B()));
		System.out.println(hashtable.containsValue("Ëæ±ãÒ»¸ö×Ö·û¶¼¿ÉÒÔ"));
		
		System.out.println("=========");		
		Iterator iterator = hashtable.keySet().iterator();
		A firstElement = (A)iterator.next();
		int oldCount = firstElement.count;
		System.out.println(oldCount);
		System.out.println(hashtable);
		firstElement.count = 899;
		System.out.println(hashtable.remove(new A(oldCount)));
		System.out.println(hashtable.get(new A(899)));
		
		// LinkedHashMap
		LinkedHashMap linkedHashMap = new LinkedHashMap();
		linkedHashMap.put(1, 100);
		linkedHashMap.put(2, 99);
		linkedHashMap.put(3, 98);
		linkedHashMap.forEach((key, value) -> System.out.println(key + " -> " + value));
	}
}
