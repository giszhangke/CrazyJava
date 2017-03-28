interface Product
{
	double getPrice();
	String getColor();
}

public class Anonymous
{
	public Anonymous(Product p) {
		System.out.println("Price: " + p.getPrice() + ", Color: " + p.getColor());
	}
	
	public static void main(String[] args) {
		new Anonymous(new Product(){
			public double getPrice() {
				return 38.2;
			}	

			public String getColor() {
				return "Red";
			}
		});
	}
}
