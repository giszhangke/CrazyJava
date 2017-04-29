import java.io.Serializable;

public class Person implements Serializable {
	private String name;
	private int age;
	
	public Person(String name, int age) {
		System.out.println("有参的构造函数！");
		this.name = name;
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return this.age;
	}
}
