import static java.lang.System.out;

public class InstanceofTest
{
	public static void main(String[] args) {
		Object hello = "hello";
		out.println("hello instanceof Object: " + (hello instanceof Object));
		out.println("hello instanceof String: " + (hello instanceof String));
		out.println("hello instanceof Math: " + (hello instanceof Math));
		out.println("hello instanceof Comparable: " + (hello instanceof Comparable));

		String a = "hello";
		//下面的语句报错， 因为String类和Math类之间没有继承关系
		//out.println("a instanceof Math: " + (a instanceof Math));
	}

}
