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
	//�����������ձ���û��������ʱ��ʼ���������ڿ飬���캯���ﶼû�г�ʼ�������Ա���ʱ�ᱨ��
	//final char ch;

	{
		// �ڳ�ʼ�����ձ���֮ǰ���ܵ������ձ�������Ϊ���������ձ���ʱϵͳ�����Զ���ʼ��
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
		// �β���final���η�������ڷ������в��ܶԸ��βθ�ֵ
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

		String str1 = "�й���";
		final String str2 = "�й�";
		final String str3 = "��";
		String str4 = str2 + str3;
		System.out.println(str1 == str4);

		String str5 = new String("Hello");
		String str6 = new String("Hello");		
		System.out.println(str5.hashCode());
		System.out.println(str6.hashCode());
	}
}