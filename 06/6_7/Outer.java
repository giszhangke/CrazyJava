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
			// ��̬�ڲ��಻�ܵ����ⲿ��ķǾ�̬��Ա
			//System.out.println(variable);
		}
	}

	class Inner
	{
		//�����ڷǾ�̬�ڲ����ж��徲̬��Ա
		//private static String innerVariable = "innerVariable";
		private String innerVariable = "innerVariable";
	}

	public void test() {
		// ����һ�д���Ĵ��ⲿ�಻��ֱ�ӷ����ڲ����˽�б��������ǿ���ͨ���ڲ����ʵ������
		//System.out.println(innerVariable);
		System.out.println(new Inner().innerVariable);
		
		System.out.println(StaticInner.staticInnerVariable);	
		System.out.println(new StaticInner().staticInt);		
	}

	public static void main(String[] args) {
		new Outer().test();
		//�����ھ�̬�����е��÷Ǿ�̬�ڲ���
		//new Inner();
	}
}
