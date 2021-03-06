import java.util.Arrays;

class Base
{
	public final void baseMethod() {
		System.out.println("baseMethod");
	}
	
	public final void baseMethod(int i) {
	
	}

	private final void baseMethod2() {
		System.out.println("baseMethod2");	
	}
}

public class FinalVariableTest extends Base
{
	final int a = 6;
	final String str;
	final int c;
	final static double d;
	//下面的这个最终变量没有在声明时初始化，并且在块，构造函数里都没有初始化，所以编译时会报错
	//final char ch;

	{
		// 在初始化最终变量之前不能调用最终变量，因为在声明最终变量时系统不会自动初始化
		//System.out.println(str);
		str = "Hello";
		//a = 8;
	}

	static {
		d = 8.8;
	}

	public FinalVariableTest() {
		c = 2;
	}

	public void changeFinalValues() {
		/*
		str = "What?";
		d = 9.9;
		c = 2323;
		*/
	}

	public void test(final int i) {
		// 形参有final修饰符，因此在方法体中不能对该形参赋值
		//i = 3;
	}
/*
	public void baseMethod() {
		System.out.println("subMethod");
	}
*/
	public final void baseMethod2() {
		System.out.println("subMethod2");	
	}

	public static void main(String[] args) {
		FinalVariableTest finalVariableTest = new FinalVariableTest();
		finalVariableTest.changeFinalValues();
		finalVariableTest.test(23);

		final int[] iArr = {2, 3, 2, 8, 9};
		System.out.println(Arrays.toString(iArr));
		Arrays.sort(iArr);
		System.out.println(Arrays.toString(iArr));
		iArr[3] = 10;
		System.out.println(Arrays.toString(iArr));
		//iArr = null;

		String str1 = "中国人";
		final String str2 = "中国";
		final String str3 = "人";
		String str4 = str2 + str3;
		System.out.println(str1 == str4);

		String str5 = new String("Hello");
		String str6 = new String("Hello");		
		System.out.println(str5.hashCode());
		System.out.println(str6.hashCode());
	}
}
