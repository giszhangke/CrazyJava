package ke;
import zhang.Output;

public class OutputFactory
{
	public static Output getOutput() {
		return new BetterPrinter();
	}

	public static void main(String[] args) {
		Computer computer = new Computer(OutputFactory.getOutput());
		computer.keyIn("wow!");
		computer.print();
	}
}
