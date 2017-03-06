
import java.util.TreeSet;

class Err {}

public class TreeSetErrorTest
{
	public static void main(String[] args)
	{
		TreeSet ts = new TreeSet();
		ts.add(new Err());
		ts.add(new Err());//执行到这句会报错，因为Err类没有实现Comparable接口

	}
}

