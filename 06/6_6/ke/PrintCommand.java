package ke;
import java.util.Arrays;

public class PrintCommand implements Command 
{
	public void process(int[] array) {
		System.out.println(Arrays.toString(array));
	}
}

