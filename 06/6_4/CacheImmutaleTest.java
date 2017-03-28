/*
 * 队列缓存实现
 *
 * */
class CacheImmutale
{
	private final static int MAX_SIZE = 10;
	private static CacheImmutale[] cache = new CacheImmutale[MAX_SIZE];
	private static int pos = 0;
	private final String name;

	private CacheImmutale(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static CacheImmutale valueOf(String name) {
		for (int i = 0; i < MAX_SIZE; i++) {
			//以下定法是不合理的
			//if (cache[i].getName() == name) {
			if (cache[i] != null 
				&& cache[i].getName().equals(name)) {
				return cache[i];
			}
		}
		
		// 缓存已满
		if (pos == MAX_SIZE) {
			pos = 0;
		} 

		cache[pos++] = new CacheImmutale(name);

		return cache[pos - 1];
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj != null && obj.getClass() == CacheImmutale.class) {
			CacheImmutale t = (CacheImmutale)obj;
			return t.getName().equals(name);
		} else {
			//别忘了这一句
			return false;
		}
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

}

public class CacheImmutaleTest
{
	public static void main(String[] args) {
		CacheImmutale c1 = CacheImmutale.valueOf("China");
		CacheImmutale c3 = CacheImmutale.valueOf("China");		
		System.out.println(c1 == c3 );

		Integer i = new Integer(127);
		Integer j = Integer.valueOf(127);
		Integer k = Integer.valueOf(127);
		System.out.println(i == j);//false
		System.out.println(j == k);//true

		Integer m = new Integer(128);
		Integer n = Integer.valueOf(128);
		System.out.println(m == n);

	}
}
