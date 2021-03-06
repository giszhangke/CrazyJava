import java.lang.reflect.Array;
import java.util.Arrays;

public class CrazyitArray {
	@SuppressWarnings("unchecked")
	public static <T> T[] newInstance(Class<T> contentType, int length) {
		return (T[])Array.newInstance(contentType, length);
	}
	public static void main(String[] args) throws Exception {
		String[] arr = CrazyitArray.newInstance(String.class, 10);
		arr[5] = "苏奎唱";
		int[][] intArr = CrazyitArray.newInstance(int[].class, 5);
		intArr[2] = new int[]{23, 89};
		System.out.println(arr[5]);
		System.out.println(intArr[2][1]);
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(intArr[2]));
	}
}
