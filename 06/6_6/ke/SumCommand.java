package ke;

public class SumCommand implements Command 
{
	public void process(int[] array) {
		int sum = 0;

		for (int i : array) {
			sum += i;
		}

		System.out.println(sum);
	}
}

