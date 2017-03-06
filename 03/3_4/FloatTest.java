public class FloatTest
{
	public static void main(String[] args)
	{
		float af = 5.2345556f;
		//打印输出时af的值已经发生了改变
		System.out.println("af: " + af);
		double a = 0.0;
		double c = Double.NEGATIVE_INFINITY;
		float d = Float.NEGATIVE_INFINITY;
		//float和double的负无穷大是相等的
		System.out.println("c==d: " + (c==d));
		//0.0除以0.0将出现非数
		System.out.println("a/a: " + (a/a));
		//两个非数之间是不相等的
		System.out.println("a/a == Float.NaN: " + (a/a == Float.NaN));
		//所有正无穷大都是相等的
		System.out.println("6.0/0 == 555.0/0: " + (6.0/0 == 555.0/0));
		//负数除以0.0等到负无穷大
		System.out.println(-8/a);

		try
		{
			//只有浮点数除以0才可以得到正无穷大或负无穷大
			//如果一个整数值除以0，则会抛出一个异常
			//下面代码将抛出除以0的异常
			System.out.println(0/0);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}

	}
}
