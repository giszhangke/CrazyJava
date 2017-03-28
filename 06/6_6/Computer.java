package ke;
import zhang.Output;

public class Computer
{
	private Output output;
	
	public Computer(Output output) {
		this.output = output;
	}

	public void keyIn(String msg) {
		output.getData(msg);
	}

	public void print() {
		output.out();
	}
}


