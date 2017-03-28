public class AutoBoxingUnboxing
{
	public static void main(String[] args) {
		Integer intgeter = 5;
		Object boolObject = true;
		
		int i = intgeter;
		System.out.println(i);

		if (boolObject != null && boolObject instanceof Boolean)
		{
			boolean b  = (Boolean)boolObject;
			System.out.println(b);
		}

	}
}
