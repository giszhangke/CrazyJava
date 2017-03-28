import ke.Command;
import ke.PrintCommand;
import ke.SumCommand;
import ke.ProcessArray;

public class CommandTest
{
	public static void main(String[] args) {
		int[] iArr = {1, 3, 8, 9};
		ProcessArray processArray = new ProcessArray();
		processArray.process(iArr, new PrintCommand());
		processArray.process(iArr, new SumCommand());		
	}	
}
