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
		//�������䱨�� ��ΪString���Math��֮��û�м̳й�ϵ
		//out.println("a instanceof Math: " + (a instanceof Math));
	}

}
