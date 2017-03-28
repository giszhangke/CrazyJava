import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public class ArraysTest2
{
	public static void main(String[] args)
	{
		int[] arr1 = new int[]{3, -4, 25, 16, 30, 18};
		Arrays.parallelSort(arr1);
		System.out.println(Arrays.toString(arr1));
		
		int[] arr2 = new int[]{3, -4, 25, 16, 30, 18};
		Arrays.parallelPrefix(arr2, new IntBinaryOperator(){
			public int applyAsInt(int x, int y)
			{
				return x * y;
			}
		});
		//Arrays.parallelPrefix(arr2, (x,y) -> x * y);
		System.out.println(Arrays.toString(arr2));
	
		int[] arr3 = new int[5];
		Arrays.parallelSetAll(arr3, operand -> operand * 5);//operand 为数组下标
		System.out.println(Arrays.toString(arr3));
			
	}

}
