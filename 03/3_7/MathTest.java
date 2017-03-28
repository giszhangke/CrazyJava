public class MathTest
{
	public static void main(String args[])
	{
		double a = 3.2;
		double b = Math.pow(a,5);//求a的5次方
		System.out.println(b);
		double c = Math.sqrt(a);//求a的平方根
		System.out.println(c);
		double d = Math.random();//计算随机数，返回一个0~1之间的伪随机数
		System.out.println(d);
		double e = Math.sin(1.57);//求1.57的sin函数值；1.57被当成弧度数
		System.out.println(e);//输出接近1
		
		double x = -5.0;
		x = -x;//将x求负，其值变成5.0
		System.out.println(x);

	}
}
