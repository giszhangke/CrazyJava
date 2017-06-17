import java.lang.reflect.Field;
class Person {
	private String name;
	private int age;
	@Override
	public String toString() {
		return "Person[name:" + name + ", age:" + age + "]";
	}
}
public class FieldTest {
	public static void main(String[] args) throws Exception {
		Person p = new Person();
		Class<Person> clazz = Person.class;
		Field nameField = clazz.getDeclaredField("name");	
		nameField.setAccessible(true);
		nameField.set(p, "科长");
		Field ageField = clazz.getDeclaredField("age");
		ageField.setAccessible(true);
		ageField.setInt(p, 20);
		System.out.println(p);
	}
}
