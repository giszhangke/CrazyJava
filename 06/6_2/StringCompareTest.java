public class StringCompareTest
{
	public static void main(String[] args) {
		String s1 = "我是中国人";
		String s2 = "我是" + "中国人";		
		String s3 = "我是";		
		String s4 = "中国人";
		String s5 = s3 + s4;
		String s6 = new String("我是中国人");
		String s7 = "我" + "是" + "中" + "国人";

		System.out.println("s1 == s2 : " + (s1 == s2));		
		System.out.println("s1 == s5 : " + (s1 == s5));		
		System.out.println("s1 == s6 : " + (s1 == s6));					System.out.println("s1 == s7 : " + (s1 == s7));		
	}
}
