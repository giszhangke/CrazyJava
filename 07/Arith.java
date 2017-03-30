import java.math.BigDecimal;

public class Arith
{
	public static final int DEF_DIV_SCALE = 10;

	public static double add(double a, double b) {
		BigDecimal b1 = BigDecimal.valueOf(a);
		BigDecimal b2 = BigDecimal.valueOf(b);		
		return b1.add(b2).doubleValue();
	}

	public static double subtract(double a, double b) {
		BigDecimal b1 = BigDecimal.valueOf(a);
		BigDecimal b2 = BigDecimal.valueOf(b);
		return b1.subtract(b2).doubleValue();
	}

	public static double multiply(double a, double b) {
		BigDecimal b1 = BigDecimal.valueOf(a);
		BigDecimal b2 = BigDecimal.valueOf(b);
		return b1.multiply(b2).doubleValue();
	}

	public static double divide(double a, double b) {
		BigDecimal b1 = BigDecimal.valueOf(a);
		BigDecimal b2 = BigDecimal.valueOf(b);
		return b1.divide(b2, DEF_DIV_SCALE, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public static void main(String[] args) {
		System.out.println("0.05001 + 0.03021 = " + add(0.05001, 0.03021));		
		System.out.println("0.05001 - 0.03021 = " + subtract(0.05001, 0.03021));
		System.out.println("0.05001 * 2.0 = " + multiply(0.05001, 2.0));		
		System.out.println("0.05001 / 2.0 = " + divide(0.05001, 2.0));		
	}
}

