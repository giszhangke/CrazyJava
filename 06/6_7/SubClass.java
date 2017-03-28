public class SubClass extends CreateInnerInstance.Inner
{
	public SubClass(CreateInnerInstance createInnerInstance) {
		createInnerInstance.super("I'm a SubClassInstance");
	}

	public static void main(String[] args) {
		SubClass subClass = new SubClass(new CreateInnerInstance());
	}
}
