public class GenderTest
{
	public static void main(String[] args) {
		Gender g = Gender.valueOf("MALE");
		g.setName("��");
		System.out.println(g.getName());
	}
}
