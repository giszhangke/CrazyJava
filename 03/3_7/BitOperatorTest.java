public class BitOperatorTest
{
	public static void main(String[] args)
	{
		int a = 0b11111111_11111111_11111111_11111011;//-5�Ĳ��룬ԭ��Ϊ0b10000000_00000000_00000000_00000101
		System.out.println(a);//���-5
		System.out.println(~a);//���4
		System.out.println(a);//���-5

		System.out.println(~-5);//���4
		System.out.println(5&9);//���1
		System.out.println(5|9);//���13
		System.out.println(5^9);//���12

		System.out.println(5<<2);//���20
		System.out.println(-5<<2);//���-20
		System.out.println(-5>>2);//���-2
		System.out.println(-5>>>2);//���1073741822
	}
}
