import java.util.List;
import java.util.Deque;
import java.util.LinkedList;

public class LinkedListTest {
	public static void main(String[] args) {
		List linkedListList = new LinkedList();
		Deque linkedListDeque = new LinkedList();
		LinkedList linkedList = new LinkedList();
		linkedList.offer("��������");
		linkedList.push("��ʴ��");
		linkedList.offerFirst("��������");
		linkedList.push("Ԫʼ����");
		linkedList.offer("��������");
		System.out.println(linkedList);
		for (int i = 0; i < linkedList.size(); i++) {
			System.out.println(linkedList.get(i));
		}
		System.out.println(linkedList.peek());
		System.out.println(linkedList.peekFirst());
		System.out.println(linkedList.peekLast());
		System.out.println("");
		System.out.println(linkedList.pop());
		System.out.println(linkedList);
		System.out.println(linkedList.pollLast());
		System.out.println(linkedList);
		System.out.println(linkedList.isEmpty());
	}
}
