import java.util.Queue;
import java.util.PriorityQueue;

public class PriorityQueueTest
{
	public static void main(String[] args) {
		// PriorityQueue.add(...)
		PriorityQueue priorityQueue = new PriorityQueue();
		priorityQueue.offer(1);
		priorityQueue.offer(-1);
		priorityQueue.offer(6);
		priorityQueue.offer(-3);
		priorityQueue.offer(20);
		priorityQueue.offer(18);
		System.out.println(priorityQueue);
		String pStr = String.valueOf(priorityQueue.peek());//peek 反回第一个元素，但是不出栈
		System.out.println(pStr);
		System.out.println(priorityQueue);
		String iStr = String.valueOf(priorityQueue.poll());
		System.out.println(iStr);
		System.out.println(priorityQueue);
	}
}
