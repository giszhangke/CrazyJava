import static java.lang.System.*;

class Parent
{
	public String tag = "����";
}

class Derived extends Parent
{
	private String tag = "�޹���";
}

public class HideTest extends Derived
{
	public static void main(String[] args) {
		Derived d = new Derived();
		//out.println(d.tag);
		out.println(((Parent)d).tag);
	}
}
