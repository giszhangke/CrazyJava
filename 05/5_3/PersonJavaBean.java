import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.HashSet;

/**
 * JavaBean的概念 类的成员变量对是private，同时提供对应的getter和setter
 **/
public class PersonJavaBean
{
	private int age;
	private String name;

	public void setAge(int age) {
		if (age > 120 || age < 0) {
			System.out.println("您输入的年龄不合理！");
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
			System.out.println("您输入的名字不合理！");
			return;
		} else {
			this.name = name;
		}
	}

	public String getName() {
		return name;
	}

	// 重写toString方法
	@Override
	public String toString() {
		return "Name:" + name + ", Age:" + age;
	}

	public static void main(String[] args) throws Exception {
		// 控制台输入相关的两个类 BufferedReader  InputStreamReader
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
		
		// Java中的foreach
		for (PersonJavaBean p : personSet) {
			// 打印时调用的是对象的toString方法
			System.out.println(p);
		}
	}
}
