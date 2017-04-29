import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileInputStream;

public class WriteObject {
	public static void main(String[] args) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Object.txt"));
		     ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Object.txt"))) {
			Person per = new Person("孙大圣", 500);
			oos.writeObject(per);
			Person per2 = (Person)ois.readObject();
			System.out.print(per2.getName() + " " + per2.getAge());
		} catch (Exception oe) {
			oe.printStackTrace();
		}
	}
}
