@Inheritable
class base {
}

public class InheritableTest extends base {
	public static void main(String[] args) {
		System.out.println(InheritableTest.class.isAnnotationPresent(Inheritable.class));
	}
}
