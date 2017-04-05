import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;
import java.util.Enumeration;

public class SearchTest {
	public static void main(String[] args) throws Exception {
		ArrayList nums = new ArrayList();
		nums.add(5);
		nums.add(3);
		nums.add(-2);
		nums.add(9);
		nums.add(0);
		System.out.println(nums);
		Collections.replaceAll(nums, -2, 3);
		System.out.println(nums);
		System.out.println(Collections.min(nums));
		System.out.println(Collections.max(nums));
		Collections.sort(nums);
		System.out.println(Collections.binarySearch(nums, 5));

		List list = Collections.synchronizedList(new ArrayList());
		Set set = Collections.synchronizedSet(new HashSet());
		Map map = Collections.synchronizedMap(new HashMap());

		List listEmpty = Collections.emptyList();
		Set setSingleton = Collections.singleton("�����ʥ");
		HashMap hashMap = new HashMap();
		hashMap.put("1", "�廪");
		hashMap.put("2", "����");
		hashMap.put("3", "���");
		Map unmodifiableMap = Collections.unmodifiableMap(hashMap);
		// ����ʱ�����޸Ĳ����Ա����ʱ�ᱨ��
		// list.add("�տ�");
		// setSingleton.add("����");
		// unmodifiableMap.put("4", "���");
		
		Vector v = new Vector();
		v.add(1);
		v.add(2);
		v.add(3);
		Hashtable hashtable = new Hashtable();
		hashtable.put(1, "a");
		hashtable.put(2, "b");
		hashtable.put(3, "c");
		Enumeration enumeration = v.elements();
		while (enumeration.hasMoreElements()) {
			System.out.println(enumeration.nextElement());
		}
		enumeration = hashtable.keys();
		while (enumeration.hasMoreElements()) {
			Object key = enumeration.nextElement();
			System.out.println(key + " " + hashtable.get(key));
		}
	}
}
