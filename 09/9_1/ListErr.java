import java.util.List;
import java.util.ArrayList;

public class ListErr {
	public static void main(String[] args) {
		// ��������list����������Ϊ List list
		// ������line 15/16�ᱨ��
		List<String> list = new ArrayList<String>();

		list.add("��ʥ");
		list.add("̫���Ͼ�");
		list.add("����");
		//list.add(5);//���д���ᱨ��
		list.forEach(System.out::println);
		list.forEach(ele -> System.out.println(ele.length()));// line 15
		list.forEach(ele -> System.out.println((String)ele));// line 16
	}	
}