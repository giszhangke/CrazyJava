public class GenderTest
{
	public static void main(String[] args) {
		Gender g = Gender.valueOf("FEMALE");
		System.out.print(g.getName());
		g.info();
	}
}
