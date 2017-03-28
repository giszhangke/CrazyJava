package ke;
import zhang.Output;

public class BetterPrinter implements Output
{
	private String[] printData = new String[MAX_CACHE_LINE * 2];
	private int dataNum = 0;

	//implements Output
	
	public void getData(String msg) {
		if (dataNum == MAX_CACHE_LINE * 2) {
			System.out.println("高速打印机已满！");
		} else {
			printData[dataNum++] = msg;
		}

	}

	public void out() {
		while (dataNum > 0) {
			System.out.println("高速正在打印输入：" + printData[0]);
			System.arraycopy(printData, 1, printData, 0, --dataNum);
		}
	}

	public static void main(String[] strs) {
		Output output = new Printer();
		output.getData("h1");
		output.getData("h2");
		output.out();

		Product product = new Printer();
	}

}

