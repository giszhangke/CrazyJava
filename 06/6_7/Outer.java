public class Outer
{
	private String variable = "outerVariable";
	private static String staticVariable = "outerStaticVariable";	
	
	static class StaticInner
	{
		private static String staticInnerVariable = "staticInnerVariable";
		private int staticInt = 9;

		private void staticInnerMethod() {
			System.out.println(staticVariable);
			// 静态内部类不能调用外部类的非静态成员
			//System.out.println(variable);
		}
	}

	class Inner
	{
		//不能在非静态内部类中定义静态成员
		//private static String innerVariable = "innerVariable";
		private String innerVariable = "innerVariable";
	}

	public void test() {
		// 下面一行代码的错，外部类不能直接访问内部类的私有变量，但是可以通过内部类的实例调用
		//System.out.println(innerVariable);
		System.out.println(new Inner().innerVariable);
		
		System.out.println(StaticInner.staticInnerVariable);	
		System.out.println(new StaticInner().staticInt);		
	}

	public static void main(String[] args) {
		new Outer().test();
		//不能在静态方法中调用非静态内部类
		//new Inner();
	}
}
