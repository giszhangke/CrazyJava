public class RandomStr
{
	public static void main(String[] args)
	{
		String result = "";
		for(int i = 0 ; i < 6 ; i ++)//如果换成 for(int i = 0 ; i < 6 ; i++); 则循环体内的内容只会执行一次 
		{
			int intVal = (int)(Math.random() * 26 + 97);				      	      result = result + (char)intVal;
		}

		System.out.println(result);
		
		//以下语句报错
		//float a = 5.6;
		//正确写法为
		float a = (float)5.6;
		//基本类型对应的包装类可以把字符串转换成基本类型
		String b="45";
		int iValue = Integer.parseInt(b);

		System.out.println(a);
		System.out.println(iValue);
		
	}
}

