import java.util.ArrayDeque;

public class ArrayDequeQueue {
	public static void main(String[] args) {
		ArrayDeque arrayDequeQueue = new ArrayDeque();
		arrayDequeQueue.offer("��ʥ");
		arrayDequeQueue.offer("����");
		arrayDequeQueue.offer("����");
		arrayDequeQueue.offer("ɳʦ��");
		System.out.println(arrayDequeQueue);
		System.out.println(arrayDequeQueue.peek());
		System.out.println(arrayDequeQueue);
		System.out.println(arrayDequeQueue.poll());
		System.out.println(arrayDequeQueue);
	}
}