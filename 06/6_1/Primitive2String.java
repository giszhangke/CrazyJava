public class Primitive2String
{
	public static void main(String[] args) {
		String num = "456";
		Integer i = Integer.parseInt(num);
		Integer j = new Integer(num);
		System.out.println(i + " " + j);

		num = "4.56";
		float f = Float.parseFloat(num);
		float g = new Float(num);
		System.out.println(f + " " + g);

		String fStr = String.valueOf(4.35f);
		String dStr = String.valueOf(3.3322);
		String bStr = String.valueOf(true);
		System.out.println(fStr + " " + dStr + " " + bStr.toUpperCase());
	}
}
