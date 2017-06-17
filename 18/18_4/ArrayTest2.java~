import java.lang.reflect.Array;

public class ArrayTest2 {
	public static void main(String[] args) throws Exception {
		Object arr = Array.newInstance(String.class, 3, 4, 10);
		Object arrObj = Array.get(arr, 2);
		Array.set(arrObj, 3, new String[]{
			"春树暮云",
			"东走西顾"
		});
		Object anObj = Array.get(arrObj, 2);
		Array.set(anObj, 8, "易燃易爆小蜗");
		String[][][] cast = (String[][][])arr;
		System.out.println(cast[2][3][0]);
		System.out.println(cast[2][3][1]);
		System.out.println(cast[2][2][8]);
	}
}
