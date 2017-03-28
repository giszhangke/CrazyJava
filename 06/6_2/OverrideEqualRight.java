class Person
{
	private String name;
	private int age;
	private int ID;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public int getID() {
		return ID;
	}

	@Override
	public boolean equals(Object person) {
		if (this == person)
		{
			return true;
		} else if (person != null && person.getClass() == Person.class && this.ID != 0) {
			System.out.println(this.ID + " " + ((Person)person).getID());
			return this.ID == ((Person)person).getID();
		}

		return false;
	}

	public static String info() {
		return "I'm God!";
	}
}

public class OverrideEqualRight
{
	public static void main(String[] args) {
		Person zhang = new Person();
		Person wang = new Person();

		zhang.setName("ke zhang");
		zhang.setAge(22);
		zhang.setID(888);
		
		wang.setName("ke zhang");		
		wang.setAge(22);
		wang.setID(6);

		System.out.println(zhang.equals(wang));
		wang.setID(888);
		System.out.println(zhang.equals(wang));

		Person pNon = null;
		System.out.println(pNon.info());

	}
}
