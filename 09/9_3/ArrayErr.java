import java.util.Arrays;

public class ArrayErr {
	public static void main(String[] args) {
		Number[] n1 = new Number[10];
		Integer[] i1 = new Integer[10];

		n1 = i1;
		n1[0] = 3;
		//下面一行代码运行时报错，因为2.0是java.lang.Double类型
		n1[1] = 2.0;
		System.out.println(Arrays.toString(n1));
	}
}
