public class DivTest
{
	public static void main(String[] args)
	{
		double a = 5.2;
		double b = 3.1;
		double div = a/b;
		//div的值将是1.6774193548387097
		System.out.println(div);
		//输出正无穷大
		System.out.println("5除以0.0的结果是：" + 5/0.0);		
		//输出负无穷大
		System.out.println("-5除以0.0的结果是：" + -5/0.0);
		//整数除以整数类型0会报异常  运行时异常
		System.out.println("-5除以0的结果是：" + -5/0);
	}
}
