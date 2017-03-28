public class BitOperatorTest
{
	public static void main(String[] args)
	{
		int a = 0b11111111_11111111_11111111_11111011;//-5的补码，原码为0b10000000_00000000_00000000_00000101
		System.out.println(a);//输出-5
		System.out.println(~a);//输出4
		System.out.println(a);//输出-5

		System.out.println(~-5);//输出4
		System.out.println(5&9);//输出1
		System.out.println(5|9);//输出13
		System.out.println(5^9);//输出12

		System.out.println(5<<2);//输出20
		System.out.println(-5<<2);//输出-20
		System.out.println(-5>>2);//输出-2
		System.out.println(-5>>>2);//输出1073741822
	}
}
