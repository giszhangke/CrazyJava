import java.util.ArrayDeque;

public class ArrayDequeStack
{
	public static void main(String[] args) {
		ArrayDeque arrayDequeStack = new ArrayDeque();
		arrayDequeStack.push("大圣");
		arrayDequeStack.push("长老");
		arrayDequeStack.push("呆子");
		arrayDequeStack.push("沙师弟");
		System.out.println(arrayDequeStack);
		System.out.println(arrayDequeStack.peek());
		System.out.println(arrayDequeStack.pop());
		System.out.println(arrayDequeStack);
	}
}
