public class PrimitiveAndStringTest
{
	public static void main(String[] args)
	{
		//不能直接把整数数字赋给字符串类型变量
		//String str1 = 5;
		//一个基本类型的值和字符串进行连接运算时，基本类型的值自动转换为字符串
		String str2 = 3.5f + "";
		System.out.println(str2);
		//下面语句输出 7Hello!
		System.out.println(3 + 4 + "Hello!");
		//下面语句输出 Hello!34
		System.out.println("Hello!" + 3 + 4);

	}
}

