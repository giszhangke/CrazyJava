import static java.lang.System.out;

class Root
{
	//��ִ�о�̬���룬��Ϊstatic��ʶ�ĳ�Ա��������ģ��������һ�μ���ʱִ�в���ʼ��
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