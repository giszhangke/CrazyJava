import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

class R
{
	private int count = 0;
	
	public R(int count) {
		this.count = count;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return count + "";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj != null && obj.getClass() == R.class) {
			R r = (R)obj;
			return r.getCount() == count;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return count;
	}
}

public class HashSetTest2
{
	public static void main(String[] args) {
		HashSet hashSet = new HashSet();
		hashSet.add(new R(5));
		hashSet.add(new R(-3));
		hashSet.add(new R(9));
		hashSet.add(new R(-2));
		System.out.println(hashSet);
		Iterator iterator = hashSet.iterator();
		R first = (R)iterator.next();
		first.setCount(-3);
		System.out.println(hashSet);
		hashSet.remove(new R(-3));
		System.out.println(hashSet);
		System.out.println(hashSet.contains(new R(-3)));
		System.out.println(hashSet.contains(new R(-2)));
	
		// LinkedHashSet 是有序的
		LinkedHashSet linkedHashSet = new LinkedHashSet();
		linkedHashSet.add("中");
		linkedHashSet.add("国");
		linkedHashSet.add("人");
		System.out.println(linkedHashSet);
		linkedHashSet.remove("中");
		linkedHashSet.add("中");
		System.out.println(linkedHashSet);

	}
}
