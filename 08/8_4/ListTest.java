import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Arrays;

class A {
	@Override
	public boolean equals(Object obj) {
		return true;
	}
}

public class ListTest {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add(new String("�����"));
		list.add(new String("���˽�"));		
		list.add(new String("��ɮ"));
		list.add(new String("ɳɮ"));
		System.out.println(list);
		list.add(2, new String("������"));
		System.out.println(list);
		list.remove(new String("�����"));
		System.out.println(list);
		System.out.println(list.indexOf(new String("��ɮ")));
		list.set(list.indexOf(new String("��ɮ")), new String("ţħ��"));
		System.out.println(list);
		System.out.println(list.subList(1,3));//index [1, 3)

		System.out.println("");	
		System.out.println(list);
		list.remove(new A());// new A().equals() ����true, ɾ���ɹ�
		System.out.println(list);
		list.remove(new A());// new A().equals() ����true, ɾ���ɹ�
		System.out.println(list);

		// sort()  replaceAll()
		System.out.println("");
		list = new ArrayList();
		list.add(new String("�����"));
		list.add(new String("�˽�"));		
		list.add(new String("����ʥɮ"));
		list.add(new String("ɳɮ"));
		System.out.println(list);
		list.sort((ea, eb) -> ((String)ea).length() - ((String)eb).length());//����: С->��
		System.out.println(list);
		list.replaceAll(ele -> "ʹ��" + (String)ele);
		System.out.println(list);

		// ListIterator
		System.out.println("");
		System.out.println("ListIterator:");
		List arrayList = list;
		ListIterator listIterator = arrayList.listIterator();
		while (listIterator.hasNext()) {
			listIterator.add("-------------");// ���д���ŵ� // 11 ������
			System.out.println(listIterator.next());
			// 11
		}
		System.out.println("================");
		while (listIterator.hasPrevious()) {
			System.out.println(listIterator.previous());
		}

		// Arrays.ArrayList
		System.out.println("");
		System.out.println("Arrays.ArrayList");
		List fixedList = Arrays.asList("�����ʥ", "����Ԫ˧", "��ʴ��" ,"̫���Ͼ�");
		System.out.println(fixedList.getClass());
		System.out.println(fixedList);
		// Arrays.ArrayList�ǲ��ɱ��࣬�����޸ģ��������д��뱨��
		//fixedList.remove(new String("����Ԫ˧"));
		//fixedList.add(new String("�����"));

	}
}
