import java.io.Serializable;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

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

	@Override
	public String toString() {
		return "姓名：" + name + "\t年龄：" + age;
	}

	public void writeObject(ObjectOutputStream out) throws IOException {
		out.writeObject(new StringBuffer(name).reverse());	
		out.writeInt(age);
	}

	public void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		this.name = ((StringBuffer)in.readObject()).reverse().toString();
		this.age = in.readInt();
	}
}
