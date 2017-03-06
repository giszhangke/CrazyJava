public class CharTest
{
	public CharTest()
	{}

	public static void main(String[] args)
	{
		char aChar = 'a';
		System.out.println(aChar);		
		char enterChar = '\r';
		System.out.println(enterChar);//输出回车
		char ch = '\u9999';//通过Unicode指定汉字
		System.out.println(ch);//输出汉字“香”		
		char zhong = '疯';
		System.out.println(zhong);//输出汉字“疯”		
		int zhongValue = zhong;//直接把char类型变量当成一个int类型变量
		System.out.println(zhongValue);
		char c = 97;//直接把一个0~65535范围内的int整数赋值给char变量
		System.out.println(c);//输出字母“a”

	}
}
