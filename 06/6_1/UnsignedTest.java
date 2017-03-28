public class UnsignedTest
{
	public static void main(String[] args) {
		System.out.println(Byte.parseByte("1010", 2));
		System.out.println(Integer.toBinaryString(-5));
		
		byte b = -3;
		byte a = 23;
		System.out.println("byte���͵�-3��Ӧ���޷���������" + Byte.toUnsignedInt(b));
		System.out.println("byte���͵�23��Ӧ���޷���������" + Byte.toUnsignedInt(a));

		int val = Integer.parseUnsignedInt("ab", 16);
		System.out.println("val-ab :" + val);

		System.out.println(Integer.toUnsignedString(-12, 16));
		System.out.println(Integer.divideUnsigned(-2, 3));
		System.out.println(Integer.remainderUnsigned(-2, 3));
					
	}

}
