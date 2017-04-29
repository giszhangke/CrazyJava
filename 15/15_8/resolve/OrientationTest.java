import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;

public class OrientationTest {
	public static void main(String[] args) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test.txt"));
		     ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.txt"))) {
			oos.writeObject(Orientation.HORIZONTAL);
			Orientation ort = (Orientation)ois.readObject();
			System.out.println(Orientation.HORIZONTAL == ort);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
