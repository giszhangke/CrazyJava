import java.util.List;
import java.util.ArrayList;

public class ListErr {
	public static void main(String[] args) {
		// 如果这里的list变量声明改为 List list
		// 则后面的line 15/16会报错
		List<String> list = new ArrayList<String>();

		list.add("大圣");
		list.add("太上老君");
		list.add("月老");
		//list.add(5);//这行代码会报错
		list.forEach(System.out::println);
		list.forEach(ele -> System.out.println(ele.length()));// line 15
		list.forEach(ele -> System.out.println((String)ele));// line 16
	}	
}
