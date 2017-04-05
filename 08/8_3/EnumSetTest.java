import java.util.Collection;
import java.util.HashSet;
import java.util.EnumSet;

enum Season
{
	SPRING,SUMMER,FALL,WINTER;
}

public class EnumSetTest {
	public static void main(String[] args) {
		EnumSet es1 = EnumSet.allOf(Season.class);
		System.out.println(es1);
		EnumSet es2 = EnumSet.noneOf(Season.class);
		System.out.println(es2);
		es2.add(Season.WINTER);
		es2.add(Season.SPRING);
		System.out.println(es2);
		EnumSet enumSet3 = EnumSet.of(Season.SPRING, Season.SUMMER);
		System.out.println(enumSet3);
		EnumSet enumSet4 = EnumSet.range(Season.SUMMER, Season.WINTER);
		System.out.println(enumSet4);
		EnumSet enumSet5 = EnumSet.complementOf(enumSet4);
		System.out.println(enumSet5);

		System.out.println("Collection -> EnumSet");
		Collection c = new HashSet();
		c.clear();
		c.add(Season.FALL);
		c.add(Season.SPRING);
		EnumSet enumSet = EnumSet.copyOf(c);
		System.out.println(enumSet);
		c.add("疯狂Java讲义");
		c.add("悟空传");
		// 下面一行代码出现异常：因为c集合里的元素不是全部都为枚举值
		//enumSet = EnumSet.copyOf(c);
	}
}
