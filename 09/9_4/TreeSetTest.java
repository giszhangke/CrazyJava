import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String[] args) {
		TreeSet<String> treeSet1 = new TreeSet(new Comparator<Object>() {
			public int compare(Object first, Object second) {
				return first.hashCode() > second.hashCode() ? 1 :
					first.hashCode() < second.hashCode() ? -1 : 0;
			}
		});

		TreeSet<String> treeSet2 = new TreeSet(new Comparator<String>() {
			public int compare(String first, String second) {
				return first.length() > second.length() ? 1 : 
					first.length() < second.length() ? -1 : 0;
			}
		});

		treeSet1.add("da");
		treeSet1.add("xiao");
		System.out.println(treeSet1);
		treeSet2.add("加为中");
		treeSet2.add("和");
		System.out.println(treeSet2);
	}
}
