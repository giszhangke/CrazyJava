public class StringCompareTest
{
	public static void main(String[] args) {
		String s1 = "�����й���";
		String s2 = "����" + "�й���";		
		String s3 = "����";		
		String s4 = "�й���";
		String s5 = s3 + s4;
		String s6 = new String("�����й���");
		String s7 = "��" + "��" + "��" + "����";

		System.out.println("s1 == s2 : " + (s1 == s2));		
		System.out.println("s1 == s5 : " + (s1 == s5));		
		System.out.println("s1 == s6 : " + (s1 == s6));					System.out.println("s1 == s7 : " + (s1 == s7));		
	}
}