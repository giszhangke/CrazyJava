import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class WriteTeacher {
	public static void main(String[] args) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("teacher.txt"));
		     ObjectInputStream ois = new ObjectInputStream(new FileInputStream("teacher.txt"))) {
			Person sun = new Person("孙悟空", 500);
			Teacher tan = new Teacher("唐僧", sun);
			Teacher puti = new Teacher("菩提祖师", sun);
			oos.writeObject(tan);
			oos.writeObject(puti);
			oos.writeObject(sun);
			oos.writeObject(puti);

			Teacher tan2 = (Teacher)ois.readObject();
			Teacher puti2 = (Teacher)ois.readObject();
			Person sun2 = (Person)ois.readObject();
			Teacher puti3 = (Teacher)ois.readObject();
			System.out.println(tan2.getStudent() == puti2.getStudent());
			System.out.println(puti2 == puti3);		
			System.out.println(tan2.getStudent() == sun2);	
		} catch (Exception ex) {
			ex.printStackTrace();
		}	
	}
}
