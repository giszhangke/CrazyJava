import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.HashSet;

/**
 * JavaBean�ĸ��� ��ĳ�Ա��������private��ͬʱ�ṩ��Ӧ��getter��setter
 **/
public class PersonJavaBean
{
	private int age;
	private String name;

	public void setAge(int age) {
		if (age > 120 || age < 0) {
			System.out.println("����������䲻����");
			return;
		} else {
			this.age = age;
		}
	}

	public int getAge() {
		return age;
	}

	public void setName(String name) {
		if (name.length() > 6 || name.length() < 1) {
			System.out.println("����������ֲ�����");
			return;
		} else {
			this.name = name;
		}
	}

	public String getName() {
		return name;
	}

	// ��дtoString����
	@Override
	public String toString() {
		return "Name:" + name + ", Age:" + age;
	}

	public static void main(String[] args) throws Exception {
		// ����̨������ص������� BufferedReader  InputStreamReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = "";
		PersonJavaBean person;
		Set<PersonJavaBean> personSet = new HashSet<PersonJavaBean>();		

		while((inputStr = br.readLine()) != null && inputStr.indexOf(",") > 0) {
			String[] inputStrSplitArray = inputStr.split(",");
 			person = new PersonJavaBean();
			person.setName(inputStrSplitArray[0]);
			person.setAge(Integer.parseInt(inputStrSplitArray[1]));
			
			personSet.add(person);		
			
		}
		
		// Java�е�foreach
		for (PersonJavaBean p : personSet) {
			// ��ӡʱ���õ��Ƕ����toString����
			System.out.println(p);
		}
	}
}
