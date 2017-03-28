import static java.lang.System.*;

class Parent
{
	public String tag = "込込";
}

class Derived extends Parent
{
	private String tag = "抑込込";
}

public class HideTest extends Derived
{
	public static void main(String[] args) {
		Derived d = new Derived();
		//out.println(d.tag);
		out.println(((Parent)d).tag);
	}
}
