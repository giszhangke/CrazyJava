public enum Operation
{
	PLUS{
		public double eval(double a, double b) {
			return a + b;
		}
	},
	MINUS{
		public double eval(double a, double b) {
			return a - b;
		}
	};

	public abstract double eval(double a, double b);

	public static void main(String[] args) {
		Operation op = Operation.valueOf("PLUS");
		System.out.println(op.eval(3, 8));

		op = Operation.MINUS;
		System.out.println(op.eval(3, 8));
	}
}
