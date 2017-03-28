public class CreateInnerInstance
{
	class Inner
	{
		protected Inner(String msg) {
			System.out.println(msg);
		}
	}

	static class StaticInner
	{
		public StaticInner(String msg) {
			System.out.println(msg);
		}
	}

	public static void main(String[] args) {
		CreateInnerInstance.Inner innerInstance = new CreateInnerInstance().new Inner("yes");
		CreateInnerInstance.StaticInner si = new CreateInnerInstance.StaticInner("hello");
	}
}
