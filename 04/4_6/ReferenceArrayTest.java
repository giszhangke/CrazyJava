class Person
{
	public int age;
	public double height;

	public void info(){
		System.out.println("My age is: " + age + ", my height is: " + height);
	}
}

public class ReferenceArrayTest
{
	public static void main(String[] args){
		Person[] students = new Person[2];
		//Person[] students;
		//students = new Person[2];
		Person zhang = new Person();
		zhang.age = 15;
		zhang.height = 158;
		Person lee = new Person();
		lee.age = 16;
		lee.height = 161;
		students[0] = zhang;
		students[1] = lee;
		lee.info();
		students[1].info();

	}
}
