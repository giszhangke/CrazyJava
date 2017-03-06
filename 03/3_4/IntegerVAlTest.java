public class IntegerValTest
{
	public static void main(String[] args)
	{
		//在 -128~+127 之间，系统会自动把56当成byte类型，下面的代码是正确的
		byte a = 57;
		/*
		 * 下面的代码是错误的，系统不会把999999999999999当成long类型处理
		 * 所以超出int的表数范围，从而引起错误
		 * */
		// long bigValue = 999999999999999;
		// 下面代码是正确的，在巨大的整数值后使用L后缀，强制使用long类型
		long bigValue2 = 9199999999999993223L;
		
		System.out.println(bigValue2);

		//以0开头的整数值是八进制的整数
		int octalValue = 013;
		//以0x或0X开头的整数值是十六进制的整数
		int hexValue1 = 0x13;
		int hexValue2 = 0XaF;

		System.out.println(octalValue);
		System.out.println(hexValue1);
		System.out.println(hexValue2);

		//定义两个8位的二进制整数
		int binVal1 = 0b11010100;
		byte binVal2 = 0B01101001;
		//定义一个32位的二进制整数，最高位是符号位
		//二进制整数binVal3转成十进制的过程
		//1. 补码(计算机以补码的形式保存所有的整数)减1得到反码
		//2. 反码符号位不变，其他位取反得到原码
		int binVal3 = 0B10000000000000000000000000000011;
		System.out.println(binVal1);
		System.out.println(binVal2);
		System.out.println(binVal3);

	}
}
