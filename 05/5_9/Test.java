import static java.lang.System.out;

class Root
{
	//先执行静态代码，因为static标识的成员是属于类的，会在类第一次加载时执行并初始化
	{
		out.println("Root not static");
	}

	static{
		out.println("Root static");		
	}

	public Root() {
		out.println("Root()");	
	}
}

class Mid extends Root
{
	static{
		out.println("Mid static");		
	}

	{
		out.println("Mid not static");
	}

	public Mid() {
		out.println("Mid()");	
	}
}

class Leaf extends Mid
{
	static{
		out.println("Leaf static");		
	}

	{
		out.println("Leaf not static");
	}

	public Leaf() {
		out.println("Leaf()");	
	}
}

public class Test
{
	public static void main(String[] args) {
		new Leaf();
		out.println("\n");
		new Leaf();
		out.println("\n");
		new Leaf();
	}
}
