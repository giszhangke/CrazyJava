package ke;
import zhang.Output;

interface Product
{
	int getProduceTime();
}

public class Printer implements Product, Output
{
	private String[] printData = new String[MAX_CACHE_LINE];
	private int dataNum = 0;

	//implements Output
	
	public void getData(String msg) {
		if (dataNum == MAX_CACHE_LINE) {
			System.out.println("打印机已满！");
		} else {
			printData[dataNum++] = msg;
		}

	}

	public void out() {
		while (dataNum > 0) {
			System.out.println("正在打印输入：" + printData[0]);
			System.arraycopy(printData, 1, printData, 0, --dataNum);
		}
	}

	// implements Product
	
	public int getProduceTime() {
		return 20;
	}

	public static void main(String[] strs) {
		Output output = new Printer();
		output.getData("h1");
		output.getData("h2");
		output.out();

		Product product = new Printer();
		System.out.println("product.getProduceTime() " + product.getProduceTime());
	}

}
