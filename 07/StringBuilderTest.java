public class StringBuilderTest
{
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append("5678");	
		sb.insert(0, "01234");
		System.out.println(sb);	
		sb.replace(5, 6, ",");
		System.out.println(sb);		
		sb.delete(5,6);
		System.out.println(sb);
		sb.reverse();		
		System.out.println(sb);
		System.out.println(sb.length());
		System.out.println(sb.capacity());
		sb.setLength(5);
		System.out.println(sb);
	}
}
