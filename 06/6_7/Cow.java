public class Cow
{
	private double weight;

	public void setWeight(double weight) {
		this.weight = weight;
	}

	private class CowLeg
	{
		private double length;
		private String color;

		public CowLeg() {}
		public CowLeg(double length, String color) {
			this.length = length;
			this.color = color;
		}

		public void setLength(double length) {
			this.length = length;
		}

		public double getLength() {
			return length;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public String getColor() {
			return color;
		}

		public String toString() {
			return "Cow leg: lenght " + length + ", color " + color;
		}
	}

	public void test() {
		CowLeg cowLeg = new CowLeg(1.3, "red");
		System.out.println(cowLeg);

	}

	public static void main(String[] args) {
		Cow cow = new Cow();
		cow.test();
	}
}

