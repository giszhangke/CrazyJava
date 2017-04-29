import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

public class TransientTest {
	public static void main(String[] args) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("transientTest.txt"));
		     ObjectInputStream ois = new ObjectInputStream(new FileInputStream("transientTest.txt"))) {
			Person xiaoMing = new Person("小明", 23);
			oos.writeObject(xiaoMing);
			Person xiaoMing2 = (Person)ois.readObject();
			System.out.println(xiaoMing2.getName() + " " + xiaoMing2.getAge());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
