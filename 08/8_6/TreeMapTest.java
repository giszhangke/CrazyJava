import java.util.TreeMap;

class R implements Comparable {
	int count;

	public R(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return String.valueOf(count);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj != null && obj.getClass() == R.class) {
			R r = (R)obj;
			return r.count == count;
		}
		return false;	
	}

	@Override
	public int compareTo(Object obj) {
		R r = (R)obj;
		return count > r.count ? 1 :
			count < r.count ? -1 : 0;
	}

	@Override
	public int hashCode() {
		return count;
	}
}

public class TreeMapTest {
	public static void main(String[] args) {
		TreeMap treeMap = new TreeMap();
		treeMap.put(new R(1), "ÈçÀ´·ğ×æ");
		treeMap.put(new R(4), "ÎŞÁ¿¹Å·ğ");
		treeMap.put(new R(-3), "Õ½¶·Ê¤·ğ");
		treeMap.put(new R(8), "Ğ¡É³ÃÖ");
		System.out.println(treeMap.firstEntry());// Êä³ö -3=Õ½¶·Ê¤·ğ
		System.out.println(treeMap.lastKey());
		System.out.println(treeMap.lowerEntry(new R(5)));
		System.out.println(treeMap.higherKey(new R(-3)));
		System.out.println(treeMap.subMap(new R(-2), new R(7)));
	}
}
