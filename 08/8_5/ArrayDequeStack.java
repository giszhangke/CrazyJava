import java.util.ArrayDeque;

public class ArrayDequeStack
{
	public static void main(String[] args) {
		ArrayDeque arrayDequeStack = new ArrayDeque();
		arrayDequeStack.push("��ʥ");
		arrayDequeStack.push("����");
		arrayDequeStack.push("����");
		arrayDequeStack.push("ɳʦ��");
		System.out.println(arrayDequeStack);
		System.out.println(arrayDequeStack.peek());
		System.out.println(arrayDequeStack.pop());
		System.out.println(arrayDequeStack);
	}
}
