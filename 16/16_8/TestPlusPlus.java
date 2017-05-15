public class TestPlusPlus {
	public static void main(String[] args) {
		int j = 0;
		
		for (int i = 0; i < 100; i++ ) {
			j = ++j;
			//j = j++;
			/*
			j = j;
			j = j + 1;
			 */
		}

		System.out.println(j);
		int k = 0;
		k = k++;
		System.out.println(k);
	}
}
