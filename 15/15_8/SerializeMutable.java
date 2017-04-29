import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;

public class SerializeMutable {
	public static void main(String[] args) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("serializeMutable.txt"));
		     ObjectInputStream ois = new ObjectInputStream(new FileInputStream("serializeMutable.txt"))) {
			Person sun = new Person("齐天大圣", 500);
			oos.writeObject(sun);
			sun.setName("天蓬元帅");
			oos.writeObject(sun);
			Person sunUS = (Person)ois.readObject();
			Person sunUS2 = (Person)ois.readObject();
			System.out.println(sunUS == sunUS2);
			System.out.println(sun.getName() + (sun.getName() == sunUS.getName() ? " 等于 " : " 不等于 ") + sunUS.getName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
