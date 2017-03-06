public class AutoConversionTest
{
	public static void main(String[] args)
	{
		int a = 6;
		//int类型变量可以自动转换成float类型变量
		float f = a;
		
		System.out.println(f);
		
		byte b = 9;
		//以下赋值会报错
		//char c = b;
		//byte类型变量可以自动转换成double类型变量
		double d = b;
		
		System.out.println(d);	
	}
}
