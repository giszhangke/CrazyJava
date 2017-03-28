public class BlockTest
{
	public static void main(String[] args) {
		// 代码块里的局部变量作用域是代码块内部
		{
			int a = 2;
			String name = "Jack";
			System.out.println(a);
			System.out.println(name);			
		}
		
		int a = 4;
		String name = "Tom";
		System.out.println(a);
		System.out.println(name);					
	}
}
