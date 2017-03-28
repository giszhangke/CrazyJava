public class StaticAccessNonStatic
{
	public void info()
	{
		System.out.println("haha!");
	}

	public static void main(String[] args)
	{
		// 在静态方法中调用非静态方法会报错
		//info();
		// 实例化对象可以正常调用
		new StaticAccessNonStatic().info();
	}
}
