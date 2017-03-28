public class DiscernVariable
{
	private String variable = "outerVariable";

	private class InnerClass
	{
		private String variable = "innerVariable";				

		public void info() {
			String variable = "methodVariable";
		
			System.out.println(DiscernVariable.this.variable);	
			System.out.println(this.variable);			
			System.out.println(variable);
		}
	}
	
	public void test() {
		InnerClass innerClassObject = new InnerClass();
		innerClassObject.info();
	}

	public static void main(String[] args) {
		new DiscernVariable().test();
	}
}
