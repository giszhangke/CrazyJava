import static java.lang.System.*;

class Base
{
	public Base() {
		test();
	}

	public void test() {
		out.println("base test");
	}
}

public class Sub extends Base
{
	String name;

	public void test() {
		out.println("sub test: the length of name is " + name.length());
	}

	public static void main(String[] args) {
		Sub s = new Sub();
	}
}
